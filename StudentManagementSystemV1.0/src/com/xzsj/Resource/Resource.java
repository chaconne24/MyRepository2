package com.xzsj.Resource;

/**
 * 	资源对象
 * @author John
 *
 */
public class Resource {
	private String id;
	private String displayname;
	private String realName;
	private String size;
	private String path;
	private String type;
	
	public Resource() {}
	public Resource(String id, String displayname, String realName, 
			String size, String path, String type) {
		this.id = id;
		this.displayname = displayname;
		this.realName = realName;
		this.size = size;
		this.path = path;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
}
