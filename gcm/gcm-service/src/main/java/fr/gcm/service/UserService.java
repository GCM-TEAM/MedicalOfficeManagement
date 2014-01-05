package fr.gcm.service;

import java.util.List;

import fr.gcm.model.User;

/**
 * 
 * @author KBELHANI
 *
 */

public interface UserService
{
	void addUser (User user);
	List<User> findAll();
}