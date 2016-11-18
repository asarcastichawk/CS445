package org.huzair.entities;
public class OrderDetail {
	private String fspid;
	private double amount;
	private String amount_asStr;
	private String name;
	private double price;
	private String price_asStr;
	private double line_item_total;
	StoreProduct sp;
	ProductCatalog product;
	
	public OrderDetail(String fspid,double amount)
	{
		this.fspid = fspid;
		this.amount = amount;
	}
	public String getAmountAsStr(){
		amount_asStr = amount + sp.getProductUnit();
		return amount_asStr;
	}
	public double getPrice(){
		return price;
	}
	public String getPriceAsStr(){
		price_asStr = price + " per " + sp.getPrice();
		return price_asStr;
	}
	public double getLineItemTotal(){
		return line_item_total;
	}
	public boolean validate(){
		if(this.fspid!=null	 && this.amount>0)
			return true;
		return false;
	}
	public String getFspid(){
		return fspid;
	}
	public void setPrice(double price){
		this.price = price;
		this.line_item_total = Math.floor((price*amount) * 100) / 100;
	}
	public boolean match(String keyword) {
		String all = fspid+" "+amount+" "+name+" "+price+" "+line_item_total;
		all = all.toLowerCase();
		return all.matches(".*\\b" + keyword + "\\b.*");
	}
}
