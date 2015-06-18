package com.xpc.memorysteward;

import java.io.File;

import com.xpc.memorysteward.disc.CacheStewardTool;
import com.xpc.memorysteward.disc.FileStewardTool;
import com.xpc.memorysteward.disc.SdcardStewardTool;
import com.xpc.memorysteward.disc.StewardToolManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private StewardToolManager manager;
	private CacheStewardTool cacheTool;
	private FileStewardTool fileTool;
	private SdcardStewardTool sdcardTool;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager = StewardToolManager.getInstance();
		cacheTool = new CacheStewardTool(this.getCacheDir());
		fileTool = new FileStewardTool(this.getFilesDir());
		sdcardTool = new SdcardStewardTool("edugate");
		manager.registerSteward(cacheTool);
		manager.registerSteward(fileTool);
		manager.registerSteward(sdcardTool);
		
		manager.clear();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		manager.unregisterSteward();
		super.onDestroy();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
