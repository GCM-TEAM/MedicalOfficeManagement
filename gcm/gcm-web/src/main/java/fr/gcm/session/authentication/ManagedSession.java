package fr.gcm.session.authentication;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author ML11181N
 * 
 *         permet de gerer les session
 */

public class ManagedSession {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	/**
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	/**
	 * Retoune l'utilisateur en session
	 * 
	 * @return login de l'utilisateur
	 */
	public static String getLoginSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("login").toString();
	}

	/*
	 * public static String getUserId() { HttpSession session = getSession(); if
	 * (session != null) return (String) session.getAttribute("userid"); else
	 * return null; }
	 */
}
