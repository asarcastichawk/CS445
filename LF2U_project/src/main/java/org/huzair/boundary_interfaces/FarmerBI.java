package org.huzair.boundary_interfaces;
import org.huzair.entities.Farmer;
import java.util.ArrayList;
import org.huzair.entities.StoreProduct;
import org.huzair.report.FarmerReportType;
public interface FarmerBI {
	int createAccount(Farmer f);
	void updateAccount(int fid,Farmer f);
	Farmer viewAccount(int fid);
	ArrayList<Farmer> viewFarmers(String zip);
	ArrayList<StoreProduct> viewStore(int fid);
	String addProduct(int fid,StoreProduct s);
	StoreProduct viewProduct(int fid,String fspid);
	void modifyProduct(int fid,String fspid,StoreProduct s);
	double ViewDelivery(int fid);
	void UpdateDelivery(int fid, double dc);
	ArrayList<FarmerReportType> allReportTypes();
	ArrayList<Farmer> getAllFarmers();
	
	
	
}