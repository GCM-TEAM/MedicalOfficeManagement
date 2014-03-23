package fr.gcm.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import org.primefaces.event.TabChangeEvent;

import fr.gcm.session.authentication.ManagedSession;

/**
 * 
 * @author ML11181N
 * 
 *         Permet de regrouper tout les méthodes en commun utilisées par les
 *         Managed Beans 
 */
@ManagedBean(name = "mainActionsMB")
@RequestScoped
public class MainActionsManageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Tab selectionné
	 */
	private String selectedTab;

	/**
	 * Gere le listener AJAX crée dans la tabView
	 * 
	 * @param event
	 *            evenement
	 */
	public void onTabChanged(TabChangeEvent event) {

		if (event != null) {
			this.selectedTab = event.getTab().getId();
		}
	}

	/**
	 * Retourne le tab selectionné
	 * 
	 * @return non duy tab
	 */
	public String getSelectedTab() {
		return selectedTab;
	}

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
