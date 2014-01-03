package fr.gcm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.UserRepository;
import fr.gcm.model.User;
import fr.gcm.service.UserService;

/**
 * 
 * @author KBELHANI
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService
{
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public void addUser(User user) 
	{
		if ( user != null )
		{
			userRepository.addUser( user );
		}
	}

	/*
	 * getter & setter
	 */
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {this.userRepository = userRepository;}
}