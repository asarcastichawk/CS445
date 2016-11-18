package org.huzair.rest;

import java.util.ArrayList;
import java.util.Iterator;

import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;
import org.huzair.entities.PersonalInfo;


public class GET_FarmerZip {

	private String fid;
	private String name;
	
	public GET_FarmerZip(Farmer f){
		this.fid = f.getFid();
		PersonalInfo farm = f.getPersonalInfo();
		this.name = farm.getName();
	}
	
	public static ArrayList<GET_FarmerZip> allGetFarmers(ArrayList<Farmer> farmers){
		ArrayList<GET_FarmerZip> getfarmers = new ArrayList<GET_FarmerZip>();
		Iterator<Farmer> f = farmers.listIterator();
        while(f.hasNext()) {
            GET_FarmerZip thisfarmer = new GET_FarmerZip(f.next());
            getfarmers.add(thisfarmer);
            }
        	return getfarmers;
	}
	public static GET_FarmerZip getFarmer(Farmer farm){
		GET_FarmerZip thisfarmer = new GET_FarmerZip(farm);
		return thisfarmer;
		
	}
		
	
	

}