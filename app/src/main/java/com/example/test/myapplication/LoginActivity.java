package com.example.test.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

	@BindView(R.id.user)
	EditText				mUser;
	@BindView(R.id.password)
	EditText				mPassword;
	@BindView(R.id.login)
	Button					mLogin;

	private LoginPresenter	mLoginPresenter	= null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		mLogin.setOnClickListener(this);
		mLoginPresenter = new LoginPresentImp(this);
	}

	@Override
	protected void onDestroy() {
		mLoginPresenter.onDestroy();
		super.onDestroy();
	}

	@Override
	public void setUserNameError() {
		mUser.setError(getString(R.string.user_name_error));
	}

	@Override
	public void setPasswordError() {
		mPassword.setError(getString(R.string.password_error));
	}

	@Override
	public void setLoginSuccess() {
		startActivity(new Intent(this, SecondActivity.class));
//		finish();
	}

	@Override
	public void onClick(View v) {
		mLoginPresenter.testLogin(mUser.getText().toString(), mPassword.getText().toString());
	}
}
