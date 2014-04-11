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

import fr.gcm.model.Appointment;
import fr.gcm.model.Patient;
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

	/**
	 * Stock les evenmenet
	 */
	private ScheduleModel eventModel;
	
	private String 	firstName;	 	// le pr�nom du patient
	private String 	lastName;		// le nom du patient
	private String 	maidenName;		// le nom de jeune fille
	private String 	address;		// l'adresse du patient
	private Long 	socialNumber;	// le numero de s�curit� sociale
	private String 	phoneNumber;	// le numero de t�l�phone du patient
	private Date 	birthDay;		// la date de naissance du patient
	private String 	sex;			// le sex du patient


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
	 * Evenement
	 */
	private ScheduleEvent event = new DefaultScheduleEvent();

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

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	/**
	 * Ajout des evenements dans le modele ainsi qu'un stockage en base
	 * 
	 * @param actionEvent
	 *            evenement
	 */
	public void addEvent(ActionEvent actionEvent) {

		Appointment bnsObjAppointment = new Appointment();
	

		if (event.getData() != null) {
			bnsObjAppointment.setData(event.getData().toString());
		}

		bnsObjAppointment.setTitle(event.getTitle());
		bnsObjAppointment.setStartDate(event.getStartDate());
		bnsObjAppointment.setEndDate(event.getEndDate());

		if (event.getId() == null) {
			eventModel.addEvent(event);
			bnsObjAppointment.setEventID(event.getId());
			appointmentService.addAppointment(bnsObjAppointment);
		} else {
			bnsObjAppointment.setEventID(event.getId());
			eventModel.updateEvent(event);
			appointmentService.updateAppointment(bnsObjAppointment);
		}
		event = new DefaultScheduleEvent();
	}

	/**
	 * 
	 * @param selectEvent
	 */
	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(),
				(Date) selectEvent.getObject());
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
		
		appointmentService.updateAppointment(bnsObjAppointment);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Event resized", "Day delta:" + event.getDayDelta()
						+ ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the maidenName
	 */
	public String getMaidenName() {
		return maidenName;
	}

	/**
	 * @param maidenName the maidenName to set
	 */
	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the socialNumber
	 */
	public Long getSocialNumber() {
		return socialNumber;
	}

	/**
	 * @param socialNumber the socialNumber to set
	 */
	public void setSocialNumber(Long socialNumber) {
		this.socialNumber = socialNumber;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the birthDay
	 */
	public Date getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the patientService
	 */
	public IPatientService getPatientService() {
		return patientService;
	}

	/**
	 * @param patientService the patientService to set
	 */
	public void setPatientService(IPatientService patientService) {
		this.patientService = patientService;
	}
}
