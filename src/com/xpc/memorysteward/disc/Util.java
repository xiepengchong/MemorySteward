package com.xpc.memorysteward.disc;

import java.io.File;

import android.util.Log;

public class Util {

	public static void deleteFolderRecursion(String path){
		File file = new File(path);
		deleteFileRecursion(file);
	}
	
	public static void deleteFileRecursion(File file){
		Log.v("XPC","file="+file.getPath());
		if(file.isFile()){
			file.delete();
			return;
		}
		
		if(file.isDirectory()){
			File[] childFiles = file.listFiles();
			if(childFiles == null || childFiles.length == 0){
				file.delete();
				return;
			}
			
			for(File childFile : childFiles){
				deleteFileRecursion(childFile);
			}
			file.delete();
		}
	}
	
}
