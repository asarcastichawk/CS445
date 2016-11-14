package org.huzair.report;

import java.util.ArrayList;

public class ManagerReportType {
	private int mrid;
	private String name;
	ArrayList<ManagerReportType> alltypes;
	
	public ManagerReportType(int mrid, String name){

		this.mrid = mrid;
		this.name = name;
	}
	public ManagerReportType(){
		allReportTypes();
	}
	public ArrayList<ManagerReportType> getAllTypes()
	{
		return alltypes;
	}
	private void allReportTypes(){

		ManagerReportType R1 = new ManagerReportType(1,"Orders placed today");
		ManagerReportType R2 = new ManagerReportType(2,"Orders placed yesterday");
		ManagerReportType R3 = new ManagerReportType(3,"Revenue for previous month");
		ManagerReportType R4 = new ManagerReportType(4,"Revenue yesterday");
		ManagerReportType R5 = new ManagerReportType(4,"Revenue yesterday by zip code");
		alltypes = new ArrayList<ManagerReportType>();
		alltypes.add(R1);
		alltypes.add(R2);
		alltypes.add(R3);
		alltypes.add(R4);
		alltypes.add(R5);
	}

	
}
