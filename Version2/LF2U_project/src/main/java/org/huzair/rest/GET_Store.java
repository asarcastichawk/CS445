package org.huzair.rest;
import java.util.ArrayList;
import java.util.Iterator;
import org.huzair.entities.Store;
import org.huzair.entities.StoreProduct;

public class GET_Store {
	
	private ArrayList<StoreProduct> products = new ArrayList<StoreProduct>();

		public GET_Store(Store store){
			this.products.addAll(store.getAllStoreProducts());
		}
		public static ArrayList<StoreProduct> getAllStoreProducts(ArrayList<StoreProduct> getProduct){
			ArrayList<StoreProduct> returnProduct = new ArrayList<StoreProduct>();
			Iterator<StoreProduct> s = getProduct.listIterator();
	        while(s.hasNext()) {
	        	StoreProduct sp = s.next();
	        	sp.setGcpid(null);
	        	returnProduct.add(sp);
	            }
			return returnProduct;
		}
}
