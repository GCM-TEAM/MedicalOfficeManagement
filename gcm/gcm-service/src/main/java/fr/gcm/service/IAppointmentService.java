package fr.gcm.service;

import fr.gcm.business.objects.BnsObjAppointment;

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
	void addAppointment(BnsObjAppointment bnsObjAppointment);
}
