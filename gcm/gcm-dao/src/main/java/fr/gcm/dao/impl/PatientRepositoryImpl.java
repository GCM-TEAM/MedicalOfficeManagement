package fr.gcm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.IPatientRepository;
import fr.gcm.model.Patient;

/**
 * @author ML11181N
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         Patient dans la couche DAO.
 */

@Repository
@Transactional
public class PatientRepositoryImpl implements IPatientRepository {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PatientRepositoryImpl.class);

	/**
	 * Fabrique de session hibernate
	 */
	private SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPatient(Patient bnsObjpatient) {

		try {
			getSessionFactory().saveOrUpdate(bnsObjpatient);
			LOGGER.info("Patient inseré avec succes");
		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'insertion du Patient", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updatePatient(Patient bnsObjPatient) {

		Query patientQuery = null;

		try {

			patientQuery = getSessionFactory()
					.createQuery(
							"update Patient set firstName = :firstName , lastName = :lastName, maidenName = :maidenName, age = :age, address = :address, socialNumber = :socialNumber, phoneNumber = :phoneNumber, birthDay = :birthDay, sex = :sex  where patientID = :patientID");

			patientQuery
					.setParameter("firstName", bnsObjPatient.getFirstName());
			patientQuery.setParameter("lastName", bnsObjPatient.getLastName());
			patientQuery.setParameter("maidenName",
					bnsObjPatient.getMaidenName());
			patientQuery.setParameter("age", bnsObjPatient.getAge());
			patientQuery.setParameter("address", bnsObjPatient.getAddress());
			patientQuery.setParameter("socialNumber",
					bnsObjPatient.getSocialNumber());
			patientQuery.setParameter("phoneNumber",
					bnsObjPatient.getPhoneNumber());
			patientQuery.setParameter("birthDay", bnsObjPatient.getBirthDay());
			patientQuery.setParameter("sex", bnsObjPatient.getSex());

			patientQuery.executeUpdate();

			LOGGER.info("Patient mis à jour avec succes");

			return true;

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de la mise à jour du Patient", e);
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAllPatients() {
		Query patientQuery = null;

		try {

			patientQuery = getSessionFactory().createQuery("from Patient");

		} catch (DataAccessException e) {
			LOGGER.error("Erreur lors de l'extraction des Patients", e);
		}

		return patientQuery.list();
	}

	/**
	 * @return the sessionFactory
	 */
	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
