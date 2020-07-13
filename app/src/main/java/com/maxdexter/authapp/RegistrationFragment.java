package com.maxdexter.authapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {
    private EditText mLogin;
    private EditText mPassword;
    private EditText mPasswordAgain;
    private Button mRegistration;
    SharedPreferencesHelper mSharedPreferences;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance() {
        RegistrationFragment fragment = new RegistrationFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_registration, container, false);
        initUI(view);
        mSharedPreferences = new SharedPreferencesHelper(Objects.requireNonNull(getContext()));
        mRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isInputValid()){
                    User user = new User(mLogin.getText().toString(),mPassword.getText().toString());
                   boolean isAdded = mSharedPreferences.addUser(user);
                   if(isAdded){
                       showMessage(R.string.user_added_success);
                       getFragmentManager().popBackStack();
                   }else{
                       showMessage(R.string.login_input_error);
                   }
                }
            }
        });
        return view;
    }

    private void initUI(View view) {
        mLogin = view.findViewById(R.id.etLogin);
        mPassword = view.findViewById(R.id.etPassword);
        mPasswordAgain = view.findViewById(R.id.etPasswordAgain);
        mRegistration = view.findViewById(R.id.btnRegistration);
    }

    private Boolean isEmailValid(){
        return !TextUtils.isEmpty(mLogin.getText()) && Patterns.EMAIL_ADDRESS.matcher(mLogin.getText()).matches();
    }
    private Boolean isPasswordValid(){
        String password = mPassword.getText().toString();
        String passwordAgain = mPasswordAgain.getText().toString();
        return password.equals(passwordAgain) && !TextUtils.isEmpty(mPassword.getText().toString()) && !TextUtils.isEmpty(mPasswordAgain.getText().toString());
    }

    private Boolean isInputValid(){
        return isEmailValid() && isPasswordValid();
    }
    private void showMessage(@StringRes int str){
        Toast.makeText(getContext(), str, Toast.LENGTH_LONG).show();
    }
}