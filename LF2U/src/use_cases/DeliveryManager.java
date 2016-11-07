package use_cases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import entity.Order;
import boundary_interfaces.DeliveryBI;

public class DeliveryManager implements DeliveryBI {
	
	CustomerManager cm = new CustomerManager();
	
	@Override
	public void UpdateStatus(int oid, String status) {
		Order o = cm.viewById(oid);
		o.setStatus("status");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date today = Calendar.getInstance().getTime();
		o.setActualDate(dateFormat.format(today));
	}

}
