package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey,"").equals("")) {
            String username = sharedPreferences.getString("username","");
            goToActivity2(username);
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_main);
        }

    }

    public void goToActivity2(String username) {
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("message",username);
        startActivity(intent);

    }

    public void onButtonClick(View view) {
        Log.i("info","Button Pressed!");
        EditText usernameText = (EditText) findViewById(R.id.userNameText);
        String str = usernameText.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", MODE_PRIVATE);
        sharedPreferences.edit().putString("username",str).apply();
        goToActivity2(str);

    }
}
