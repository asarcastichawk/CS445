package org.huzair.report;

import java.util.ArrayList;
import org.huzair.entities.Order;
import org.huzair.use_cases.CustomerManager;

public class ManagerReport {
	private String mrid;
	private String name;
	private int orders_placed;
	public ManagerReport(String mrid){
		this.mrid = mrid;
		ManagerReportType mrt = new ManagerReportType();
		this.name = mrt.getName(mrid);
		CustomerManager manager= new CustomerManager();
		ArrayList<Order> allorders = manager.viewAllOrders();
		orders_placed = allorders.size();
		}
}
