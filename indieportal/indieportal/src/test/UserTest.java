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
<<<<<<< HEAD
		assert(u.getLogin() == "login");
=======
		assert(u.login == "login");
>>>>>>> dddd
	}

	@Test
	public void testSetLogin() {
		u.setLogin("login2");
<<<<<<< HEAD
		assert(u.getLogin() == "login2");
=======
		assert(u.login == "login2");
>>>>>>> dddd
	}

	@Test
	public void testGetName() {
<<<<<<< HEAD
		assert(u.getName() == "name");
=======
		assert(u.name == "name");
>>>>>>> dddd
	}

	@Test
	public void testSetName() {
		u.setName("name2");
<<<<<<< HEAD
		assert(u.getName() == "name2");
=======
		assert(u.name == "name2");
>>>>>>> dddd
	}

	@Test
	public void testGetPassword() {
<<<<<<< HEAD
		assert (u.getPassword() == "password");
=======
		assert (u.password == "password");
>>>>>>> dddd
	}

	@Test
	public void testSetPassword() {
		u.setPassword("password2");
<<<<<<< HEAD
		assert (u.getPassword() == "password2");
=======
		assert (u.password == "password2");
>>>>>>> dddd
		
	}
}
