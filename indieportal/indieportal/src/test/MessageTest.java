package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.File;
import domain.Message;
import domain.User;

public class MessageTest {
	Message msg;
	User u;
	File f;
	@Before
	public void setUp() throws Exception {
		u = new User();
		msg = new Message("text",u);
		f = new File("name");
	}

	@Test
	public void testAddFile() {

		msg.addFile(f);
		assert(msg.getFiles().contains(f));
	}

	@Test
	public void testDeleteFile() {
		msg.deleteFile(f);
		assertFalse(msg.getFiles().contains(f));
			
	}

	@Test
	public void testGetNumberOfFiles() {

		assert(msg.getNumberOfFiles() == 0);
		msg.addFile(f);
		assert(msg.getNumberOfFiles() == 1);
		File f2 = new File ("2");
		msg.addFile(f2);
		assert(msg.getNumberOfFiles() == 2);
		
		msg.deleteFile(f2);
		msg.deleteFile(f);
		assert(msg.getNumberOfFiles() == 0);
		
	}

	@Test
	public void testIncreaseRating() {
		msg.increaseRating();
<<<<<<< HEAD
		assert(msg.getRating() == 1);
		msg.increaseRating();
		assert(msg.getRating() == 2);
=======
		assert(msg.rating == 1);
		msg.increaseRating();
		assert(msg.rating == 2);
>>>>>>> dddd
		
	}

	@Test
	public void testDecreaseRating() {
		msg.decreaseRating();
<<<<<<< HEAD
		assert(msg.getRating() == 1);
=======
		assert(msg.rating == 1);
>>>>>>> dddd
	}

}
