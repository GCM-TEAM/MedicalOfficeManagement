package fr.gcm.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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
	private static final String ERROR 	= "error";
	
	private String userName;
	private String password;
	
	//- Injection du spring service user 
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	
	public String addUser()
	{
		try
		{
			User user = new User();
			user.setNom(userName);
			user.setPassword(password);
			userService.addUser(user);
			return  SUCCESS;
		}
		catch (DataAccessException e)
		{
			e.printStackTrace();
		}
		return ERROR;
	}

	/*
	 * getter & setter 
	 */
	
	public UserService getUserService() {return userService;}

	public void setUserService(UserService userService) {this.userService = userService;}

	public String getUserName() {return userName;}

	public void setUserName(String userName) {this.userName = userName;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

}