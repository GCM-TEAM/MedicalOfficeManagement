package fr.gcm.managed.bean;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import fr.gcm.model.Profiles;
import fr.gcm.model.User;
import fr.gcm.service.UserService;



/**
 * 
 * @author KBELHANI
 * 
 * 		Ecran administrateur
 * 
 */

@ManagedBean(name = "userMB")
@RequestScoped
public class UserManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String profile;
	


	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
/**
 * ajout d'un utilisateur
 * @return string
 */
	public void addUser() {
		try {
			User user = new User();
			Profiles profiles = new Profiles();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setLogin(login);
			user.setPassword(password);
			userService.addUser(user);
			profiles.setProfile(profile);
			
			addMessage("You've registered");
			
	        
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	//	return "/pages/error.xhtml?faces-redirect=true";
	}
	/**
	 * Retourne la liste des utilisatuers
	 * @return liste
	 */

	public List<User> getListUsers() {
		List<User> users = null;
		try {
			users = userService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}


	/**
	 * Message d'information
	 * @param summary
	 */
	public void addMessage(String summary) {  
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,"New account created");
		FacesContext.getCurrentInstance().addMessage("messagesCreate", msg);
        
    }  

	/*
	 * getter & setter
	 */

	public UserService getUserService() {return userService;}
	public void setUserService(UserService userService) {this.userService = userService;}

	
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}

	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}

	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

}