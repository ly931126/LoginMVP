package com.example.test.myapplication;

/**
 * Created by liye on 2017/8/13.
 */

public class LoginPresentImp implements LoginPresenter, LoginInteractor.onLoginFinishedListener {
	
	private LoginView		mLoginView			= null;
	private LoginInteractor	mLoginInteractor	= null;
	
	public LoginPresentImp(LoginView loginView) {
		this.mLoginView = loginView;
		this.mLoginInteractor = new LoginInteractorImp();
	}
	@Override
	public void testLogin(String userName, String password) {
		mLoginInteractor.login(userName, password, this);
	}

    @Override
    public void onDestroy() {
        mLoginView=null;
    }

    @Override
	public void onUserNameError() {
        if(mLoginView!=null)
            mLoginView.setUserNameError();
		
	}
	
	@Override
	public void onPasswordError() {
        if(mLoginView!=null)
            mLoginView.setPasswordError();
	}
	
	@Override
	public void onLoginSuccess() {
	if(mLoginView!=null)
        mLoginView.setLoginSuccess();
	}
}
