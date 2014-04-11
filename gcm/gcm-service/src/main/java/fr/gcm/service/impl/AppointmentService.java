package fr.gcm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void addAppointment(Appointment bnsObjAppointment) {

		if (bnsObjAppointment != null) {
			appointmentRepository.addAppointment(bnsObjAppointment);
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateAppointment(Appointment bnsObjAppointment) {

		if (bnsObjAppointment != null) {
			return appointmentRepository.updateAppointment(bnsObjAppointment);
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Appointment> findAllApointments() {
		return appointmentRepository.findAllApointments();
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
