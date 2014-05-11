package fr.gcm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gcm.dao.IPatientRepository;
import fr.gcm.model.Patient;
import fr.gcm.service.IPatientService;

/**
 * 
 * @author ML11181N
 * 
 *         Implementation des comportements décrits dans l'interface de l'objet
 *         patient dans la couche service
 */

@Service("patientService")
@Transactional
public class PatientService implements IPatientService {

	/**
	 * Service patient repository
	 */
	private IPatientRepository patientRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPatient(Patient bnsObjpatient) {
			patientRepository.addPatient(bnsObjpatient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updatePatientByEventID(Patient bnsObjPatient) {
			return patientRepository.updatePatientByEventID(bnsObjPatient);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Patient> findAllPatient() {
		return patientRepository.findAllPatients();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deletePatientByEventID(String eventID) {
		patientRepository.detetePatientByEventID(eventID);		
	}

	/**
	 * @param patientRepository
	 *            the patientRepository to set
	 */
	@Autowired
	public void setPatientRepository(IPatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
}
