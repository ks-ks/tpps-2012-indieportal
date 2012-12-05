package test;

import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import domain.User.Role;

public class UserTest {
	User u;

	@Before
	public void setUp() throws Exception {
		u = new User();
		Date d = new Date();
		u.setDateOfLastVisit(d);
		u.setLogin("login");
		u.setName("name");
		u.setPassword("password");
		u.setRole(Role.Guest);
	}

	@Test
	public void testCheckPassword() {
		assert(u.checkPassword("password"));
	}
	@Test
	public void testGetRole() {
		assert(u.getRole() == Role.Guest);
		assertFalse(u.getRole() == Role.Administrator);

	}
	@Test
	public void testSetRole() {
		assert(u.getRole() == Role.Guest);
		u.setRole(Role.Administrator);
		assert(u.getRole() == Role.Administrator);
		assertFalse(u.getRole() == Role.Guest);
	}



	@Test
	public void testGetLogin() {
		assert(u.getLogin() == "login");
	}

	@Test
	public void testSetLogin() {
		u.setLogin("login2");
		assert(u.getLogin() == "login2");
	}

	@Test
	public void testGetName() {
		assert(u.getName() == "name");
	}

	@Test
	public void testSetName() {
		u.setName("name2");
		assert(u.getName() == "name2");
	}

	@Test
	public void testGetPassword() {
		assert (u.getPassword() == "password");
	}

	@Test
	public void testSetPassword() {
		u.setPassword("password2");
		assert (u.getPassword() == "password2");
		
	}
}
