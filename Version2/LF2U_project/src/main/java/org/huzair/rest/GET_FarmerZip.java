package org.huzair.rest;

import java.util.ArrayList;
import java.util.Iterator;

import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;


public class GET_FarmerZip {

	private String fid;
	private String name;
	
	public GET_FarmerZip(Farmer f){
		this.fid = f.getFid();
		FarmInfo farm = f.getFarmInfo();
		this.name = farm.getName();
	}
	
	public static ArrayList<GET_Farmer> allGetFarmers(ArrayList<Farmer> farmers){
		ArrayList<GET_Farmer> getfarmers = new ArrayList<GET_Farmer>();
		Iterator<Farmer> f = farmers.listIterator();
        while(f.hasNext()) {
            GET_Farmer thisfarmer = new GET_Farmer(f.next());
            getfarmers.add(thisfarmer);
            }
        	return getfarmers;
	}
	public static GET_Farmer getFarmer(Farmer farm){
		GET_Farmer thisfarmer = new GET_Farmer(farm);
		return thisfarmer;
		
	}
		
	
	

}