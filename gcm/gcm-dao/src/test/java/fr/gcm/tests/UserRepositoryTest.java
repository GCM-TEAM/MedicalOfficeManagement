package fr.gcm.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gcm.dao.IUserRepository;
import fr.gcm.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/springConfig/gcmdao-cfg.xml"})
public class UserRepositoryTest 
{
	@Autowired
	private IUserRepository userRepository;
	
	@Test
	public void createUserTest ()
	{
		User user = new User();
		user.setFirstName("khaled");
		user.setPassword("ssiirroopp");
		user.setLogin("test");
		user.setLastName("belhani");
		userRepository.addUser(user);
		assertNotNull(user.getUserID());
	}
}