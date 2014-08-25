package fr.gcm.managed.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.gcm.model.Address;
import fr.gcm.model.Appointment;
import fr.gcm.model.Patient;
import fr.gcm.service.IAddressService;
import fr.gcm.service.IAppointmentService;
import fr.gcm.service.IPatientService;

/**
 * 
 * @author Amina
 * 
 *         Permet de planifier un rendez vous avec le(s) medecin(s).
 */
@ManagedBean(name = "scheduleMB")
@SessionScoped
public class SchedulerManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SchedulerManagedBean.class);

	/**
	 * Stocke les evenements
	 */
	private ScheduleModel eventModel;

	/**
	 * Service appointment
	 */
	@ManagedProperty(value = "#{appointmentService}")
	private IAppointmentService appointmentService;

	/**
	 * Service patient
	 */
	@ManagedProperty(value = "#{patientService}")
	private IPatientService patientService;

	/**
	 * Service address
	 */
	@ManagedProperty(value = "#{addressService}")
	private IAddressService addressService;

	/**
	 * Evenement
	 */
	private ScheduleEvent appointmentEvent = new DefaultScheduleEvent();

	/**
	 * Patient
	 */
	private Patient patient = new Patient();

	/**
	 * Adresse
	 */
	private Address address = new Address();

	/**
	 * Initialise les evenmenet stocker en base
	 */
	public SchedulerManagedBean() {
		eventModel = new DefaultScheduleModel();
	}

	/**
	 * Initialisation des RDV aprés la création de l'objet scheduler
	 */
	@PostConstruct
	private void init() {
		List<Appointment> appointments = appointmentService
				.findAllApointments();
		for (Appointment appointment : appointments) {
			eventModel.addEvent(new DefaultScheduleEvent(
					appointment.getTitle(), appointment.getStartDate(),
					appointment.getEndDate()));
		}
	}

	/**
	 * Ajout des evenements dans le modele ainsi qu'un stockage en base
	 * 
	 * @param actionEvent
	 *            evenement
	 */
	public void addEvent(ActionEvent actionEvent) {

		// Creer l'objet Appointment
		Appointment bnsObjAppointment = new Appointment();

		if (appointmentEvent.getData() != null) {
			bnsObjAppointment.setData(appointmentEvent.getData().toString());
		}

		bnsObjAppointment.setTitle(appointmentEvent.getTitle());
		bnsObjAppointment.setStartDate(appointmentEvent.getStartDate());
		bnsObjAppointment.setEndDate(appointmentEvent.getEndDate());

		LOGGER.debug("Objet metier Appointment" + bnsObjAppointment);

		// Creer l'objet Patient
		Patient bnsObjPatient = new Patient();
		bnsObjPatient.setFirstName(patient.getFirstName());
		bnsObjPatient.setLastName(patient.getLastName());
		bnsObjPatient.setMaidenName(patient.getMaidenName());
		bnsObjPatient.setSocialNumber(patient.getSocialNumber());
		bnsObjPatient.setPhoneNumber(patient.getPhoneNumber());
		bnsObjPatient.setBirthDay(patient.getBirthDay());
		bnsObjPatient.setSex(patient.getSex());

		LOGGER.debug("Objet metier Patient" + bnsObjPatient);

		// Ceer adresse objet
		Address bnsObjAddress = new Address();
		bnsObjAddress.setNumber(address.getNumber());
		bnsObjAddress.setStreet(address.getStreet());
		bnsObjAddress.setZipCode(address.getZipCode());
		bnsObjAddress.setCity(address.getCity());
		bnsObjAddress.setCountry(address.getCountry());

		// Creer une jointure entre les deux tables PATIENT et APPAOINTMENT
		bnsObjAppointment.setPatient(bnsObjPatient);
		bnsObjPatient.getAppointments().add(bnsObjAppointment);

		// Creer une jointure entre les deux tables PATIENT et ADDRESS
		bnsObjAddress.setPatient(bnsObjPatient);
		bnsObjPatient.getAddresses().add(bnsObjAddress);

		if (appointmentEvent.getId() == null) {
			eventModel.addEvent(appointmentEvent);
			bnsObjAppointment.setEventID(appointmentEvent.getId());
			bnsObjPatient.setEventID(appointmentEvent.getId());
			bnsObjAddress.setEventID(appointmentEvent.getId());

			patientService.addPatient(bnsObjPatient);
			appointmentService.addAppointment(bnsObjAppointment);
			addressService.addAddress(bnsObjAddress);
		} else {
			bnsObjAppointment.setEventID(appointmentEvent.getId());
			bnsObjPatient.setEventID(appointmentEvent.getId());
			bnsObjAddress.setEventID(appointmentEvent.getId());

			eventModel.updateEvent(appointmentEvent);
			appointmentService.updateAppointmentByEventID(bnsObjAppointment);
			patientService.updatePatientByEventID(bnsObjPatient);
			addressService.updateAddressByEventID(bnsObjAddress);
		}
		appointmentEvent = new DefaultScheduleEvent();
		patient = new Patient();
		address = new Address();
	}

	/**
	 * Supprimer le RDV
	 * 
	 * @param actionEvent
	 * 
	 *            action event
	 * 
	 */
	public void deleteAppointment(ActionEvent actionEvent) {
		eventModel.deleteEvent(appointmentEvent);
		appointmentService
				.deleteAppointementByEventID(appointmentEvent.getId());
		addressService.deleteAddressByEventID(appointmentEvent.getId());
		patientService.deletePatientByEventID(appointmentEvent.getId());
	}

	/**
	 * Retourne toutes les adresses
	 * 
	 * @return liste d'adresse
	 *//*
	public List<Address> findAllAddresses() {
		return addressService.findAllAddresses();
	}*/

	/**
	 * 
	 * @param selectEvent
	 */
	public void onEventSelect(SelectEvent selectEvent) {
		appointmentEvent = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		appointmentEvent = new DefaultScheduleEvent("",
				(Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event moved", "Day delta:" + event.getDayDelta()
						+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {

		Appointment bnsObjAppointment = new Appointment();

		if (event.getScheduleEvent().getData() != null) {
			bnsObjAppointment.setData(event.getScheduleEvent().getData()
					.toString());
		}
		bnsObjAppointment.setEventID(event.getScheduleEvent().getId());
		bnsObjAppointment.setTitle(event.getScheduleEvent().getTitle());
		bnsObjAppointment.setStartDate(event.getScheduleEvent().getStartDate());
		bnsObjAppointment.setEndDate(event.getScheduleEvent().getEndDate());

		appointmentService.updateAppointmentByEventID(bnsObjAppointment);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event resized", "Day delta:" + event.getDayDelta()
						+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/*
	 * Getters setters
	 */
	/**
	 * @return the appointmentService
	 */
	public IAppointmentService getAppointmentService() {
		return appointmentService;
	}

	/**
	 * @param appointmentService
	 *            the appointmentService to set
	 */
	public void setAppointmentService(IAppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	/**
	 * @return the eventModel
	 */
	public ScheduleModel getEventModel() {
		return eventModel;
	}

	/**
	 * @param eventModel
	 *            the eventModel to set
	 */
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	/**
	 * @return the patientService
	 */
	public IPatientService getPatientService() {
		return patientService;
	}

	/**
	 * @param patientService
	 *            the patientService to set
	 */
	public void setPatientService(IPatientService patientService) {
		this.patientService = patientService;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the addressService
	 */
	public IAddressService getAddressService() {
		return addressService;
	}

	/**
	 * @param addressService
	 *            the addressService to set
	 */
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * @return the appointmentEvent
	 */
	public ScheduleEvent getAppointmentEvent() {
		return appointmentEvent;
	}

	/**
	 * @param appointmentEvent
	 *            the appointmentEvent to set
	 */
	public void setAppointmentEvent(ScheduleEvent appointmentEvent) {
		this.appointmentEvent = appointmentEvent;
	}
}
