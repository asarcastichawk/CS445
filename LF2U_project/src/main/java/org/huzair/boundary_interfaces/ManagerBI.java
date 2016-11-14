package org.huzair.boundary_interfaces;
import org.huzair.entities.ProductCatalog;
import org.huzair.report.ManagerReportType;
import org.huzair.entities.Manager;
import java.util.ArrayList;

public interface ManagerBI {
	ArrayList<ProductCatalog> viewCatalog();
	String addProduct (ProductCatalog p);
	void updateProduct (String gcpid, ProductCatalog p);
	ArrayList<Manager> viewAllManagers();
	Manager viewManagerById(String mid);
	//int createManager(Manager m);
	ProductCatalog viewProductById(String gcpid);
	ArrayList<ManagerReportType> allReportTypes();
}
