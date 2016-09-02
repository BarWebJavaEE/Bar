package bar.services;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import bar.model.User;

@SessionScoped
public class UserContext implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6749865761603271889L;
	
	private User currentUser;
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
}
