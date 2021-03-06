package fr.gcm.dao;

import java.util.List;

import fr.gcm.model.Appointment;

/**
 * 
 * @author ML11181N
 * 
 *         Interface définit l'ensemble de traitements sur les rendrez vous dans
 *         la couche DAO.
 */
public interface IAppointmentRepsitory {

	/**
	 * Ajour d'un RDV
	 * 
	 * @param bnsObjAppointment
	 *            RDV
	 */
	void addAppointment(Appointment bnsObjAppointment);

	/**
	 * Mise à jour du RDV
	 * 
	 * @param bnsObjAppointment
	 *            RDV
	 * 
	 *            retrun boolean
	 */
	boolean updateAppointmentByEventID(Appointment bnsObjAppointment);

	/**
	 * Retoune une liste de RDV
	 * 
	 * @return liste des rendez-vous
	 */
	List<Appointment> findAllApointments();
	
	/**
	 * Supprimer le RDV avec l'id de l'evenement
	 * @param eventID
	 * 			id de l'evenement
	 */
	void deteteAppointmentByEventID(String eventID);
}
