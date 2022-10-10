package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    private Button btSignIn,btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        EditText username= (EditText) findViewById(R.id.username);
        EditText password= (EditText) findViewById(R.id.password);
        btSignIn = (Button) findViewById(R.id.bt_signin);
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (username.getText().toString().equals("tuong123")&&password.getText().toString().equals("12345")){
                    openProfile();
//                }
//                else{
//                    Toast.makeText(SignInActivity.this,"Login failed",Toast.LENGTH_SHORT).show();}
            }
        });

        btSignUp = (Button) findViewById(R.id.bt_signup);
        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });
    }
    public void openProfile(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openSignUp(){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}