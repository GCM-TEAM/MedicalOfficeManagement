package fr.gcm.business.objects;

/**
 * 
 * @author ML11181N
 * 
 *         permet de représenter le modele de l'objet métier Authentication.
 */
public class Authentication {

	/**
	 * Login
	 */
	private String login;

	/**
	 * Mot de passe
	 */
	private String password;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
}
