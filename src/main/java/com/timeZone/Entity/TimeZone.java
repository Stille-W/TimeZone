package com.timeZone.Entity;

import javax.persistence.Entity;

@Entity
public class TimeZone {
	private	String name;
	private	String sysName;
	
	public TimeZone() {
		
	}

	public TimeZone(String name, String sysName) {
		this.name = name;
		this.sysName = sysName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	
	@Override
	public String toString() {
		return "TimeZone [name=" + name + ", sysName=" + sysName + "]";
	}
	
}
