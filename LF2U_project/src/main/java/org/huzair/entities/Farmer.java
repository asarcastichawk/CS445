package org.huzair.entities;
import java.util.ArrayList;

public class Farmer {
	
	private String fid;
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
	public String getFid() {
	    return this.fid;
	}
	public void setFid(String fid){
		this.fid = fid;
	}
	public boolean matchesId(String fid) {
	    return(this.fid.equalsIgnoreCase(fid));
	}
	public ArrayList<String> getDeliversTo(){
		return delivers_to;
	}
	public PersonalInfo getPersonalInfo(){
		return personal_info;
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
	
	//Mark
	public boolean validate(){
		if(farm_info!=null && personal_info!=null)
			if(farm_info.validate() && personal_info.validate() && delivers_to!=null)
				return true;
		return false;
	}
	
	public boolean match(String keyword){
		StringBuilder sb = new StringBuilder();
		for (String s : delivers_to)
			{sb.append(s+" ");}
		String s = sb.toString();
		s = s.toLowerCase();
		boolean delivers = s.matches(".*\\b" + keyword + "\\b.*");
		boolean farm = farm_info.match(keyword);
		boolean personalinfo = personal_info.match(keyword);
		if(farm||delivers||personalinfo)
			return true;
		return false;
	}
}
