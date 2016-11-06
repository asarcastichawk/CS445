package boundary_interfaces;

import java.util.ArrayList;

import entity.Manager;
import entity.ProductCatalog;

public interface ManagerBI {
	ArrayList<ProductCatalog> viewCatalog();
	String AddProduct (ProductCatalog p);
	void updateProduct (int gcpid, ProductCatalog p);
	Manager viewAllManagers();
	Manager viewManagerById(int mid);
}
