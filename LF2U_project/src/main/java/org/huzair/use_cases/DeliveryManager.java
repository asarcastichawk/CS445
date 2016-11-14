package org.huzair.use_cases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.huzair.boundary_interfaces.DeliveryBI;
import org.huzair.entities.Order;

public class DeliveryManager implements DeliveryBI {
	
	CustomerManager cm = new CustomerManager();
	
	//Updates delivery status
	@Override
	public void UpdateStatus(int oid, String status) {
		Order o = cm.viewById(oid);
		if(o!=null){
		o.setStatus(status);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date today = Calendar.getInstance().getTime();
		o.setActualDate(dateFormat.format(today));
		}
	}

}
