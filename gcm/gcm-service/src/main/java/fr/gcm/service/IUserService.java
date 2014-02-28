package fr.gcm.service;

import java.util.List;

import fr.gcm.model.User;

/**
 * 
 * @author KBELHANI
 * 
 * 			Interface définit l'ensemble de traitements sur user dans la couche service.
 *
 */

public interface IUserService
{
	void addUser (User user);
	List<User> findAll();
}