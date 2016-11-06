package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
	
static AtomicInteger atomicInteger = new AtomicInteger();
private int cid;
private String name;
private String street;
private String zip;
private String phone;
private String email;

public Customer(String name, String street, String zip, String phone, String email){
	this.cid = atomicInteger.incrementAndGet();
	this.name = name;
	this.street = street;
	this.zip = zip;
	this.phone = phone;
	this.email = email;
}

public int getCid() {
    return this.cid;
}

public boolean matchesId(int cid) {
    return(cid == this.cid);
}

}
