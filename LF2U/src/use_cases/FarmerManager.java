package use_cases;

import java.util.ArrayList;
import java.util.Iterator;
import boundary_interfaces.FarmerBI;
import entity.Farmer;
import entity.Store;
import entity.StoreProduct;

public class FarmerManager implements FarmerBI {
	
	private static ArrayList<Farmer> farmers = new ArrayList<Farmer>();

	@Override
	public String createAccount(Farmer f) {
		Farmer farm = f;
		farmers.add(farm);
		int fid_as_int = farm.getFid();
		String fid_as_str = Integer.toString(fid_as_int);
		return fid_as_str;
	}

	@Override
	public void updateAccount(int fid, Farmer f) {
		Farmer farm = getFarmerById(fid);
		if(farm!=null){
		farm.setFarm(f);
		}
	}

	public Farmer getFarmerById(int fid){
		Iterator<Farmer> f = farmers.listIterator();
        while(f.hasNext()) {
            Farmer farm = f.next();
            if(farm.matchesId(fid))
            	return farm;
        }
		return null;
	}
	
	public Farmer getFarmerZip(Farmer farm, String zip){
		ArrayList<String> farmer_zip = farm.getDeliversTo();
		if(farmer_zip.contains(zip))
		return farm;
		
		return null;
	}
	
	@Override
	public Farmer viewAccount(int fid) {
		Farmer farm = getFarmerById(fid);
		return ((farm != null) ? null : farm);
	}

	@Override
	public ArrayList<Farmer> viewFarmers(String zip) {
		ArrayList<Farmer> matchzip = new ArrayList<Farmer>();
		Iterator<Farmer> f = farmers.listIterator();
        while(f.hasNext()) {
            Farmer farm = f.next();
            if(getFarmerZip(farm, zip)!=null)
            	matchzip.add(farm);
        }
        return matchzip;
	}

	@Override
	public ArrayList<StoreProduct> viewStore(int fid) {
		ArrayList<StoreProduct> allproducts = new ArrayList<StoreProduct>();
		Farmer farm = getFarmerById(fid);
		Store store = farm.getStore();
		allproducts = store.getAllStoreProducts();
        return allproducts;
	}

	@Override
	public String AddProduct(int fid,StoreProduct sproducts) {
		Farmer farm = getFarmerById(fid);
		Store store = farm.getStore();
		StoreProduct s = sproducts;
		store.setStoreProducts(s);
		return s.getGcpid();
	}

	@Override
	public void ModifyProduct(StoreProduct s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double ViewDelivery(int fid) {
		Farmer farm = getFarmerById(fid);
		return farm.getDeliveryCharge();
	}

	@Override
	public void UpdateDelivery(int fid,double dc) {
		Farmer farm = getFarmerById(fid);
		farm.setDeliveryCharge(dc);
	}
}
