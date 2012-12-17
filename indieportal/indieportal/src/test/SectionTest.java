package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Section;
import domain.Theme;
import domain.User;

public class SectionTest {
	Section s;
	User u;
	Theme t;
	@Before
	public void setUp() throws Exception {
		u = new User();
		s = new Section("title", u);
		t = new Theme("title", u);
	}


	@Test
	public void testAddTheme() {
		s.addTheme(t);
		assert(s.getThemes().contains(t));
	}

	@Test
	public void testDeleteTheme() {
		s.deleteTheme(t);
		assertFalse(s.getThemes().contains(t));
	}

	@Test
	public void testGetNumberofThemes() {
		assert(s.getNumberofThemes() == 0);
		s.addTheme(t);
		assert(s.getNumberofThemes() == 1);
		s.deleteTheme(t);
		assert(s.getNumberofThemes() == 0);

	}

	@Test
	public void testSetTitle() {
		s.setTitle("title2");
<<<<<<< HEAD
		assert(s.getText().equals("title2"));
=======
		assert(s.text.equals("title2"));
>>>>>>> dddd
	}

}
