package org.huzair.entities;

public class Customer {	

	private String cid;
	private String name;
	private String street;
	private String zip;
	private String phone;
	private String email;

	public Customer(String name, String street, String zip, String phone, String email){
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.street = street;
		this.phone = phone;
		this.email = email;
	}
	public Customer(Customer another){
		this.name = another.name;
		this.street = another.street;
		this.zip = another.zip;
		this.street = another.street;
		this.phone = another.phone;
		this.email = another.email;
	}

	public String getCid() {
		return this.cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public boolean matchesId(String cid) {
		return(this.cid.equalsIgnoreCase(cid));
	}
	public String getName() {
		return name;
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
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setCustomer(Customer c){
		name = c.getName();
		street = c.getStreet();
		zip = c.getZip();
		phone = c.getPhone();
		email = c.getEmail();
}

	//Mark
	public boolean validate() {
		if(name!=null && street!= null && zip!=null && phone!=null && email!=null)
			return true;
		return false;
	}
	
	
	public boolean match(String keyword) {
		String all = name+" "+street+" "+zip+" "+phone+" "+email;
		all = all.toLowerCase();
		return all.matches(".*\\b" + keyword + "\\b.*");
	}
}
