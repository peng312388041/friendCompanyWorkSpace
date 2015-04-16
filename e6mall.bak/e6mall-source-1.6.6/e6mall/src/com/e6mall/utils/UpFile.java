package com.e6mall.utils;

public class UpFile {
	private String name;
	private String path;
	private String length;
	private String lastedit;
	private String filetype;
	private String parentfile;
	private boolean isDir;
	private boolean isFile;
	private boolean isHidden;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getLastedit() {
		return lastedit;
	}
	public void setLastedit(String lastedit) {
		this.lastedit = lastedit;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getParentfile() {
		return parentfile;
	}
	public void setParentfile(String parentfile) {
		this.parentfile = parentfile;
	}
	public boolean isDir() {
		return isDir;
	}
	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}
	public boolean isFile() {
		return isFile;
	}
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
}
