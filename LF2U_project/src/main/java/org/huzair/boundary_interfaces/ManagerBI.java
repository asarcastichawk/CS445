package org.huzair.boundary_interfaces;
import org.huzair.entities.ProductCatalog;
import org.huzair.report.ManagerReportType;
import org.huzair.entities.Manager;
import java.util.ArrayList;

public interface ManagerBI {
	ArrayList<ProductCatalog> viewCatalog();
	int addProduct (ProductCatalog p);
	void updateProduct (int gcpid, ProductCatalog p);
	ArrayList<Manager> viewAllManagers();
	Manager viewManagerById(int mid);
	int createManager(Manager m);
	ProductCatalog viewProductById(int gcpid);
	ArrayList<ManagerReportType> allReportTypes();
}
