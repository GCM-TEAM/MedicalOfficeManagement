package fr.gcm.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

/**
 * 
 * @author Amina
 * 
 *         Permet d'authentifier un utilisateur .
 * 
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginManagesBean {

	/**
	 * Nom d'utilisateur
	 * 
	 */
	private String username;

	/**
	 * Mot de passe
	 */
	private String password;

	/**
	 * 
	 * Verifie l'existance d'un utilisatur
	 * 
	 */
	public String login() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage msg = null;
		boolean loggedIn = false;

		if (username != null && username.equals("admin") && password != null
				&& password.equals("admin")) {
			loggedIn = true;
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome",
					username);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", loggedIn);
			return "/pages/create.xhtml?faces-redirect=true";
		} 
			loggedIn = false;
			msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
					"Invalid credentials");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", loggedIn);
			return "/pages/login.xhtml?faces-redirect=true";

	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
