package fr.gcm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.IProfilesRepository;
import fr.gcm.model.Profiles;
import fr.gcm.service.IProfilesService;

/**
 * 
 * @author ML11181N
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         profiles dans la couche service.
 * 
 */
@Service("profilesService")
@Transactional
public class ProfilesServiceImpl implements IProfilesService {

	/**
	 * Service profiles repository
	 */
	private IProfilesRepository profilesRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addProfile(Profiles profile) {

		if (profile != null) {
			profilesRepository.addProfile(profile);
		}
	}

	/*
	 * Getters & Setters
	 */

	/**
	 * Inject l'objet profil
	 * 
	 * @param profilesRepository
	 *            profil
	 */
	@Autowired
	public void setProfilesRepository(IProfilesRepository profilesRepository) {
		this.profilesRepository = profilesRepository;
	}
}
