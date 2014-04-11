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
	 * Mise à jour d'un patient
	 * 
	 * @param bnsObjPatient
	 *            objet metier patient
	 * @return boolean
	 */
	boolean updatePatient(Patient bnsObjPatient);

	/**
	 * Retourne l'ensemble des patients
	 * 
	 * @return liste des patients
	 */
	List<Patient> findAllPatients();

}
