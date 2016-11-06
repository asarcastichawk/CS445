package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductCatalog {
	static AtomicInteger atomicInteger = new AtomicInteger();
	private int gcpid;
	String name;
	
	public ProductCatalog(String name){
		gcpid = atomicInteger.incrementAndGet();
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	

}
