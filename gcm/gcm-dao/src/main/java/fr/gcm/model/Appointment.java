package fr.gcm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author KBE
 * 
 */

@Entity
@Table(name = "APPOINTMENT")
@SequenceGenerator(sequenceName = "APPOINTMENT_ID_SEQ", name = "APPOINTMENT_ID_SEQ", allocationSize = 1)
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long appointmentID; // identifiant du RDV
	private String eventID; // identifiant de l'evenenment de la calendrier
	private Date startDate; // date de début de RDV
	private String data; // commentaire
	private Date endDate; // date de fin de RDV
	private String title; // titre
	private Patient patient; // patient

	// private Consultation consultation; // consultation

	/**
	 * Constructeur : cree une nouvelle instance de : RendezVous
	 */
	public Appointment() {
	}

	/*
	 * override hashCode, equals & toString
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		User user = (User) obj;
		if (user.getUserID() == null || this.getAppointmentID() == null)
			return false;
		return (user.getUserID().equals(this.getAppointmentID()));
	}

	@Override
	public int hashCode() {
		int result = 0;
		if (this.getAppointmentID() == null)
			result = super.hashCode();
		else
			result = result * 3 + this.getAppointmentID().hashCode();
		return result;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[startDate = " + startDate);
		sb.append(", comment = " + data);
		sb.append(", endDate = " + endDate);
		sb.append(", title = " + title);
		sb.append(", patient = " + patient + "]");
		return sb.toString();
	}

	/*
	 * getter & setter
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPOINTMENT_ID_SEQ")
	@Column(name = "APPOINTMENTID", unique = true, nullable = false)
	public Long getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(Long appointmentID) {
		this.appointmentID = appointmentID;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTDATE", unique = true, nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENTID")
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the endDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDDATE", unique = true, nullable = false)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the data
	 */
	@Column(name = "DATA")
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the title
	 */
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the eventID
	 */
	@Column(name = "EVENTID", unique = true)
	public String getEventID() {
		return eventID;
	}

	/**
	 * @param eventID
	 *            the eventID to set
	 */
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "CONSULTATIONID")
	// public Consultation getConsultation() {return consultation;}
	// public void setConsultation(Consultation consultation) {this.consultation
	// = consultation;}
}
