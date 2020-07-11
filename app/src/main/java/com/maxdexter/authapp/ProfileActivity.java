package com.maxdexter.authapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class ProfileActivity  extends AppCompatActivity {
    public static final String USER_KEY = "EMAIL_KEY";

    AppCompatImageView mPhoto;
    TextView mLogin;
    TextView mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_profile);

        mPhoto = findViewById(R.id.iv_photo);
        mLogin = findViewById(R.id.tv_email);
        mPassword = findViewById(R.id.tv_password);

        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.get(USER_KEY);

        mLogin.setText(user.getLogin());
        mPassword.setText(user.getPassword());
    }


}
