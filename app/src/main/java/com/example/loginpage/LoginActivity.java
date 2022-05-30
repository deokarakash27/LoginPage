package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        login();
    }

    private void init(){
        login = findViewById(R.id.btnlogin);
        email = findViewById(R.id.edtTxtEmail);
        password = findViewById(R.id.edtTxtPassword);
    }
    private void login() {

        String emailId = "teamlease@regtech.com";
        String correctPassword = "tlrt@1234";

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(email.getText().toString() != null
                        && !email.getText().toString().isEmpty()
                        && password.getText().toString() != null
                        && !password.getText().toString().isEmpty()
                        && Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){

                    if ( email.getText().toString().equalsIgnoreCase(emailId)
                            && password.getText().toString().equalsIgnoreCase(correctPassword)) {

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("emailId", emailId);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(LoginActivity.this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}