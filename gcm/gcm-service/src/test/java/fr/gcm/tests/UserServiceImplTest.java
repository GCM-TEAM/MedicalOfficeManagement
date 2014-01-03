package fr.gcm.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gcm.model.User;
import fr.gcm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/springConfig/gcmService-cfg.xml"})
public class UserServiceImplTest
{
	@Autowired
	private UserService userService;

	@Test
	public void addUserTest() 
	{
		User user = new User();
		user.setNom("khaled-3");
		user.setPassword("ssiirroopp");
		userService.addUser(user);
		assertNotNull(user.getUserID());
	}

}