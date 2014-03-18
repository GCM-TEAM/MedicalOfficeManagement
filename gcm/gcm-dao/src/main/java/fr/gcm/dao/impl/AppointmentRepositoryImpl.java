package fr.gcm.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.business.objects.BnsObjAppointment;
import fr.gcm.dao.IAppointmentRepsitory;
import fr.gcm.model.Appointment;

/**
 * 
 * @author ML11181N
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         Appointment dans la couche DAO.
 * 
 */

@Repository
@Transactional
public class AppointmentRepositoryImpl implements IAppointmentRepsitory {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProfilesRepositoryImpl.class);

	/**
	 * Fabrique de session hibernate
	 */
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAppointment(BnsObjAppointment bnsObjAppointment) {

		try {
			getSessionFactory().saveOrUpdate(bnsObjAppointment);
			LOGGER.info("Insertion d'un RDV");
		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'insertion du RDV", e);
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
	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Injection de l'objet l'objet sessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
