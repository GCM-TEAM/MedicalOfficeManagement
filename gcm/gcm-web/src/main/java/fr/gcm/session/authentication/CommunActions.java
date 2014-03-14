package fr.gcm.session.authentication;

import javax.servlet.http.HttpSession;
/**
 * 
 * @author ML11181N
 *
 *				Permete de regrouper tout les méthodes en commun utilisées par les Managed Bean
 */
public class CommunActions {

	/**
	 * Deconnexion
	 * 
	 * @return redirection vers la page d'athentification
	 */
	public String logout() {
		HttpSession session = ManagedSession.getSession();
		session.invalidate();
		return "/pages/login.xhtml?faces-redirect=true";
	}

}
