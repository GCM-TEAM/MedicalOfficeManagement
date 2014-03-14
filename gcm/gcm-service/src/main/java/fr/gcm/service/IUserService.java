package fr.gcm.service;

import java.util.List;

import fr.gcm.model.User;

/**
 * 
 * @author KBELHANI
 * 
 *         Interface définit l'ensemble de traitements sur user dans la couche
 *         service.
 * 
 */

public interface IUserService {

	/**
	 * Ajoute un utilisateur en base
	 * 
	 * @param user
	 *            utilisateur
	 */
	void addUser(User user);

	/**
	 * Retourne l'ensemble des utilisateur
	 * 
	 * @return liste des utilisateurs
	 */
	List<User> findAll();

	/**
	 * Verifie l'existance de l'utilisateur en base
	 * 
	 * @param login
	 *            login
	 * @return boolean
	 */
	boolean verifyUserExistance(String login);

}