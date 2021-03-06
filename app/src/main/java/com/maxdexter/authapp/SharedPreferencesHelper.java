package com.maxdexter.authapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME ="SHARED_PREF_NAME";
    public static final String USERS_KEY ="USERS_KEY";
    public static final Type USERS_TYPE = new TypeToken<List<User>>(){}.getType();
    Gson mGson = new Gson();
    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    }

    public List<User> getUsers(){
        List<User> users = mGson.fromJson(mSharedPreferences.getString(USERS_KEY," "),USERS_TYPE);
        return users == null? new ArrayList<User>(): users;
    }
    public Boolean addUser(User user){
        List<User> users = getUsers();
        for (User u: users) {
            if(u.getLogin().equalsIgnoreCase(user.getLogin())) return false;

        }
        users.add(user);
        mSharedPreferences.edit().putString(USERS_KEY,mGson.toJson(users,USERS_TYPE)).apply();
        return true;
    }

    public List<String> getSuccessLogin(){
        List<String> loginUsers = new ArrayList<>();
        for(User user: getUsers()){
            loginUsers.add(user.getLogin());
        }
        return loginUsers;
    }

    public User login(String login, String password){
        List<User> users = getUsers();
        for (User u: users) {
            if(login.equalsIgnoreCase(u.getLogin()) && password.equals(u.getPassword())){
                u.setHasSuccessLogin(true);
                mSharedPreferences.edit().putString(USERS_KEY,mGson.toJson(users,USERS_TYPE)).apply();
                return u;
            }
        }
        return null;
    }
}
