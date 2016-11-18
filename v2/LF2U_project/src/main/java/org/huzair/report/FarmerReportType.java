package org.huzair.report;

import java.util.ArrayList;
import java.util.Iterator;

public class FarmerReportType {

	private String frid;
	private String name;
	private ArrayList<FarmerReportType> alltypes;
	
	public FarmerReportType(String frid, String name){
		
		this.frid = frid;
		this.name = name;
	}
	public FarmerReportType(){
		allReportTypes();
	}
	public ArrayList<FarmerReportType> getAllTypes()
	{
		return alltypes;
	}
	private void allReportTypes(){
		FarmerReportType R1 = new FarmerReportType("1","Orders to deliver today");
		FarmerReportType R2 = new FarmerReportType("2","Orders to deliver tomorrow");
		FarmerReportType R3 = new FarmerReportType("3","Revenue report");
		FarmerReportType R4 = new FarmerReportType("4","Orders delivery report");
		alltypes = new ArrayList<FarmerReportType>();
		alltypes.add(R1);
		alltypes.add(R2);
		alltypes.add(R3);
		alltypes.add(R4);
	}
	public String getName(String frid) {
		Iterator<FarmerReportType> frt = alltypes.listIterator();
        while(frt.hasNext()) {
        	FarmerReportType report = frt.next();
            if(report.frid.equalsIgnoreCase(frid))
            	return report.name;
        }
		return null;
	}
	}

