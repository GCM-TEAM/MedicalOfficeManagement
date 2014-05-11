package fr.gcm.dao;

import java.util.List;

import fr.gcm.model.Patient;

/**
 * 
 * @author ML11181N
 * 
 *         Interface définit l'ensemble de traitements sur l'objet patient dans
 *         la couche DAO.
 */
public interface IPatientRepository {

	/**
	 * Ajout d'un patient
	 * 
	 * @param bnsObjpatient
	 *            objet metier patient
	 */
	void addPatient(Patient bnsObjpatient);

	/**
	 * Mise à jour d'un patient avec l'id de l'evenement
	 * 
	 * @param bnsObjPatient
	 *            objet metier patient
	 * @return boolean
	 */
	boolean updatePatientByEventID(Patient bnsObjPatient);

	/**
	 * Retourne l'ensemble des patients
	 * 
	 * @return liste des patients
	 */
	List<Patient> findAllPatients();

	/**
	 * Supprission du patient avec l'id de l'evenement
	 * 
	 * @param eventID
	 *            id de l'evenement
	 */
	void detetePatientByEventID(String eventID);

}
