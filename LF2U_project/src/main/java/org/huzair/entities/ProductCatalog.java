package org.huzair.entities;


public class ProductCatalog {
	private String gcpid;
	private String name;
	
	public ProductCatalog(String name){
		this.name = name;
	}
	public ProductCatalog(ProductCatalog p){
		this.name = p.getName();
	}
	
	
	public String getName(){
		return name;
	}
	
	public String getGcpid() {
		return gcpid;
	}

	public void setGcpid(String gcpid) {
		this.gcpid = gcpid;
	}
	
	public void setProduct(ProductCatalog p){
		name = p.getName();
	}
	
	public boolean matchesId(String gcpid) {
	    return(this.gcpid.equalsIgnoreCase(gcpid));
	}
	public boolean validate(){
		if(this.name!=null)
			return true;
		return false;
	}

}

