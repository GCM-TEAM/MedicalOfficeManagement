package fr.gcm.dao;

import java.util.List;

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
	 * Service ajoute d'un nouveau utilisateur
	 * 
	 * @param user
	 *            utilisateur
	 */
	void addUser(User user);

	/**
	 * Service retourne l'ensemble des utilisateurs
	 * 
	 * @return liste des utilisateur
	 */
	List<User> findAllUsers();

	/**
	 * Service retourne l'identifie des utilisateurs
	 * 
	 * @param login
	 *            login
	 * @return user 
	 */
	User findUserByLogin(String login);
}