package org.huzair.entities;

public class StoreProduct {
	private String fspid;
	private String name = "";
	private String gcpid;
	private String note = "";
	private String start_date = "";
	private String end_date = "";
	private double price;
	private String product_unit;
	private String image = "";
	
	public StoreProduct(String gcpid, String note, String start_date, String end_date, double price, String product_unit, String image){
		this.gcpid = gcpid;
		this.note =note;
		this.start_date =start_date;
		this.end_date =end_date;
		this.price =price;
		this.product_unit =product_unit;
		this.image =image;
	}
	
	public boolean matchesId(String fspid) {
	    return(this.fspid.equalsIgnoreCase(fspid));
	}

	public String getNote() {
		return note;
	}
	public void setGcpid(String gcpid){
		this.gcpid = gcpid;
	}
	public String getStartDate() {
		return start_date;
	}
	public String getEndDate() {
		return end_date;
	}
	public double getPrice() {
		return price;
	}
	public String getProductUnit() {
		return product_unit;
	}
	public String getImage() {
		return image;
	}
	public String getFspid() {
		return fspid;
	}
	public void setFspid(String fspid) {
		this.fspid = fspid;
	}
	
	public boolean validate(){
		if(gcpid!=null && price>0 && product_unit!= null)
			return true;
		return false;
	}
	public String getGcpid(){
		return gcpid;
	}
	
		public void setProduct(StoreProduct s) {
		
		this.note = (s.getNote()==null) ?  this.note : s.getNote();
		this.start_date = (s.getStartDate()==null) ?  this.start_date : s.getStartDate();
		this.end_date = (s.getEndDate()==null) ?  this.end_date : s.getEndDate();
		this.product_unit = (s.getProductUnit()==null) ?  this.product_unit : s.getProductUnit();
		this.image = (s.getImage()==null) ?  this.image : s.getImage();
		this.price = (s.getPrice()<0) ?  this.price : s.getPrice();
	
	}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
