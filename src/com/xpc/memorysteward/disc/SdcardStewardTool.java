package com.xpc.memorysteward.disc;

import java.io.File;

import android.os.Environment;

public class SdcardStewardTool extends StewardTool{

	private String mPath;
	
	public SdcardStewardTool(String path) {
		super(new File(path));
		mPath = path;
	}

	@Override
	public void clear() {
		Util.deleteFolderRecursion(getSDPath()+mPath);
	}

	@Override
	public File getDirectory() {
		// TODO Auto-generated method stub
		return new File(getSDPath()+mPath);
	}

	private static String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// 获取跟目录
		}
		return sdDir.toString()+"/";

	}
}
