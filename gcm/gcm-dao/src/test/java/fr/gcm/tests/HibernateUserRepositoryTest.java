package fr.gcm.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gcm.dao.UserRepository;
import fr.gcm.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/springConfig/gcmdao-cfg.xml"})
public class HibernateUserRepositoryTest 
{
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createUserTest ()
	{
		User user = new User();
		user.setNom("khaled");
		user.setPassword("ssiirroopp");
		userRepository.addUser(user);
		assertNotNull(user.getUserID());
	}
}