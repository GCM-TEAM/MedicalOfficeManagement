package fr.gcm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.IUserRepository;
import fr.gcm.model.User;

/**
 * 
 * @author KBELHANI
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         user dans la couche DAO.
 * 
 */

@Repository
@Transactional
public class UserRepositoryImpl implements IUserRepository {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserRepositoryImpl.class);
	/**
	 * Fabrique de session hibernate
	 */
	private SessionFactory sessionFactory;

	/**
	 * Constructeur : crée une nouvelle instance de : UserRepositoryImpl
	 */
	public UserRepositoryImpl() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addUser(User user) {
		try {
			getSessionFactory().saveOrUpdate(user);
			LOGGER.info("Insertion du user");
		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'insertion de l'utilisateur", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {

		List<User> listUsers = null;

		try {

			listUsers = getSessionFactory().createQuery("from User").list();

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'extraction des utilisateurs", e);
		}
		return listUsers;
	}

	/*
	 * getter & setter
	 */

	/**
	 * Récupére la courante session
	 * 
	 * @return session Hibernate
	 */
	private Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
