package com.example.test.myapplication;

import android.os.Handler;

/**
 * Created by liye on 2017/8/13.
 */

public class LoginInteractorImp implements LoginInteractor {
	
	@Override
	public void login(final String userName, final String password, final onLoginFinishedListener listener) {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if(!userName.equals("liye")) {
                    listener.onUserNameError();
                }
                if(!password.equals("931126")){
                    listener.onPasswordError();
                }
                if(userName.equals("liye")&&password.equals("931126")){
                    listener.onLoginSuccess();
                }

			}
		}, 2000);
	}
}
