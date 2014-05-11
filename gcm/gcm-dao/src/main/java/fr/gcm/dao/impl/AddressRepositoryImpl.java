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

import fr.gcm.dao.IAddressRepository;
import fr.gcm.model.Address;

/**
 * 
 * @author Amina
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         Address dans la couche DAO.
 * 
 */
@Repository
@Transactional
public class AddressRepositoryImpl implements IAddressRepository {

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
	public void addAddress(Address address) {
		try {
			getSessionFactory().saveOrUpdate(address);
			LOGGER.info("adresse inseré avec succes");
		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'insertion de l'adresse", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateAddressByID(Address bnsObjAddress) {
		Query addressQuery = null;

		try {

			addressQuery = getSessionFactory()
					.createQuery(
							"update Address set number = :number , street = :street, zipCode = :zipCode, city = :city, country = :country where addressID = :addressID");

			addressQuery
					.setParameter("addressID", bnsObjAddress.getAddressID());
			addressQuery.setParameter("number", bnsObjAddress.getNumber());
			addressQuery.setParameter("street", bnsObjAddress.getStreet());
			addressQuery.setParameter("zipCode", bnsObjAddress.getZipCode());
			addressQuery.setParameter("city", bnsObjAddress.getCity());
			addressQuery.setParameter("country", bnsObjAddress.getCountry());

			addressQuery.executeUpdate();

			LOGGER.info("Adresse mise à jour avec succes");

			return true;

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de la mise à jour de l'adresse", e);
		}

		return false;
	}

	@Override
	public boolean updateAddressByEventID(Address bnsObjAddress) {
		Query addressQuery = null;

		try {

			addressQuery = getSessionFactory()
					.createQuery(
							"update Address set number = :number , street = :street, zipCode = :zipCode, city = :city, country = :country where eventID = :eventID");

			addressQuery
					.setParameter("addressID", bnsObjAddress.getAddressID());
			addressQuery.setParameter("number", bnsObjAddress.getNumber());
			addressQuery.setParameter("street", bnsObjAddress.getStreet());
			addressQuery.setParameter("zipCode", bnsObjAddress.getZipCode());
			addressQuery.setParameter("city", bnsObjAddress.getCity());
			addressQuery.setParameter("country", bnsObjAddress.getCountry());

			addressQuery.executeUpdate();

			LOGGER.info("Adresse mise à jour avec succes");

			return true;

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de la mise à jour de l'adresse", e);
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAllAddresses() {
		Query addressQuery = null;

		try {

			addressQuery = getSessionFactory().createQuery("from Address");
			LOGGER.info("Adresses extraites avec succes");

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'extraction des adresses", e);
		}

		return addressQuery.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAddressByEventID(String eventID) {
		Query addressQuery = null;

		try {

			addressQuery = getSessionFactory().createQuery(
					"from Address where eventID = :eventID");
			addressQuery.setParameter("eventID", eventID);
			Address address = (Address) addressQuery.list().get(0);
			getSessionFactory().delete(address);

			LOGGER.info("Adresse supprimée avec succes");

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de la supprission de l'adresse", e);
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
