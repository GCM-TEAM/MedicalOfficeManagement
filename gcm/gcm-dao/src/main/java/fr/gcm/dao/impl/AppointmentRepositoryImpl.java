package fr.gcm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
			.getLogger(AppointmentRepositoryImpl.class);

	/**
	 * Fabrique de session hibernate
	 */
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAppointment(Appointment bnsObjAppointment) {

		try {
			getSessionFactory().saveOrUpdate(bnsObjAppointment);
			LOGGER.info("RDV inseré avec succes");
		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'insertion du RDV", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateAppointment(Appointment bnsObjAppointment) {
		Query appointmentQuery = null;

		try {

			appointmentQuery = getSessionFactory()
					.createQuery(
							"update Appointment set Title = :Title , data = :data, startDate = :startDate, endDate = :endDate where eventID = :eventID");

			appointmentQuery.setParameter("eventID",
					bnsObjAppointment.getEventID());
			appointmentQuery
					.setParameter("Title", bnsObjAppointment.getTitle());
			appointmentQuery.setParameter("data", bnsObjAppointment.getData());
			appointmentQuery.setParameter("startDate",
					bnsObjAppointment.getStartDate());
			appointmentQuery.setParameter("endDate",
					bnsObjAppointment.getEndDate());

			appointmentQuery.executeUpdate();

			LOGGER.info("RDV mis à jour avec succes");

			return true;

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de la mise à jour du RDV", e);
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> findAllApointments() {

		Query appointmentQuery = null;

		try {

			appointmentQuery = getSessionFactory().createQuery(
					"from Appointment");

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'extraction des RDV", e);
		}

		return appointmentQuery.list();
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
