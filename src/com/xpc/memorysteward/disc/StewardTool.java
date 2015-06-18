package com.xpc.memorysteward.disc;

import java.io.File;

public abstract class StewardTool {

	protected StewardTool(File path) {
	}
	
	public abstract void clear();
	
	public abstract File getDirectory();
}
