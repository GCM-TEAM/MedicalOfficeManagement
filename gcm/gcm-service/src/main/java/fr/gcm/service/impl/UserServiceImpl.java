package fr.gcm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.IUserRepository;
import fr.gcm.model.User;
import fr.gcm.service.IUserService;

/**
 * 
 * @author KBELHANI
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         user dans la couche service.
 * 
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	/**
	 * Injection du user repository
	 */
	private IUserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean findUserByLogin(String login) {

		if (userRepository.findUserByLogin(login) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Retourner la liste des utilisateurs
	 */
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	/*
	 * Getter & Setter
	 */

	/**
	 * Injecte l'objet user
	 * 
	 * @param userRepository
	 *            user
	 */
	@Autowired
	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
