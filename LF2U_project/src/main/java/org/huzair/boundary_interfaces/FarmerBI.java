package org.huzair.boundary_interfaces;
import org.huzair.entities.Farmer;
import java.util.ArrayList;
import java.util.Map;

import org.huzair.entities.StoreProduct;
import org.huzair.report.FarmerReportType;
public interface FarmerBI {
	String createAccount(Farmer f);
	void updateAccount(String fid,Farmer f);
	Farmer viewAccount(String fid);
	ArrayList<Farmer> viewFarmers(String zip);
	ArrayList<StoreProduct> viewStore(String fid);
	String addProduct(String fid,StoreProduct s);
	StoreProduct viewProduct(String fid,String fspid);
	void modifyProduct(String fid,String fspid,StoreProduct s);
	double ViewDelivery(String fid);
	void UpdateDelivery(String fid, double dc);
	ArrayList<FarmerReportType> allReportTypes();
	ArrayList<Farmer> getAllFarmers();
	Map<String,Double> getHashmap();
	void setNull();
	Farmer getFarmerZip(Farmer farm, String zip);	
}