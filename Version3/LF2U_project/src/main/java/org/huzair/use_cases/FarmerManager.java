package org.huzair.use_cases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.huzair.boundary_interfaces.FarmerBI;
import org.huzair.entities.Farmer;
import org.huzair.entities.ProductCatalog;
import org.huzair.entities.Store;
import org.huzair.entities.StoreProduct;
import org.huzair.report.FarmerReportType;

public class FarmerManager implements FarmerBI {
	
	private  AtomicInteger atomicInteger = new AtomicInteger();
	private AtomicInteger atomicInteger_products = new AtomicInteger();
	private ArrayList<Farmer> farmers = new ArrayList<Farmer>();
	private Map<String,Double> fspid_price = new HashMap<String,Double>();
	private LF2UManager LM = new LF2UManager();
	
	
	//Create farmer account;
	@Override
	public String createAccount(Farmer f) {
		Farmer farm = f;
		f.setFid(Integer.toString(atomicInteger.incrementAndGet()));
		farmers.add(farm);
		String fid_as_str = farm.getFid();
		farm.setStore();
		return fid_as_str;
	}
	
	//Update farmer account
	@Override
	public void updateAccount(String fid, Farmer f) {
		Farmer farm = getFarmerById(fid);
		if(farm!=null){
		farm.setFarm(f);
		}
	}
	
	//Get farmer account by fid
	public Farmer getFarmerById(String fid){
		Iterator<Farmer> f = farmers.listIterator();
        while(f.hasNext()) {
            Farmer farm = f.next();
            if(farm.matchesId(fid))
            	return farm;
        }
		return null;
	}
	
	//Get farmer by zipcode
	public Farmer getFarmerZip(Farmer farm, String zip){
		ArrayList<String> farmer_zip = farm.getDeliversTo();
		if(farmer_zip.contains(zip)||zip==null)
			return farm;
		return null;
	}
	
	//View account by fid
	@Override
	public Farmer viewAccount(String fid) {
		Farmer farm = getFarmerById(fid);
		if(farm!=null)
			return farm;
		return null;
	}

	//View all farmers in the zip
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

	//View store for farmer by fid
	@Override
	public ArrayList<StoreProduct> viewStore(String fid) {
		ArrayList<StoreProduct> allproducts = new ArrayList<StoreProduct>();
		Farmer farm = getFarmerById(fid);
		if(farm==null)
			return allproducts;
		Store store = farm.getStore();
		allproducts = store.getAllStoreProducts();
        return allproducts;
	}

	//Add product to store
	@Override
	public String addProduct(String fid, StoreProduct sproducts) {
		if(LM.viewProductById(sproducts.getGcpid())==null)
			return null;
		Farmer farm = getFarmerById(fid);
		Store store = farm.getStore();
		StoreProduct s = sproducts;
		s.setFspid(Integer.toString(atomicInteger_products.incrementAndGet()));
		ProductCatalog pcatalog = LM.viewProductById(s.getGcpid());
		s.setName(pcatalog.getName());
		fspid_price.put(s.getFspid(),s.getPrice());
		store.setStoreProducts(s);
		return s.getFspid();
	}

	//Modify store product
	@Override
	public void modifyProduct(String fid, String fspid, StoreProduct s) {
		StoreProduct sproduct = viewProduct(fid,fspid);
		if(sproduct!=null)
			sproduct.setProduct(s);
	}

	//View delivery charge
	@Override
	public double ViewDelivery(String fid) {
		Farmer farm = getFarmerById(fid);
		return farm.getDeliveryCharge();
	}

	//Update delivery charge
	@Override
	public void UpdateDelivery(String fid,double dc) {
		Farmer farm = getFarmerById(fid);
		farm.setDeliveryCharge(dc);
	}

	//View product by fid
	@Override
	public StoreProduct viewProduct(String fid, String fspid) {
		ArrayList<StoreProduct> sp = viewStore(fid);
		if(sp==null)
			return null;
		Iterator<StoreProduct> s = sp.listIterator();
        while(s.hasNext()) {
            StoreProduct sproducts = s.next();
            if(sproducts.matchesId(fspid))
            	return sproducts;
        }
		return null;
	}

	//Get all report types for farmer
	@Override
	public ArrayList<FarmerReportType> allReportTypes() {
		FarmerReportType reports = new FarmerReportType();
		ArrayList<FarmerReportType> allReportTypes = reports.getAllTypes();
		return allReportTypes;
	}

	//Get all farmers
	@Override
	public ArrayList<Farmer> getAllFarmers() {
		return farmers;
	}
	public Map<String,Double> getHashmap(){
		return fspid_price;
	}
}