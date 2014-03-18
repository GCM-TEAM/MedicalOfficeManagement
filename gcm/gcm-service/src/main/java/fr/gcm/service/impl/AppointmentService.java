package fr.gcm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.business.objects.BnsObjAppointment;
import fr.gcm.dao.IAppointmentRepsitory;
import fr.gcm.model.Appointment;
import fr.gcm.service.IAppointmentService;

/**
 * 
 * @author ML11181N
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         appointment dans la couche service
 */
@Service("appointmentService")
@Transactional
public class AppointmentService implements IAppointmentService {

	/**
	 * Service appointment repository
	 */
	private IAppointmentRepsitory appointmentRepository;

	@Override
	public void addAppointment(BnsObjAppointment bnsObjAppointment) {

		if (bnsObjAppointment != null) {
			appointmentRepository.addAppointment(bnsObjAppointment);
		}
	}

	/*
	 * Getters & Setters
	 */
	/**
	 * @param appointmentRepository
	 *            the appointmentRepository to set
	 */
	@Autowired
	public void setAppointmentRepository(
			IAppointmentRepsitory appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
}
