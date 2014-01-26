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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author MLOUBARI
 *
 */
@Entity
@Table(name="PRESCRIPTION")
@SequenceGenerator( sequenceName="PRESCRIPTION_ID_SEQ", name="PRESCRIPTION_ID_SEQ", allocationSize = 1 )
public class Prescription implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long prescriptionID;    	//identifiant de l'ordennance
	private Date prescriptionDate;		// date de d�livrance 
	private Set<Medecines> medecines = new HashSet<Medecines>();
	private Consultation consultation; //consultation
	
	
	/**
	 * Constructeur: cre� une nouvelle instance de : Prescrioption
	 */
	public Prescription() {}

	/*
	 * Override HashCode, Equals & toString
	 */
	
	@Override
	public boolean equals(Object obj) 
	{		
		if (this == obj) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Prescription prescription = (Prescription) obj;
		if (prescription.prescriptionID == null || this.prescriptionID == null) return false;
		return (prescription.prescriptionID.equals(this.prescriptionID));
	}

	@Override
	public int hashCode() 
	{
		int result = 0;
		if (this.prescriptionID == null) result = super.hashCode();
		else result = result * 3 + this.prescriptionID.hashCode();
		return result;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(", prescriptionDate = " + prescriptionDate);
		sb.append("]");
		return sb.toString();
	}
	
	/*
	 * getters & setters
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "PRESCRIPTION_ID_SEQ")
	@Column(name="PRESCRIPTIONID", unique = true , nullable = false)
	public Long getPrescriptionID() {return prescriptionID;}
	public void setPrescriptionID(Long prescriptionID) {this.prescriptionID = prescriptionID;}

	@Temporal(TemporalType.DATE)
	@Column(name="PRESCRIPTIONDATE", unique = true, nullable = false)
	public Date getPrescriptionDate() {return prescriptionDate;}
	public void setPrescriptionDate(Date prescriptionDate) {this.prescriptionDate = prescriptionDate;}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prescription")
	public Set<Medecines> getMedecines() {return medecines;}
	public void setMedecines(Set<Medecines> medecines) {this.medecines = medecines;}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONSULTATIONID" , nullable = false)
	public Consultation getConsultation() {return consultation;}
	public void setConsultation(Consultation consultation) {this.consultation = consultation;}
}
