package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Message;
import domain.Theme;
import domain.User;

public class ThemeTest {
	Theme t;
	User u; 
	Message msg;
	
	@Before
	public void setUp() throws Exception {
		u = new User();
		t = new Theme("title", u);
		msg = new Message("text", u);
	}

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
		assert(t.text.equals("title2"));
	}
	@Test
	public void testIncreaseRatingOfTheme() {
		t.increaseRating();
		assert(t.rating == 1);
		t.increaseRating();
		assert(t.rating == 2);
		}

	@Test
	public void testDecreaseRatingOfTheme() {
		msg.decreaseRating();
		assert(msg.rating == 1);
	}

	@Test
	public void testCalculateSummary() {
		msg.increaseRating();
		long res = t.calculateSummary();
		assert(res == 1001l);
		
	}

		
}
