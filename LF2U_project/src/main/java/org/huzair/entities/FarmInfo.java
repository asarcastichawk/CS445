package org.huzair.entities;

public class FarmInfo {
	private String name;
	private String address;
	private String phone;
	private String web;
	
	public FarmInfo(String name,String address ,String phone, String web)
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.web = web;
	}
	
	public boolean validate(){
		if(name!=null && address!= null && phone!=null)
			return true;
		return false;
	}
	public String getFarmName(){
		return name;
	}
	public boolean match(String keyword){
		String all = name+" "+address+" "+phone+" "+web;
		all = all.toLowerCase();
		return all.matches(".*\\b" + keyword + "\\b.*");
	}
}