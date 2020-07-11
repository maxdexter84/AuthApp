package com.maxdexter.authapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        if(savedInstanceState == null){
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.fragment_container);
            if(fragment == null){
                fragment = getFragment();
                fm.beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }

        }
    }

    protected abstract Fragment getFragment();
}