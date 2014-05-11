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
 * @author MLoubari
 *
 *	
 *			Modele de l'objet profiles
 */


@Entity
@Table(name = "PROFILES")
@SequenceGenerator( sequenceName="PROFILE_ID_SEQ", name="PROFILE_ID_SEQ", allocationSize = 1 )
public class Profiles implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Long 	profilesID; 			// identifiant profiles
	private String  profile;				// profile des utilisateurs
	private User user;						// clé etrangére utilisateur
	
	/**
	 * Constructeur : cre une nouvelle instance de : Profiles
	 */
	public Profiles() {}

	@Override
	public boolean equals(Object obj) 
	{
		// des objets avec la meme rfrence.
		if(this == obj) return true;
		//objet null ou pas le meme type d'instance de classe 
		if(obj == null || this.getClass() != obj.getClass()) return false;
		//cast obj
		Profiles profiles = (Profiles) obj;
		// verifier des id des deux obejts
		if(profiles.getProfilesID() == null || this.getProfilesID() == null) return false;
		return this.getProfilesID().equals(profiles.getProfilesID());
	}

	@Override
	public int hashCode() 
	{
		int result = 0;
		if (this.getProfilesID() == null) result = super.hashCode();
		else result = result * 3 + this.getProfilesID().hashCode();
		return result;
	}

	@Override
	public String toString() 
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("Profile = " + profile);
		sb.append("]");
		return sb.toString();
	}	
		
	
	/*
	 * getter & setter 
	 */

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "PROFILE_ID_SEQ" )
	@Column(name = "PROFILESID" , unique = true , nullable = false)
	public Long getProfilesID() {return profilesID;}
	public void setProfilesID(Long profilesID) {this.profilesID = profilesID;}
	
	@Column(name = "PROFILE")
	public String getProfile() {return profile;}
	public void setProfile(String profile) {this.profile = profile;}

	/**
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID" , nullable = false )
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}	
}