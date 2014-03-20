package fr.gcm.service;

import java.util.List;

import fr.gcm.model.Appointment;

/**
 * 
 * @author ML11181N
 * 
 *         Interface définit l'ensemble de traitements sur user dans la couche
 *         service.
 */
public interface IAppointmentService {

	/**
	 * Ajout du service RDV
	 * 
	 * @param bnsObjAppointment
	 *            RDV metier
	 */
	void addAppointment(Appointment bnsObjAppointment);
	
	/**
	 * Mise à jour du RDV
	 * 
	 * @param bnsObjAppointment
	 *            RDV
	 *            
	 * retrun boolean
	 */
	boolean updateAppointment(Appointment bnsObjAppointment);
	
	
	/**
	 * Retoune une liste de RDV
	 * 
	 * @return list
	 */
	List<Appointment> findAllApointments();
}
