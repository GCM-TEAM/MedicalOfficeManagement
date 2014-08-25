package fr.gcm.model;

import java.io.Serializable;

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

/**
 * 
 * @author MLOUBARI
 *
 */

@Entity
@Table(name = "MEDECINES")
@SequenceGenerator( sequenceName="MEDECINES_ID_SEQ", name="MEDECINES_ID_SEQ", allocationSize = 1 )
public class Medecines implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer medecinesID; 			//identifiant du mdicament
	private String 	name;  					// le nom du mdicaments
	private Integer quantity;				// la quantit prescrite
	private Integer use;  					// le nombre d'utilisation
	private Prescription prescription;	    // ordonnance 
	/**
	 * Constructeur : cre une nouvelle instance de : Medecines
	 */
	
	public Medecines() {}


	
	/*
	 * Override HashCode, Equals & toString
	 */
	
	@Override
	public String toString()
	{	
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("name = " + name);
		sb.append(", quantity = " + quantity);
		sb.append(", use = " + use);
		sb.append("]");
		
		return sb.toString();
	}

	@Override
	public int hashCode() 
	{
		int result = 0;
		if (this.getMedecinesID() == null) result = super.hashCode();
		else result = result * 3 + this.getMedecinesID().hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{	
		if (this == obj) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		Medecines medecines = (Medecines) obj;
		if (medecines.getMedecinesID() == null || this.getMedecinesID() == null) return false;
		return (medecines.getMedecinesID().equals(this.getMedecinesID()));
	}
	/*
	 * getters & setters
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDECINES_ID_SEQ")
	@Column(name = "MEDECINESID" , unique = true , nullable = false)
	public Integer getMedecinesID() {return medecinesID;}
	public void setMedecinesID(Integer medecinesID) {this.medecinesID = medecinesID;}
	
	@Column(name = "NAME")
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	@Column(name = "QUANTITY")
	public Integer getQuantity() {return quantity;}
	public void setQuantity(Integer quantity) {this.quantity = quantity;}

	@Column(name = "USE")
	public Integer getUse() {return use;}
	public void setUse(Integer use) {this.use = use;}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PRESCRIPTIONID")
	public Prescription getPrescription() {return prescription;}
	public void setPrescription(Prescription prescription) {this.prescription = prescription;}
}
