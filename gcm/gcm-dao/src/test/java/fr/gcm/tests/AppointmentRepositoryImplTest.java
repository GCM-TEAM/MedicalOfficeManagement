package fr.gcm.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gcm.dao.IAppointmentRepsitory;
import fr.gcm.model.Appointment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/springConfig/gcmdao-cfg.xml" })
public class AppointmentRepositoryImplTest {

	@Autowired
	private IAppointmentRepsitory appointmentRepository;

	Appointment bnsObjAppointment;

	@Before
	public void setUp() throws Exception {
		bnsObjAppointment = new Appointment();
		bnsObjAppointment.setStartDate(new Date());
		bnsObjAppointment.setEndDate(new Date());
		bnsObjAppointment.setTitle("mounir");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAppointment() {
		appointmentRepository.addAppointment(bnsObjAppointment);
		assertNotNull(bnsObjAppointment.getAppointmentID());
	}

	@Test
	public void testUpdateAppointment() {

		bnsObjAppointment.setEventID("61981e87-f508-4707-8a51-d51eef9dcae5");
		assertTrue(appointmentRepository.updateAppointment(bnsObjAppointment));
	}

}
