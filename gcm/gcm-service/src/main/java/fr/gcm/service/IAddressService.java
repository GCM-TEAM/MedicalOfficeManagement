package fr.gcm.service;

import java.util.List;

import fr.gcm.model.Address;

/**
 * 
 * @author Amina
 * 
 *         Interface définit l'ensemble de traitements sur l'adresse dans la
 *         couche service.
 * 
 */
public interface IAddressService {

	/**
	 * Service d'ajout d'adresse
	 * 
	 * @param bnsObjAddress
	 *            objet metier adresse
	 */
	void addAddress(Address bnsObjAddress);

	/**
	 * Service de mise à jour des adresses
	 * 
	 * @param bnsObjadress
	 *            objet metier adresse
	 * @return boolean
	 */
	boolean updateAddressByEventID(Address bnsObjAdress);

	/**
	 * Service retourne l'ensemble des adresses
	 * 
	 * @return liste des adresses
	 */
	List<Address> findAllAddresses();
	
	/**
	 * Service de suppression des adresses
	 * @param eventID
	 * 			id evenement
	 */
	void deleteAddressByEventID(String eventID);
}
