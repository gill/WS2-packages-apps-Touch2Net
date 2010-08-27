package com.camangi.touch2net;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/*
 * Step (1) Check 3G(UMTS) : Yes -> Run Browser  -> finish()
 *                           No  -> Step (2)
 *                           
 * Step (2) Check WiFi  :    Yes -> Run Browser  -> finish()
 *                           No  -> Step (3)
 * 
 * Step (3) enable WiFi :    Yes -> Run Browser  -> finish()
 *                           No  -> WiFi Setting -> Step(4)
 *                           
 * Step (4) WiFi List   :    Yes -> Run Browser  -> finish()
 *                           No  -> Step (5)
 *                           
 * Step (5) Do nothing and finish application
 */

public class Main extends Activity {
	public RunBrowser run_browser;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		try {
			Intent it = new Intent();
			it.setComponent(new ComponentName("com.camangi.netconnect",
					"com.camangi.netconnect.Main"));
			startActivityForResult(it, 1);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(this, R.string.noActivity, Toast.LENGTH_LONG).show();
			finish();
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && data != null) {
			if(data.getExtras().getBoolean("net_OK")){
				run_browser = new RunBrowser();
				run_browser.StartRunBrowser(Main.this);
			}
		}
		finish();
	}

}