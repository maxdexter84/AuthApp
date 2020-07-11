package com.maxdexter.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {
    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_auth);

        initUI();

        btnListener();
    }

    private void initUI() {
        mLogin = findViewById(R.id.et_login);
        mPassword = findViewById(R.id.et_password);
        mEnter = findViewById(R.id.btn_enter);
        mRegister = findViewById(R.id.btn_register);
    }

    private void btnListener() {
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}