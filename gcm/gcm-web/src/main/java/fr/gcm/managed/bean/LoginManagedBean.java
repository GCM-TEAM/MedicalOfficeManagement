package fr.gcm.managed.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import fr.gcm.service.IUserService;
import fr.gcm.session.authentication.ManagedSession;

/**
 * 
 * @author Amina
 * 
 *         Permet d'authentifier un utilisateur .
 * 
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 * Service user
	 */
	@ManagedProperty(value = "#{userService}")
	private IUserService userService;

	/**
	 * Verifie l'existance d'un utilisatur
	 * 
	 */
	public String login() {

		FacesMessage msg = null;
		RequestContext context = RequestContext.getCurrentInstance();
		boolean loggedIn = false;
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);

		if (username != null && password != null) {

			if (userService.findUserByLogin(username)) {

				HttpSession session = ManagedSession.getSession();
				session.setAttribute("login", username);

				loggedIn = true;
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome ",
						username);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				context.addCallbackParam("loggedIn", loggedIn);

				return "/pages/main.xhtml?faces-redirect=true";
			}
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

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userService
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
