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
 * @author Amina
 * 
 *         Modele de la table adresse
 * 
 */
@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(sequenceName = "ADDRESS_ID_SEQ", name = "ADDRESS_ID_SEQ", allocationSize = 1)
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long addressID; // clé primaire
	private String eventID; // identifiant de l'evenenment de la calendrier
	private Integer number; // numero de la rue
	private String street; // nom de la rue
	private Integer zipCode; // code postal
	private String city; // ville
	private String country; // pays
	private Patient patient; // clé etrangére

	/**
	 * Constructeur par défaut : cree une instance de : Address
	 */

	public Address() {
	}

	/*
	 * Override hashCode, Equals & toString
	 */

	/**
	 * Comparer deux objets Address
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		Address address = (Address) obj;
		if (address.getAddressID() == null || this.getAddressID() == null)
			return false;
		return (address.getAddressID().equals(this.getAddressID()));
	}

	/**
	 * Retoune le hashCode de l'objet de Address
	 */
	@Override
	public int hashCode() {
		int result = 0;
		if (this.getAddressID() == null)
			result = super.hashCode();
		else
			result = result * 3 + this.getAddressID().hashCode();
		return result;
	}

	/**
	 * Afficher les champs de l'objet Address
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[number = " + number);
		sb.append(", street = " + street);
		sb.append(", zip code = " + zipCode);
		sb.append(", city = " + city);
		sb.append(", country = " + country + "]");

		return sb.toString();
	}

	/**
	 * @return the addressID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_ID_SEQ")
	@Column(name = "ADDRESSID", unique = true, nullable = false)
	public Long getAddressID() {
		return addressID;
	}

	/**
	 * @param addressID
	 *            the addressID to set
	 */
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	/**
	 * @return the number
	 */
	@Column(name = "NUMBER")
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the street
	 */
	@Column(name = "STREET")
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the zipCode
	 */
	@Column(name = "ZIPCODE")
	public Integer getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the patient
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENTID", nullable = false)
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
	 * @return the eventID
	 */
	@Column(name = "EVENTID", unique = true)
	public String getEventID() {
		return eventID;
	}

	/**
	 * @param eventID the eventID to set
	 */
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
}
