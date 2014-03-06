package fr.gcm.dao;

import java.util.List;

import fr.gcm.business.objects.Authentication;
import fr.gcm.model.User;

/**
 * 
 * @author KBELHANI
 * 
 *         Interface définit l'ensemble de traitements sur le User dans la
 *         couche DAO.
 */

public interface IUserRepository {
	/**
	 * Ajoute un nouveau utilisateur
	 * 
	 * @param user
	 *            utilisateur
	 */
	void addUser(User user);

	/**
	 * Retourne l'ensemble des utilisateurs
	 * 
	 * @return liste des utilisateur
	 */
	List<User> findAll();

	/**
	 * Identifie un utilisateur
	 * 
	 * @param login
	 *            login
	 * @param password
	 *            mot de passe
	 * @return user 
	 */
	User getUserByLoginAndPwd(Authentication authentication);
}