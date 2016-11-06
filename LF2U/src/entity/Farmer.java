package entity;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Farmer {
	static AtomicInteger atomicInteger = new AtomicInteger();
	private int fid;
	private ArrayList<String> delivers_to;
	private PersonalInfo personal_info;
	private FarmInfo farm_info;
	private double delivery_charge = 0;
	private Store store = new Store();
	
	public Farmer(PersonalInfo personal_info, FarmInfo farm_info, ArrayList<String> delivers_to)
	{
		fid = atomicInteger.incrementAndGet();
		this.personal_info = personal_info;
		this. farm_info = farm_info;
		this.delivers_to = delivers_to;
	}
	
	public Store getStore(){
		
		return store;
	}
	
	public int getFid() {
	    return this.fid;
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
	
}
