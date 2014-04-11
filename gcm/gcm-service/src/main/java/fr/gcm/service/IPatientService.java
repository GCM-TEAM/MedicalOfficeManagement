package fr.gcm.service;

import java.util.List;

import fr.gcm.model.Patient;


/**
 * 
 * @author ML11181N
 * 
 *         Interface définit l'ensemble de traitements sur user dans la couche
 *         service.
 */
public interface IPatientService {
	/**
	 * Service ajout patient
	 * 
	 * @param bnsObjpatient
	 *            objet metier patient
	 */
	void addPatient(Patient bnsObjpatient);

	/**
	 * Service mise à jour des patients
	 * 
	 * @param bnsObjPatient
	 *            objet metier patient
	 * @return boolean
	 */
	boolean updatePatient(Patient bnsObjPatient);

	/**
	 * Service retourne l'ensemble des patients
	 * 
	 * @return liste des patients
	 */
	List<Patient> findAllPatient();

	

}
