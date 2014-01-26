package fr.gcm.managed.bean;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DataAccessException;

import fr.gcm.model.User;
import fr.gcm.service.UserService;



/**
 * 
 * @author KBELHANI
 * 
 */

@ManagedBean(name = "userMB")
@RequestScoped
public class UserManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	private String firstName;
	private String lastName;
	private String login;
	private String password;


	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
/**
 * ajout d'un utilisateur
 * @return string
 */
	public String addUser() {
		try {
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setLogin(login);
			user.setPassword(password);
			userService.addUser(user);
			addMessage("You've registered");
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
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
	
	public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
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

}