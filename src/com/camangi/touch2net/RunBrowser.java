package com.camangi.touch2net;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class RunBrowser {	
	public void StartRunBrowser(Context context){
		Intent it = new Intent();
		it.setComponent(new ComponentName("com.android.browser", "com.android.browser.BrowserActivity"));
		context.startActivity(it);
		
	}
	
}