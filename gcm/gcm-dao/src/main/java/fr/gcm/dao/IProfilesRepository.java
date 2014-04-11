package fr.gcm.dao;

import fr.gcm.model.Profiles;

/**
 * 
 * @author ML11181N
 *
 *		Interface définit l'ensemble de traitements sur Profiles dans la couche DAO.
 */
public interface IProfilesRepository {
	
	/**
	 * Service ajoute profil
	 * 
	 * @param profile
	 * 				profil
	 */
	void addProfile(Profiles profile);

}
