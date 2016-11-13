package org.huzair.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
		
		private int mid;
		private String name;
		private String created_by;
		private String created_date;
		private String phone;
		private String email;

		public Manager(String name, String created_by, String created_date, String phone, String email){
		
			this.name = name;
			this.created_by = created_by;
			this.created_date = created_date;
			this.phone = phone;
			this.email = email;
		}

		public int getMid() {
		    return this.mid;
		}
		public void setMid(int mid){
			this.mid = mid;
		}
		
		public boolean matchesId(int mid) {
		    return(mid == this.mid);
		}
		
}

