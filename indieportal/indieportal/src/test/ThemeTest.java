package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Message;
<<<<<<< HEAD
import domain.Section;
=======
>>>>>>> dddd
import domain.Theme;
import domain.User;

public class ThemeTest {
	Theme t;
	User u; 
	Message msg;
<<<<<<< HEAD
	Section s;
=======
>>>>>>> dddd
	
	@Before
	public void setUp() throws Exception {
		u = new User();
		t = new Theme("title", u);
		msg = new Message("text", u);
<<<<<<< HEAD
		s = new Section("title",u);
	}
	
	
=======
	}
>>>>>>> dddd

	@Test
	public void testAddComment() {
		t.addComment(msg);
		assert(t.getComments().contains(msg));
	}

	@Test
	public void testDeleteComment() {
		t.deleteComment(msg);
		assertFalse(t.getComments().contains(msg));
		}

	@Test
	public void testSetTitle() {
		t.setTitle("title2");
<<<<<<< HEAD
		assert(t.getText().equals("title2"));
=======
		assert(t.text.equals("title2"));
>>>>>>> dddd
	}
	@Test
	public void testIncreaseRatingOfTheme() {
		t.increaseRating();
<<<<<<< HEAD
		assert(t.getRating() == 1);
		t.increaseRating();
		assert(t.getRating() == 2);
=======
		assert(t.rating == 1);
		t.increaseRating();
		assert(t.rating == 2);
>>>>>>> dddd
		}

	@Test
	public void testDecreaseRatingOfTheme() {
		msg.decreaseRating();
<<<<<<< HEAD
		assert(msg.getRating() == 1);
=======
		assert(msg.rating == 1);
>>>>>>> dddd
	}

	@Test
	public void testCalculateSummary() {
		msg.increaseRating();
		long res = t.calculateSummary();
		assert(res == 1001l);
		
	}

		
}
