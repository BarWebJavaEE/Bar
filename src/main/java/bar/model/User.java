package bar.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;




public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4805338535748043692L;
	
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String userName;

	    private String password;

	    private String email;

	    

	  

	    public User() {
	    }

	    public User(String userName, String password, String email) {
	        this.userName = userName;
	        this.password = password;
	        this.email = email;
	        
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	    
	
	
	

	
	
	
	
	
	
}