package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
	

private int cid;
private String name;
private String street;
private String zip;
private String phone;
private String email;

public Customer(String name, String street, String zip, String phone, String email){
	this.setName(name);
	this.setStreet(street);
	this.setZip(zip);
	this.setPhone(phone);
	this.setEmail(email);
}

public int getCid() {
    return this.cid;
}
public void setCid(int cid) {
    this.cid = cid;
}

public boolean matchesId(int cid) {
    return(cid == this.cid);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public void setCustomer(Customer c){
	name = c.getName();
	street = c.getStreet();
	zip = c.getZip();
	phone = c.getPhone();
	email = c.getEmail();
}

}
