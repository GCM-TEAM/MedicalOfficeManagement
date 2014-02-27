package fr.gcm.dao;

import fr.gcm.model.Profiles;

/**
 * 
 * @author ML11181N
 *
 *		Interface définit l'ensemble de traitements sur Profiles
 */
public interface IProfileRepository {
	
	/**
	 * Ajoute un profil
	 * 
	 * @param profile
	 * 				profil
	 */
	void addProfile(Profiles profile);

}
