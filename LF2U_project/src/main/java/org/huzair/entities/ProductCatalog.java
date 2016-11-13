package org.huzair.entities;


public class ProductCatalog {
	private int gcpid;
	private String name;
	
	public ProductCatalog(String name){
		this.name = name;
	}
	public ProductCatalog(ProductCatalog p){
		this.name = p.getName();
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public int getGcpid() {
		return gcpid;
	}

	public void setGcpid(int gcpid) {
		this.gcpid = gcpid;
	}
	
	public void setProduct(ProductCatalog p){
		name = p.getName();
	}
	
	public boolean matchesId(int gcpid) {
	    return(gcpid == this.gcpid);
	}
	public boolean validate(){
		if(this.name!=null)
			return true;
		return false;
	}

}

