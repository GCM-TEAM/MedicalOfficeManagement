package fr.gcm.dao;

import java.util.List;

import fr.gcm.model.User;

/**
 * 
 * @author KBELHANI
 *
 */

public interface UserRepository
{
	void addUser (User user);
	List<User> findAll();
}