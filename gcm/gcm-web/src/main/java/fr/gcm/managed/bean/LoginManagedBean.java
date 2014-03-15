package fr.gcm.managed.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import fr.gcm.service.IUserService;

/**
 * 
 * @author Amina
 * 
 *         Permet d'authentifier un utilisateur .
 * 
 */
@ManagedBean(name = "loginMB")
@RequestScoped
public class LoginManagedBean {

	/**
	 * Nom d'utilisateur
	 * 
	 */
	private String login;

	/**
	 * Mot de passe
	 */
	private String password;

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

		if (login != null && password != null) {

			if (userService.verifyUserExistance(login, password)) {

				// HttpSession session = ManageSession.getSession();
				// session.setAttribute("login", login);
				// }

				loggedIn = true;
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome ",
						login);
				FacesContext.getCurrentInstance().addMessage(null, msg);

				context.addCallbackParam("loggedIn", loggedIn);

				return "/pages/create.xhtml?faces-redirect=true";
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

	public String getUsername() {
		return login;
	}

	public void setUsername(String username) {
		this.login = username;
	}
}
