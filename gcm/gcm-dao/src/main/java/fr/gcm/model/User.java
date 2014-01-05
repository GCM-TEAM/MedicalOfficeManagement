package fr.gcm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author MLoubari
 *
 */

@Entity
@Table(name = "USER")
@SequenceGenerator( sequenceName="USER_ID_SEQ", name="USER_ID_SEQ", allocationSize = 1 )
public class User implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private Long 	userID;			// - Clﾃｩ primaire de la table user
	private String 	firstName;		// - Nom d'utilisateur
	private String 	lastName;		// pr始om de l'utilisateur
	private String 	login;			// login de l'utilisateur
	private String  password;		// - Mot de passse d'utilisateur
	
	//private Set<Profiles> 	 profiles 	  = new HashSet<Profiles>();
	//private Set<Appointment> appointments = new HashSet<Appointment>();
	
	/**
	 * Constructeur : crﾃｩe une nouvelle instance de : User
	 */
	public User() {}

	/*
	 * D伺inition des accesseurs des champs priv仔
	 */
	
	@Override
	public String toString()
	{	
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("firstName = " + firstName);
		sb.append(", lastName = " + lastName);
		sb.append(", login = " + login);
		sb.append("]");
		
		return sb.toString();
	}

	@Override
	public int hashCode() 
	{
		int result = 0;
		if (this.getUserID() == null) result = super.hashCode();
		else result = result * 3 + this.getUserID().hashCode();
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{	
		if (this == obj) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		User user = (User) obj;
		if (user.getUserID() == null || this.getUserID() == null) return false;
		return (user.getUserID().equals(this.getUserID()));
	}
	
	/*
	 * getter & setter
	 */
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ" )
	@Column( name = "USERID" , unique =  true , nullable = false )
	public Long getUserID() {return userID;}
	public void setUserID(Long userID) {this.userID = userID;}

	@Column( name = "PASSWORD", nullable = false )
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	@Column(name="FIRSTNAME")
	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	@Column(name="LASTNAME")
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}

	@Column(name="LOGIN", nullable = false)
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}

	/*@ManyToMany(
					cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
				 ,	fetch = FetchType.EAGER
			)
	@JoinTable(
			name = "USER_PROFILES"
		,	joinColumns = @JoinColumn (name = "USERID", referencedColumnName = "USERID")
		,	inverseJoinColumns = @JoinColumn(name = "PROFILESID", referencedColumnName = "PROFILESID")    
	)
	public Set<Profiles> getProfiles() {return profiles;}
	public void setProfiles(Set<Profiles> profiles) {this.profiles = profiles;}

	@ManyToMany(
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}
		 ,	fetch = FetchType.EAGER
	)
	@JoinTable(
			name = "USER_APPOINTMENT"
		,	joinColumns = @JoinColumn (name = "USERID", referencedColumnName = "USERID")
		,	inverseJoinColumns = @JoinColumn(name = "APPOINTMENTID", referencedColumnName = "APPOINTMENTID") 
	)
	public Set<Appointment> getAppointments() {return appointments;}
	public void setAppointments(Set<Appointment> appointments) {this.appointments = appointments;}
*/	
}