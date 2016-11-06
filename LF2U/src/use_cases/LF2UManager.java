package use_cases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import entity.Manager;
import entity.ProductCatalog;
import boundary_interfaces.ManagerBI;

public class LF2UManager implements ManagerBI{

	static AtomicInteger atomicInteger = new AtomicInteger();
	ArrayList<ProductCatalog> allproducts = new ArrayList<ProductCatalog>();
	ArrayList<Manager> allmanagers = new ArrayList<Manager>();
	
	public LF2UManager(){
		
	}
	
	@Override
	public ArrayList<ProductCatalog> viewCatalog() {
		return allproducts;
	}

	@Override
	public String addProduct(ProductCatalog p) {
		ProductCatalog product = p;
		product.setGcpid(atomicInteger.incrementAndGet());
		allproducts.add(product);
		int gcpid_as_int = product.getGcpid();
		String gcpid_as_str = Integer.toString(gcpid_as_int);
		return gcpid_as_str;
	}

	@Override
	public void updateProduct(int gcpid, ProductCatalog p) {
		ProductCatalog product = getProductsById(gcpid);
		if(product!=null)
			product.setProduct(p);
	}
	
	public ProductCatalog getProductsById(int gcpid){
			Iterator<ProductCatalog> p = allproducts.listIterator();
	        while(p.hasNext()) {
	            ProductCatalog product = p.next();
	            if(product.matchesId(gcpid))
	            	return product;
	        }
			return null;
		}

	@Override
	public ArrayList<Manager> viewAllManagers() {
		return allmanagers;
	}

	@Override
	public Manager viewManagerById(int mid) {
		Iterator<Manager> m = allmanagers.listIterator();
        while(m.hasNext()) {
            Manager manager = m.next();
            if(manager.matchesId(mid))
            	return manager;
        }
		return null;
	}

	@Override
	public String createManager(Manager m) {
		Manager manager = m;
		manager.setMid(atomicInteger.incrementAndGet());
		allmanagers.add(manager);
		int mid_as_int = manager.getMid();
		String mid_as_str = Integer.toString(mid_as_int);
		return mid_as_str;
	}

}
