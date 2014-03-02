package fr.gcm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.IProfilesRepository;
import fr.gcm.model.Profiles;

/**
 * 
 * @author ML11181N
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         profiles dans la couche DAO.
 */
@Repository
@Transactional
public class ProfilesRepositoryImpl implements IProfilesRepository {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProfilesRepositoryImpl.class);
	/**
	 * Fabrique de session hibernate
	 */
	private SessionFactory sessionFactory;

	/**
	 * Constructeur : crée une nouvelle instance de : UserRepositoryImpl
	 */
	public ProfilesRepositoryImpl() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void addProfile(Profiles profile) {

		try {
			getSessionFactory().saveOrUpdate(profile);
			LOGGER.info("Insertion du profil");
		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'insertion du profil", e);
		}
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
