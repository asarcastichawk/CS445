package org.huzair.entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Store {
	
	private ArrayList<StoreProduct> products = new ArrayList<StoreProduct>();

	public ArrayList<StoreProduct> getAllStoreProducts(){
		return products;
	}
	
	/*public StoreProduct getStoreProduct(String fspid){
		Iterator<StoreProduct> sp = products.listIterator();
        while(sp.hasNext()) {
            StoreProduct s = sp.next();
            if(s.matchesId(fspid))
            	return s;
        }
		return null;
	}*/
	public void setStoreProducts(StoreProduct s){
		products.add(s);
	}
}

