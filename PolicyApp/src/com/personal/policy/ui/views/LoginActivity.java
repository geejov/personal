package com.personal.policy.ui.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.personal.policy.R;

public class LoginActivity extends Activity {
	
	private ProgressDialog dialog ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.login);
		super.onCreate(savedInstanceState);
		
		Button btnSignIn = (Button) findViewById(R.id.btnLogin);
		btnSignIn.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final String username = ((EditText) findViewById(R.id.txtUser)).getText().toString();
				final String password = ((EditText) findViewById(R.id.txtPassword)).getText().toString();
				dialog = ProgressDialog.show(LoginActivity.this, "", "Signing In...");
				
				Thread t = new Thread() {
					@Override
					public void run() {
						try {
							authenticate(username, password);
							dialog.dismiss();

							Intent i = new Intent ( LoginActivity.this, HomeActivity.class);
							startActivity(i);
						}
						catch(Exception e) {
							dialog.dismiss();
							System.out.println("Sign in failed");
							
							runOnUiThread( new Runnable () {
								public void run() {
									showAlert("Signin failed...");
								};
							});
							
						}
					}
				};
				
				t.start();
			}
		});
	}
	
	private boolean authenticate ( String username, String password ) throws Exception {
		
		Thread.sleep(1000);
		return true;
//		if ( "admin".equalsIgnoreCase(username) && "pwd".equalsIgnoreCase(password)) {
//			return true;
//		}
//		else
//			throw new Exception ( "Login failed");
	}
	
	private void showAlert ( String text ) {
		Builder builder = new Builder(this);
		AlertDialog alert = builder.create();
		alert.setTitle("Alert");
		alert.setMessage(text);
		alert.show();
	}

}
