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
	 * Service ajout des RDV
	 * 
	 * @param bnsObjAppointment
	 *            RDV metier
	 */
	void addAppointment(Appointment bnsObjAppointment);
	
	/**
	 * Service mise à jour des RDV
	 * 
	 * @param bnsObjAppointment
	 *            RDV
	 *            
	 * retrun boolean
	 */
	boolean updateAppointment(Appointment bnsObjAppointment);
	
	
	/**
	 * Service retoune l'ensemble des RDV
	 * 
	 * @return liste des RDV
	 */
	List<Appointment> findAllApointments();
}
