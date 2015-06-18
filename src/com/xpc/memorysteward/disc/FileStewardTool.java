package com.xpc.memorysteward.disc;

import java.io.File;

public class FileStewardTool extends StewardTool{

	private File mPath;
	
	public FileStewardTool(File path) {
		super(path);
		mPath = path;
	}

	@Override
	public void clear() {
		Util.deleteFileRecursion(mPath);
		
	}

	@Override
	public File getDirectory() {
		// TODO Auto-generated method stub
		return mPath;
	}

}
