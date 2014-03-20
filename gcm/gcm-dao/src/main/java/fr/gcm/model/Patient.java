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
@Table(name = "PATIENT")
@SequenceGenerator( sequenceName="PATIENT_ID_SEQ", name="PATIENT_ID_SEQ", allocationSize = 1 )
public class Patient implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Long 	patientID;    	// identifiant du patient
	private String 	firstName;	 	// le pr�nom du patient
	private String 	lastName;		// le nom du patient
	private String 	maidenName;		// le nom de jeune fille
	private Integer age;			// l'age du patient
	private String 	address;		// l'adresse du patient
	private Long 	socialNumber;	// le numero de s�curit� sociale
	private String 	phoneNumber;	// le numero de t�l�phone du patient
	private Date 	birthDay;		// la date de naissance du patient
	private String 	sex;			// le sex du patient
	
//	private Set<Appointment> appointments = new HashSet<Appointment>();   // liste des RDVs
//	private Set<Consultation> consultations = new HashSet<Consultation>(); // liste des consultations 
	
	/**
	 * Constructeur : cr�e une nouvelle instance de : Patient
	 */
	public Patient() {}
	
	/*
	 *	Override hashCode, Equals & toString 
	 */
	
	@Override
	public boolean equals(Object obj) 
	{		
		if (this == obj) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		User user = (User) obj;
		if (user.getUserID() == null || this.getPatientID() == null) return false;
		return (user.getUserID().equals(this.getPatientID()));
	}

	@Override
	public int hashCode() 
	{
		int result = 0;
		if (this.getPatientID() == null) result = super.hashCode();
		else result = result * 3 + this.getPatientID().hashCode();
		return result;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("firstName = " + firstName);
		sb.append(", lastName = " + lastName);
		sb.append(", maidenName = " + maidenName);
		sb.append(", age = " + age);
		sb.append(", address = " + address);
		sb.append(", socialNumber = " + socialNumber);
		sb.append(", phoneNumber = " + phoneNumber);
		sb.append(", birthDay = " + birthDay);
		sb.append(", sex = " + sex);
		sb.append("]");
		
		return sb.toString();
	}
	
	/*
	 * getter & setter 
	 */

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PATIENT_ID_SEQ" )
	@Column(name = "PATIENTID" , unique =  true , nullable = false)
	public Long getPatientID() {return patientID;}
	public void setPatientID(Long patientID) {this.patientID = patientID;}
	
	@Column(name = "FIRSTNAME")
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	@Column(name = "LASTNAME")
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	@Column(name = "MAIDENNAME")
	public String getMaidenName() {return maidenName;}
	public void setMaidenName(String maidenName) {this.maidenName = maidenName;}
	
	@Column(name = "AGE")
	public Integer getAge() {return age;}
	public void setAge(Integer age) {this.age = age;}
	
	@Column(name = "ADDRESS")
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	
	@Column(name = "SOCIALNUMBER")
	public Long getSocialNumber() {return socialNumber;}
	public void setSocialNumber(Long socialNumber) {this.socialNumber = socialNumber;}
	
	@Column(name = "PHONENUMBER")
	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

	@Column(name = "BIRTHDAY")
	public Date getBirthDay() {return birthDay;}
	public void setBirthDay(Date birthDay) {this.birthDay = birthDay;}
	
	@Column(name = "SEX")
	public String getSex() {return sex;}
	public void setSex(String sex) {this.sex = sex;}

//	@OneToMany(fetch = FetchType.LAZY , mappedBy = "patient")
//	public Set<Appointment> getAppointments() {return appointments;}
//	public void setAppointments(Set<Appointment> appointments) {this.appointments = appointments;}

//	@OneToMany(fetch = FetchType.LAZY , mappedBy = "patient")
//	public Set<Consultation> getConsultations() {return consultations;}
//	public void setConsultations(Set<Consultation> consultations) {this.consultations = consultations;}
}