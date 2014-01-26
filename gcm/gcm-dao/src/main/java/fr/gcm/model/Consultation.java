package fr.gcm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author MLoubari
 *
 */
@Entity
@Table(name = "CONSULTATION")
@SequenceGenerator( sequenceName="CONSULTATION_ID_SEQ", name="CONSULTATION_ID_SEQ", allocationSize = 1 )
public class Consultation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long consultationID; 			// id de la consultation
	private Date consultationDate;		 	// la date de la consultation
	private String report; 					// raport compl�mentaire sur la consultation
	private String resume; 					// le resum� d'une consultation
	private String details; 				// le d�tail d'une consultation
	private Set<Prescription> prescription = new HashSet<Prescription>();		// liste d'ordonnance

	/**
	 * Constructeur : cr�e une nouvelle instance de : Patient
	 */
	
	public Consultation() {}

	/*
	 *	Override hashCode, Equals & toString 
	 */

	@Override
	public boolean equals(Object obj) 
	{

		if(this == obj) return true;
		if(obj == null || this.getClass() != obj.getClass()) return false;
		Consultation consultation = (Consultation) obj;
		if(consultation.getConsultationID() == null || this.getConsultationID() == null) return false;
		return this.getConsultationID().equals(consultation.getConsultationID());
	}
	
	@Override
	public int hashCode() 
	{
		int result = 0; 
		if (this.getConsultationID() == null) result = super.hashCode();
		else result = result * 3 + this.getConsultationID().hashCode();
		return result;
	}
	
	@Override
	public String toString() 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("consultationDate = " + consultationDate);
		sb.append("report = " + report);
		sb.append("resume = " + resume);
		sb.append("details = " + details);
		sb.append("]");
		return sb.toString();
	}
	
	/**
	 * getters & setters
	 */
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CONSULTATION_ID_SEQ" )
	@Column(name = "CONSULTATIONID" , unique = true , nullable = false)
	public Long getConsultationID() {return consultationID;}
	public void setConsultationID(Long consultationID) {this.consultationID = consultationID;}

	@Column(name = "CONSULTATIONDATE")
	public Date getConsultationDate() {return consultationDate;}
	public void setConsultationDate(Date consultationDate) {this.consultationDate = consultationDate;}

	@Column(name = "REPORT")
	public String getReport() {return report;}
	public void setReport(String report) {this.report = report;}

	@Column(name = "RESUME")
	public String getResume() {return resume;}
	public void setResume(String resume) {this.resume = resume;}

	@Column(name = "DETAILS")
	public String getDetails() {return details;}
	public void setDetails(String details) {this.details = details;}
	
	@OneToMany( fetch = FetchType.LAZY , mappedBy = "consultation")
	public Set<Prescription> getPrescription() {return prescription;}
	public void setPrescription(Set<Prescription> prescription) {this.prescription = prescription;}

}