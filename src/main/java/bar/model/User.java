package entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@XmlRootElement
/* @NamedQuery(name="User.findAll", query="SELECT u FROM User u") */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String userName;

	private String password;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	// bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "UserName") }, inverseJoinColumns = {
			@JoinColumn(name = "RoleName") })
	private List<Role> roles;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}