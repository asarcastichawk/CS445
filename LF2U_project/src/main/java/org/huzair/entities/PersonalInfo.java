package org.huzair.entities;

public class PersonalInfo {
String name;
String email;
String phone;

public PersonalInfo(String name, String email, String phone)
{
	this.name = name;
	this.email = email;
	this.phone = phone;
}
public boolean validate(){
	if(name!=null && email!= null && phone!=null)
		return true;
	return false;
}
}
