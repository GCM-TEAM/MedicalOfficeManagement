package fr.gcm.dao;

import fr.gcm.business.objects.BnsObjAppointment;
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
	 * @param appointment
	 *            RDV
	 */
	void addAppointment(BnsObjAppointment bnsObjAppointment);
}
