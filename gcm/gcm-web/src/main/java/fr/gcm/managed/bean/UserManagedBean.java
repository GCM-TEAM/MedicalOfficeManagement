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
import fr.gcm.service.IProfilesService;
import fr.gcm.service.IUserService;
import fr.gcm.session.authentication.CommunActions;

/**
 * 
 * @author KBELHANI
 * 
 *         Ecran administrateur
 * 
 */

@ManagedBean(name = "userMB")
@RequestScoped
public class UserManagedBean extends CommunActions implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String profile;

	@ManagedProperty(value = "#{userService}")
	private IUserService userService;
	
	
	@ManagedProperty(value = "#{profilesService}")
	private IProfilesService profilesService;

	/**
	 * Ajout d'un utilisateur avec son profil
	 */
	public void addUser() {
		try {
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setLogin(login);
			user.setPassword(password);

			Profiles profiles = new Profiles();
			profiles.setProfile(profile);

			profiles.setUser(user);
			user.getProfiles().add(profiles);

			userService.addUser(user);
			profilesService.addProfile(profiles);

			addMessage("You've registered");

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retourne la liste des utilisatuers
	 * 
	 * @return liste
	 */

	public List<User> getListUsers() {
		List<User> users = null;
		try {
			users = userService.findAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Message d'information
	 * 
	 * @param summary
	 */
	public void addMessage(String summary) {

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, "New account created");

		FacesContext.getCurrentInstance().addMessage("messagesCreate", msg);
	}

	
	/*
	 * getter & setter
	 */
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

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

	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * @return the profilesService
	 */
	public IProfilesService getProfilesService() {
		return profilesService;
	}

	/**
	 * @param profilesService the profilesService to set
	 */
	public void setProfilesService(IProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
