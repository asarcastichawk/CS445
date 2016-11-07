package boundary_interfaces;

import java.util.ArrayList;
import entity.Manager;
import entity.ProductCatalog;

public interface ManagerBI {
	ArrayList<ProductCatalog> viewCatalog();
	String addProduct (ProductCatalog p);
	void updateProduct (int gcpid, ProductCatalog p);
	ArrayList<Manager> viewAllManagers();
	Manager viewManagerById(int mid);
	String createManager(Manager m);
}
