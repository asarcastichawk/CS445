package boundary_interfaces;

import java.util.ArrayList;

import entity.Farmer;
import entity.StoreProduct;

public interface FarmerBI {
	String createAccount(Farmer f);
	void updateAccount(int fid,Farmer f);
	Farmer viewAccount(int fid);
	ArrayList<Farmer> viewFarmers(String zip);
	ArrayList<StoreProduct> viewStore(int fid);
	String AddProduct(int fid,StoreProduct s);
	void ModifyProduct(StoreProduct s);
	double ViewDelivery(int fid);
	void UpdateDelivery(int fid, double dc);
	
	
}