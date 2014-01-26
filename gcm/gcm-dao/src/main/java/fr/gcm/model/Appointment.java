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
@SequenceGenerator( sequenceName="APPOINTMENT_ID_SEQ", name="APPOINTMENT_ID_SEQ", allocationSize = 1 )
public class Appointment implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long 	appointmentID;			// identifiant du RDV
	private Date 	appointmentDate;		// la date du RDV
	private String	comment;				// commentaire
	private Patient patient; 				// patient
	private Consultation consultation; 		//consultation
	/**
	 * Constructeur : cre une nouvelle instance de : RendezVous
	 */
	public Appointment() {}

	/*
	 * override hashCode, equals & toString
	 */
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		User user = (User) obj;
		if (user.getUserID() == null || this.getAppointmentID() == null) return false;
		return (user.getUserID().equals(this.getAppointmentID()));
	}

	@Override
	public int hashCode()
	{
		int result = 0; 
		if (this.getAppointmentID() == null) result = super.hashCode();
		else result = result * 3 + this.getAppointmentID().hashCode();
		return result;
	}

	@Override
	public String toString() 
	{
		StringBuffer sb = new  StringBuffer("[");
		sb.append("appointmentDate = " + appointmentDate);
		sb.append(", comment = " + comment);
		sb.append("]");
		return sb.toString();
	}
	
	/*
	 * getter & setter
	 */

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "APPOINTMENT_ID_SEQ" )		
	@Column(name = "APPOINTMENTID" , unique = true , nullable = false)
	public Long getAppointmentID() {return appointmentID;}
	public void setAppointmentID(Long appointmentID) {this.appointmentID = appointmentID;}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPOINTMENTDATE", unique = true, nullable = false)
	public Date getAppointmentDate() {return appointmentDate;}
	public void setAppointmentDate(Date appointmentDate) {this.appointmentDate = appointmentDate;}

	@Column(name = "COMMENT")
	public String getComment() {return comment;}
	public void setComment(String comment) {this.comment = comment;}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENTID")
	public Patient getPatient() {return patient;}
	public void setPatient(Patient patient) {this.patient = patient;}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "CONSULTATIONID")
//	public Consultation getConsultation() {return consultation;}
//	public void setConsultation(Consultation consultation) {this.consultation = consultation;}
}
