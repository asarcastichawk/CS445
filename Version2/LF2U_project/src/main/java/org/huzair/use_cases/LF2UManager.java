package org.huzair.use_cases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.huzair.entities.Manager;
import org.huzair.entities.ProductCatalog;
import org.huzair.report.ManagerReportType;
import org.huzair.boundary_interfaces.ManagerBI;

public class LF2UManager implements ManagerBI{

	private static AtomicInteger productAtomicInteger = new AtomicInteger();
	//private static AtomicInteger managerAtomicInteger = new AtomicInteger();
	private static AtomicBoolean isCreated = new AtomicBoolean();
	private static ArrayList<ProductCatalog> allproducts = new ArrayList<ProductCatalog>();
	private static ArrayList<Manager> allmanagers = new ArrayList<Manager>();
	private DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	
	public LF2UManager(){
		if(!isCreated.getAndSet(true)){
			createSystem();
		}
	}
	
	//Create system manager
	public void createSystem(){
		Date today = Calendar.getInstance().getTime();
		String created_date = (dateFormat.format(today));
		Manager manager = new Manager("Super User", "System", created_date, "123-0987-654", "superuser@example.com");
		manager.setMid("0");
		allmanagers.add(manager);
	}
	
	//View all products
	@Override
	public ArrayList<ProductCatalog> viewCatalog() {
		return allproducts;
	}

	//Add product to catalog
	@Override
	public String addProduct(ProductCatalog p) {
		if(p==null)
			return null;
		ProductCatalog product = new ProductCatalog(p);
		product.setGcpid(Integer.toString(productAtomicInteger.incrementAndGet()));
		allproducts.add(product);
		String gcpid = product.getGcpid();
		return gcpid;
	}

	//Update product
	@Override
	public void updateProduct(String gcpid, ProductCatalog p) {
		ProductCatalog product = viewProductById(gcpid);
		if(product!=null)
			product.setProduct(p);
	}
	

	//View all managers
	@Override
	public ArrayList<Manager> viewAllManagers() {
		return allmanagers;
	}

	//View managers by Id
	@Override
	public Manager viewManagerById(String mid) {
		Iterator<Manager> m = allmanagers.listIterator();
        while(m.hasNext()) {
            Manager manager = m.next();
            if(manager.matchesId(mid))
            	return manager;
        }
		return null;
	}

	//Create new manager
	/*@Override
	public int createManager(Manager m) {
		Manager manager = m;
		manager.setMid(managerAtomicInteger.incrementAndGet());
		allmanagers.add(manager);
		int mid_as_int = manager.getMid();
		return mid_as_int;
	}*/
	
	//View products by Id
	public ProductCatalog viewProductById(String gcpid){
		Iterator<ProductCatalog> p = allproducts.listIterator();
        while(p.hasNext()) {
            ProductCatalog pcatalog = p.next();
            if(pcatalog.matchesId(gcpid))
            	return pcatalog;
        }
		return null;
	}
	
	
	//View all manager report types
	@Override
	public ArrayList<ManagerReportType> allReportTypes() {
		ManagerReportType reports = new ManagerReportType();
		ArrayList<ManagerReportType> allReportTypes = reports.getAllTypes();
		return allReportTypes;
	}
	
}
