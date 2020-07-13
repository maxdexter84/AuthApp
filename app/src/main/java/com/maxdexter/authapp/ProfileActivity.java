package com.maxdexter.authapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class ProfileActivity  extends AppCompatActivity {
    public static final String USER_KEY = "EMAIL_KEY";
    private static final int REQUEST_CODE_PHOTO = 101;

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

        mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
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

    private void openGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,REQUEST_CODE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_PHOTO && resultCode == Activity.RESULT_OK && data != null){
            Uri photoUri = data.getData();
            mPhoto.setImageURI(photoUri);
        }else  super.onActivityResult(requestCode, resultCode, data);

    }
}
