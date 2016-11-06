package entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Manager {
		static AtomicInteger atomicInteger = new AtomicInteger();
		private int mid;
		private String name;
		private String created_by;
		private String created_date;
		private String phone;
		private String email;

		public Manager(String name, String created_by, String created_date, String phone, String email){
			this.mid = atomicInteger.incrementAndGet();;
			this.name = name;
			this.created_by = created_by;
			this.created_date = created_date;
			this.phone = phone;
			this.email = email;
		}

		public int getMid() {
		    return this.mid;
		}
}
