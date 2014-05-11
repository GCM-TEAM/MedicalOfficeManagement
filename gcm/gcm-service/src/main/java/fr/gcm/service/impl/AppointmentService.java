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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAppointment(Appointment bnsObjAppointment) {
		appointmentRepository.addAppointment(bnsObjAppointment);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateAppointmentByEventID(Appointment bnsObjAppointment) {
		return appointmentRepository
				.updateAppointmentByEventID(bnsObjAppointment);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Appointment> findAllApointments() {
		return appointmentRepository.findAllApointments();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAppointementByEventID(String eventID) {
		appointmentRepository.deteteAppointmentByEventID(eventID);
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
