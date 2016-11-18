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
public boolean match(String keyword){
	String all = name+" "+email+" "+phone+" "+phone;
	all = all.toLowerCase();
	return all.matches(".*\\b" + keyword + "\\b.*");
}
public String getName() {
	return name;
}
}
