package com.maxdexter.authapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthFragment extends Fragment {

    private EditText mLogin;
    private EditText mPassword;
    private Button mEnter;
    private Button mRegister;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_auth,container,false);
        initUI(view);
        btnListener();
        return view;
    }

    private void initUI(View view) {
        mLogin = view.findViewById(R.id.et_login);
        mPassword = view.findViewById(R.id.et_password);
        mEnter = view.findViewById(R.id.btn_enter);
        mRegister = view.findViewById(R.id.btn_register);
    }

    private void btnListener() {
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid() && isPasswordValid()){
                    Intent intent = new Intent(getContext(), ProfileActivity.class);
                    intent.putExtra(ProfileActivity.USER_KEY,new User(mLogin.getText().toString(),mPassword.getText().toString()));
                    startActivity(intent);
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
        Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
    }

    public static AuthFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AuthFragment fragment = new AuthFragment();
        fragment.setArguments(args);
        return fragment;
    }
}