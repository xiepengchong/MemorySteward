package com.xpc.memorysteward.disc;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class StewardToolManager {

	private static StewardToolManager mInstance = null;
	
	private static List<StewardTool> tools = new ArrayList<StewardTool>();
	
	public static StewardToolManager getInstance(){
		
		if(mInstance == null)
		{
			mInstance = new StewardToolManager();
		}
		return mInstance;
	}
	
	public void registerSteward(StewardTool tool){

		boolean hasExist = false;
		if(tool instanceof StewardTool){
			for(StewardTool tl:tools){
				if(tl.getDirectory().getPath().equals(tool.getDirectory().getPath())){
					hasExist = true;
				}
			}
			if(!hasExist)
				tools.add(tool);
		}
	}
	
	public void unregisterSteward(StewardTool tool){
		if(tool instanceof StewardTool){
			tools.remove(tool);
		}
	}
	
	public void clear(){
		
		AsyncTask<Object, Object, Object> task = new AsyncTask<Object, Object, Object>(){
			@Override
			protected Object doInBackground(Object... arg0) {
				// TODO Auto-generated method stub
				for(StewardTool tool : tools){
					tool.clear();
				}
				return null;
			}
		};
		task.execute();
	}

	public void unregisterSteward() {
		tools.removeAll(tools);
	}

}
