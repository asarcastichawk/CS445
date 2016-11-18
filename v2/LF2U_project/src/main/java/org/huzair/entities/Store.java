package org.huzair.entities;

import java.util.ArrayList;

public class Store {
	
	private ArrayList<StoreProduct> products = new ArrayList<StoreProduct>();

	public ArrayList<StoreProduct> getAllStoreProducts(){
		return products;
	}
	
	public void setStoreProducts(StoreProduct s){
		products.add(s);
	}
}

