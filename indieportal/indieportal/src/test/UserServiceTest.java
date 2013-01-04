package test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.IUserService;
import java.util.Date;

import domain.User;
import domain.User.Role;

public class UserServiceTest {

	protected static ApplicationContext appContext;
	IUserService us;
	User u;
	private User savedUser;
	
	@BeforeClass
	public static void setAppContext() {
		appContext = new ClassPathXmlApplicationContext("spring_config.xml");
	}
	
	@Before
	public void setUp() {
		us = (IUserService) appContext.getBean("userService");
		u = new User();
		Date d = new Date();
		u.setLogin("login");
		u.setName("name");
		u.setPassword("pass");
		u.setRole(Role.User);
		u.setDateOfLastVisit(d);
		u.setDateOfRegistration(d);
		u.setRating(1l);
		savedUser = us.save(u);
	}

	@Test
	public void testGetUserByLogin() {
		assert(us.getUserByLogin("login") == u);
	}

	@Test
	public void testIsUserExists() {
		assert(us.isUserExists("login"));
	}
	


}
