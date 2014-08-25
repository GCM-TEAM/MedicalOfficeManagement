package fr.gcm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.IAddressRepository;
import fr.gcm.model.Address;
import fr.gcm.service.IAddressService;

/**
 * 
 * @author Amina
 * 
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         address dans la couche service
 * 
 */
@Service("addressService")
@Transactional
public class AddressServiceImpl implements IAddressService {

	/**
	 * Service patient repository
	 */
	private IAddressRepository addressRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAddress(Address bnsObjAddress) {
			addressRepository.addAddress(bnsObjAddress);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateAddressByEventID(Address bnsObjAddress) {
			return addressRepository.updateAddressByEventID(bnsObjAddress);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Address> findAllAddresses() {
		return addressRepository.findAllAddresses();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAddressByEventID(String eventID) {
		addressRepository.deleteAddressByEventID(eventID);
	}

	/**
	 * @param addressRepository
	 *            the addressRepository to set
	 */
	@Autowired
	public void setAddressRepository(IAddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
}
