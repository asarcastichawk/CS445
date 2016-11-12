package org.huzair.report;

import java.util.ArrayList;

public class FarmerReportType {

	private int frid;
	private String name;
	ArrayList<FarmerReportType> alltypes;
	
	public FarmerReportType(int frid, String name){
		alltypes = new ArrayList<FarmerReportType>();
		FarmerReportType R701 = new FarmerReportType(701,"Orders to deliver today");
		FarmerReportType R702 = new FarmerReportType(702,"Orders to deliver tomorrow");
		FarmerReportType R703 = new FarmerReportType(703,"Revenue report");
		FarmerReportType R704 = new FarmerReportType(704,"Orders delivery report");
		alltypes.add(R701);
		alltypes.add(R702);
		alltypes.add(R703);
		alltypes.add(R704);
		this.frid = frid;
		this.name = name;
	}
	public int getFrid(){
		return frid;
	}
	public ArrayList<FarmerReportType> getAllTypes()
	{
		return alltypes;
	}
}
