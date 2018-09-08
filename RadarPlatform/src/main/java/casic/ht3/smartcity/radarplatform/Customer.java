package casic.ht3.smartcity.radarplatform;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Customer {
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer id;

	    private String name;

	    private String address;
	    
	    private String gender;
	    
	    private String phone_num;
	    
	    private String password;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPhone_num() {
			return phone_num;
		}

		public void setPhone_num(String phone_num) {
			this.phone_num = phone_num;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


}
