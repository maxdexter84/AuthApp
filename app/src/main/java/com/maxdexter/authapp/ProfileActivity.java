package com.maxdexter.authapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater =  getMenuInflater();
       inflater.inflate(R.menu.profile_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_logout:
                startActivity(new Intent(this,AuthActivity.class));
                finish();
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }
}
