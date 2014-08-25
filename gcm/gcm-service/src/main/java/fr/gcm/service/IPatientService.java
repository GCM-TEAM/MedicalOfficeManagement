package fr.gcm.service;

import java.util.List;

import fr.gcm.model.Patient;


/**
 * 
 * @author ML11181N
 * 
 *         Interface définit l'ensemble de traitements sur le patient dans la couche
 *         service.
 */
public interface IPatientService {
	/**
	 * Service ajout patient
	 * 
	 * @param bnsObjPatient
	 *            objet metier patient
	 */
	void addPatient(Patient bnsObjPatient);

	/**
	 * Service mise à jour des patients avec id l'evenement
	 * 
	 * @param bnsObjPatient
	 *            objet metier patient
	 * @return boolean
	 */
	boolean updatePatientByEventID(Patient bnsObjPatient);

	/**
	 * Service retourne l'ensemble des patients
	 * 
	 * @return liste des patients
	 */
	List<Patient> findAllPatient();
	
	/**
	 * Service de suppression des patients
	 * @param eventID
	 * 				id evenement
	 */
	void deletePatientByEventID(String eventID);
}
