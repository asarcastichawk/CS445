package entity;

public class OrderDetail {
	private int fspid;
	private double amount;
	private String amount_asStr;
	private String name;
	private double price;
	private String price_asStr;
	private double line_item_total;
	public OrderDetail(int fspid,double amount)
	{
		this.fspid = fspid;
		this.amount = amount;
	}
	
}
