package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class StoreProduct {
	static AtomicInteger atomicInteger = new AtomicInteger();
	private int fspid;
	private String gcpid;
	private String note;
	private String start_date;
	private String end_date;
	private int price;
	private String product_unit;
	private String image;
	
	public StoreProduct(String gcpid, String note, String start_date, String end_date, int price, String product_unit, String image){
		this.fspid = atomicInteger.incrementAndGet();
		this.setGcpid(gcpid);
		this.setNote(note);
		this.setStartDate(start_date);
		this.setEndDate(end_date);
		this.setPrice(price);
		this.setProductUnit(product_unit);
		this.setImage(image);
	}
	
	public boolean matchesId(int fspid) {
	    return(fspid == this.fspid);
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStartDate() {
		return start_date;
	}

	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}

	public String getEndDate() {
		return end_date;
	}

	public void setEndDate(String end_date) {
		this.end_date = end_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductUnit() {
		return product_unit;
	}

	public void setProductUnit(String product_unit) {
		this.product_unit = product_unit;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGcpid() {
		return gcpid;
	}

	public void setGcpid(String gcpid) {
		this.gcpid = gcpid;
	}
}
