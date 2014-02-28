package fr.gcm.service;

import fr.gcm.model.Profiles;

/**
 * 
 * @author ML11181N
 *
 *	 	  Interface définit l'ensemble de traitements sur Profiles dans la couche service.
 *			
 */
public interface IProfilesService {
	
	/**
	 * Ajoute un profil
	 * 
	 * @param profile
	 * 				profil
	 */
	void addProfile(Profiles profile);

}
