package com.example.admin.androidsmartcity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {

        if (v.getId() == R.id.Blogin) {

            EditText a = (EditText) findViewById(R.id.Tfusername);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.Tfpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if (pass.equals(password)) {

                Intent i = new Intent(MainActivity.this, Display.class);
                i.putExtra("Username", str);
                startActivity(i);

            } else {
                Toast temp = Toast.makeText(MainActivity.this, "Username and Passwords don't match", Toast.LENGTH_SHORT);
                temp.show();
            }
        }

        if (v.getId() == R.id.Bsignup) {
            Intent i = new Intent(MainActivity.this, Signup.class);
            startActivity(i);

        }

    }
}
