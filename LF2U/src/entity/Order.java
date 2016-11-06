package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
	static AtomicInteger atomicInteger = new AtomicInteger();
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	

	private int oid;
	private int fid;
	private ArrayList<OrderDetail> detail = new ArrayList<OrderDetail>();
	private String delivery_note;
	private String status;
	private String order_date;
	private String planned_delivery_date;
	private String actual_delivery_date;
	double products_total;
	double order_total;
	public Order(int fid, ArrayList<OrderDetail> detail, String delivery_note)
	{
		this.oid = atomicInteger.incrementAndGet();
		this.fid = fid;
		this.detail = detail;
		this.delivery_note = delivery_note;
		this.status = "open";
		
		Date today = Calendar.getInstance().getTime();
		this.order_date = dateFormat.format(today);
		Calendar.getInstance().add(Calendar.DAY_OF_MONTH, 1);
		Date tom = Calendar.getInstance().getTime();
		this.planned_delivery_date = dateFormat.format(tom);
		
	}
	public ArrayList<OrderDetail> getAllDetails()
	{
		return detail;
	}
}
