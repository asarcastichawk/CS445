package org.huzair.entities;

public class Manager {
		
		private String mid;
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

		public void setMid(String mid){
			this.mid = mid;
		}
		
		public boolean matchesId(String mid) {
		    return(this.mid.equalsIgnoreCase(mid));
		}
		public String getName() {
			return name;
		}
}

