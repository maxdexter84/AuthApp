package com.maxdexter.authapp;

import android.app.Activity;

import androidx.fragment.app.Fragment;

public class AuthActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return AuthFragment.newInstance();
    }
}
