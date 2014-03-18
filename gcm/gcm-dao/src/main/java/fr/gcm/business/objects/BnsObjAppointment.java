package fr.gcm.business.objects;

import java.io.Serializable;
import java.util.Date;

import fr.gcm.model.Consultation;
import fr.gcm.model.Patient;
import fr.gcm.model.User;

/**
 * 
 * @author KBE
 * 
 * 
 *         Objet metier appointment
 * 
 */

public class BnsObjAppointment implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long appointmentID; // identifiant du RDV
	private Date startDate; // date de début de RDV
	private String data; // commentaire
	private Date endDate; // date de fin de RDV
	private String Title; // titre
//	private Patient patient; // patient
//	private Consultation consultation; // consultation

	/**
	 * Constructeur : cree une nouvelle instance de : RendezVous
	 */
	public BnsObjAppointment() {
	}

	/*
	 * override hashCode, equals & toString
	 */

	/**
	 * 
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
		StringBuffer sb = new StringBuffer("[");
		sb.append("appointmentDate = " + startDate);
		sb.append(", comment = " + data);
		sb.append("]");
		return sb.toString();
	}

	/*
	 * getter & setter
	 */

	/**
	 * 
	 * @return
	 */
	public Long getAppointmentID() {
		return appointmentID;
	}

	/**
	 * 
	 * @param appointmentID
	 */
	public void setAppointmentID(Long appointmentID) {
		this.appointmentID = appointmentID;
	}

	/**
	 * 
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public Patient getPatient() {
//		return patient;
//	}
//
//	public void setPatient(Patient patient) {
//		this.patient = patient;
//	}

	/**
	 * @return the endDate
	 */
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
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "CONSULTATIONID")
	// public Consultation getConsultation() {return consultation;}
	// public void setConsultation(Consultation consultation) {this.consultation
	// = consultation;}
}
