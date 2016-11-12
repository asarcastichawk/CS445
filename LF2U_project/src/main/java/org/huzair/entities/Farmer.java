package org.huzair.entities;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Farmer {
	
	private int fid;
	private FarmInfo farm_info;
	private PersonalInfo personal_info;
	private ArrayList<String> delivers_to;
	private double delivery_charge;
	private Store store;
	
	public Farmer(PersonalInfo personal_info, FarmInfo farm_info, ArrayList<String> delivers_to)
	{
		this.personal_info = personal_info;
		this. farm_info = farm_info;
		this.delivers_to = delivers_to;
	}
	
	
	public Store getStore(){
		return store;
	}
	public void setStore(){
		store = new Store();
	}
	
	public int getFid() {
	    return this.fid;
	}
	public void setFid(int fid)
	{
		this.fid = fid;
	}

	public boolean matchesId(int fid) {
	    return(fid == this.fid);
	}
	
	public void setDeliversTo(ArrayList<String> dc){
		delivers_to = dc;
	}
	
	public ArrayList<String> getDeliversTo(){
		return delivers_to;
	}
	
	public void setPersonalInfo(PersonalInfo p){
		personal_info = p;
	}
	
	public PersonalInfo getPersonalInfo(){
		return personal_info;
	}
	
	public void setFarmInfo(FarmInfo f){
		farm_info = f;
	}
	
	public FarmInfo getFarmInfo(){
		return farm_info;
	}
	public void setDeliveryCharge(double dc){
		delivery_charge = dc;
	}
	public void setFarm(Farmer f){
		delivers_to = f.getDeliversTo();
		farm_info = f.getFarmInfo();
		personal_info = f.getPersonalInfo();
	}
	
	public double getDeliveryCharge(){
		return delivery_charge;
	}
	public String getFarmName(){
		return farm_info.getFarmName();
	}
	public boolean validate(){
		if(farm_info!=null && personal_info!=null)
			if(farm_info.validate() && personal_info.validate() && delivers_to!=null)
				return true;
		
		return false;
	}
	
}
