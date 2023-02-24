package com.capg.ipl.entity;

import javax.persistence.*;


@Entity
@Table(name="admin")
public class Admin{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admin_id")
    private long adminId;
    
    @Column(name="username")
    private String userName;
    
    @Column(name="password")
    private String password;
    
	    public Admin() {
		super();
	}


		public Admin(long adminId, String userName, String password) {
			super();
			this.adminId = adminId;
			this.userName = userName;
			this.password = password;
		}

		public long getAdminId() {
			return adminId;
		}

		public void setAdminId(long adminId) {
			this.adminId = adminId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUsername(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", username=" + userName + ", password=" + password + "]";
		}
        

		
	    
}


