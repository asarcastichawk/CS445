package org.huzair.rest;

import java.util.ArrayList;
import java.util.Iterator;

import org.huzair.entities.FarmInfo;
import org.huzair.entities.Farmer;
import org.huzair.entities.PersonalInfo;

public class GET_Farmer {

	private String fid;
	private FarmInfo farm_info;
	private PersonalInfo personal_info;
	private ArrayList<String> delivers_to;
	
	public GET_Farmer(Farmer f){
		this.fid = f.getFid();
		this.delivers_to = f.getDeliversTo();
		this.farm_info = f.getFarmInfo();
		this.personal_info = f.getPersonalInfo();
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