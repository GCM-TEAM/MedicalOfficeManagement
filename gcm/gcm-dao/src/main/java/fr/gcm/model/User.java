package fr.gcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private Long 	userID;		// - Clé primaire de la table user
	private String 	nom;		// - Nom d'utilisateur
	private String  password;	// - Mot de passse d'utilisateur
	
	/**
	 * Constructeur : crée une nouvelle instance de : User
	 */
	public User() {}

	/*
	 * Définition des accesseurs des champs privé
	 */
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ" )
	@SequenceGenerator( sequenceName="USER_ID_SEQ", name="USER_ID_SEQ", allocationSize = 1 )
	@Column( name = "USERID" )
	public Long getUserID() {return userID;}

	public void setUserID(Long userID) {this.userID = userID;}

	@Column( name = "NOM" )
	public String getNom() {return nom;}

	public void setNom(String nom) {this.nom = nom;}

	@Column( name = "PASSWORD" )
	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}
}