package fr.gcm.dao;

import fr.gcm.model.Address;
import java.util.List;

/**
 * 
 * @author ML11181N
 * 
 *         Interface définit l'ensemble de traitements sur les adresses dans la
 *         couche DAO.
 */

public interface IAddressRepository {

	/**
	 * Ajout d'une nouvelle adresse
	 * 
	 * @param address
	 *            adresse du patient
	 */
	void addAddress(Address address);

	/**
	 * Mise à jour de l'adresse du patient par id
	 * 
	 * @param address
	 *            nouvelle adresse du patient
	 * @return
	 */
	boolean updateAddressByID(Address address);
	
	/**
	 * Mise à jour de l'adresse du patient par l'id de l'evenement 
	 * 
	 * @param address
	 *            nouvelle adresse du patient
	 * @return
	 */
	boolean updateAddressByEventID(Address bnsObjAddress);

	/**
	 * Retourne toutes les adresses du patient
	 * 
	 * @return liste d'adresse du patient
	 * 
	 */
	List<Address> findAllAddresses();
	
	/**
	 * Supprimer les adresse avec l'id de l'evenement
	 * @param eventID
	 *  			id de l'evenement
	 */
	void deleteAddressByEventID(String eventID);

}
