package test;

import org.junit.Before;
import org.junit.Test;

import services.IUserService;
import services.UserService;

import domain.User;

public class IUserServiceTest {

	IUserService us;
	User u;
	@Before
	public void setUp() throws Exception {
		us = new UserService(); 
		u = new User();
		u.setLogin("login");
		us.save(u);
	}

	@Test
	public void testGetUserByLogin() {
		
		
		boolean flag = false;
		
		try {
			assert(us.getUserByLogin("login") == u);
			us.getUserByLogin("aaa");
		} catch (Exception e) {
			flag = true;
		}
		assert(flag);
		
	}

	@Test
	public void testIsUserExists() {
		assert(us.isUserExists("login"));
	}
	


}
