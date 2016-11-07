package entity;

import java.util.ArrayList;
import java.util.Iterator;

public class Search {

	private String topic;
	private String keyword;
	private String[] acceptable_topic= {"farm","order","customer"};
	
	public Search(String topic,String keyword){
		this.topic = topic;
		this.keyword = keyword;
		determineTopic();
	}
	
	
	private void determineTopic() {
		if(topic.equalsIgnoreCase(acceptable_topic[0]))
		searchFarm(keyword);
		else if(topic.equalsIgnoreCase(acceptable_topic[1]))
		searchOrder(keyword);
		else if(topic.equalsIgnoreCase(acceptable_topic[2]))
		searchCustomer(keyword);
		
	}
	private void searchCustomer(String keyword) {
		// TODO Auto-generated method stub
		
	}


	private void searchOrder(String keyword) {
		// TODO Auto-generated method stub
		
	}


	public void searchFarm(String keyword){
		
	}

	
	
}
