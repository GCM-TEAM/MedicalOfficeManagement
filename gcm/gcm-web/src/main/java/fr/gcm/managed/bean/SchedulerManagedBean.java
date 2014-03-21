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
import fr.gcm.service.IAppointmentService;

/**
 * 
 * @author Amina
 * 
 *         Permet de planifier un rendez vous avec le(s) medecin(s).
 */
@ManagedBean(name = "schudelerMB")
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

	/**
	 * Service appointment
	 */
	@ManagedProperty(value = "#{appointmentService}")
	private IAppointmentService appointmentService;

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

		if (event.getTitle() != null) {
			bnsObjAppointment.setTitle(event.getTitle());
		}
		bnsObjAppointment.setStartDate(event.getStartDate());
		bnsObjAppointment.setEndDate(event.getEndDate());

		if (event.getId() == null) {

			eventModel.addEvent(event);

			bnsObjAppointment.setEventID(event.getId());
			appointmentService.addAppointment(bnsObjAppointment);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Event add", "even: " + event.getTitle());

			addMessage(message);

		} else {

			bnsObjAppointment.setEventID(event.getId());
			eventModel.updateEvent(event);

			appointmentService.updateAppointment(bnsObjAppointment);

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Event updated", "new event: " + event.getTitle());

			addMessage(message);
		}

		event = new DefaultScheduleEvent();
	}

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
}
