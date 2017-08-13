package com.example.test.myapplication;

/**
 * Created by liye on 2017/8/13.
 */

public interface LoginInteractor {

        interface onLoginFinishedListener{

            void onUserNameError();

            void onPasswordError();

            void onLoginSuccess();
        }

    void login(String userName,String password, onLoginFinishedListener listener);

}
