package org.huzair.boundary_interfaces;
import org.huzair.entities.ProductCatalog;
import org.huzair.entities.Manager;
import java.util.ArrayList;

public interface ManagerBI {
	ArrayList<ProductCatalog> viewCatalog();
	String addProduct (ProductCatalog p);
	void updateProduct (int gcpid, ProductCatalog p);
	ArrayList<Manager> viewAllManagers();
	Manager viewManagerById(int mid);
	String createManager(Manager m);
}
