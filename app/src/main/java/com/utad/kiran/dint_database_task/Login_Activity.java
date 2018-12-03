package com.utad.kiran.dint_database_task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity{
    public static  final String KEY_USER_NAME = "KEY_USER_NAME";
    private EditText email ;
    private EditText pass ;
    private boolean emailFull = false;
    private boolean passFull = false;
    private Button loginButton;
    private String mail;
    private int password;
    public static String USER = "USER";
    private User user;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        user = new User();
        checkMail();
        checkPass();
    }

    public void checkMail() {
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                emailFull = false;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (email.getText().toString().isEmpty()){
                    loginButton.setEnabled(false);
                } else {
                    loginButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                emailFull = true;
            }
        });
    }

    public void checkPass() {
        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                passFull = false;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (pass.getText().toString().isEmpty() || pass.getText().length() < 6){
                    loginButton.setEnabled(false);
                } else {
                    loginButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                passFull = true;
            }
        });
    }

    public void pass(View view){
        Intent intent = new Intent(Login_Activity.this, Form_Activity.class);
        if(emailFull && passFull) {
            startActivity(intent);
        }else{
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            "Rellene los campos", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }
}
