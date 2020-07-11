package com.maxdexter.authapp;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                if(isEmailValid() && isPasswordValid()){
                    //переходв приложение
                }else{
                    showMessage(R.string.login_input_error);
                }
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private Boolean isEmailValid(){
        return !TextUtils.isEmpty(mLogin.getText()) && Patterns.EMAIL_ADDRESS.matcher(mLogin.getText()).matches();
    }
    private Boolean isPasswordValid(){
        return !TextUtils.isEmpty(mPassword.getText());
    }

    private void showMessage(@StringRes int str){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}