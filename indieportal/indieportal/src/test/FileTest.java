package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.File;
import domain.File.FileType;

public class FileTest {
	File f;
	@Before
	public void setUp() throws Exception {
		f = new File("lol", File.FileType.Image);
	}
<<<<<<< HEAD
	
=======

>>>>>>> dddd
	@Test
	public void testGetType() {
		assert(f.getType() == FileType.Image);
		assertFalse(f.getType() == FileType.Executable);
	}

	@Test
	public void testSetType() {
		assert(f.getType() == FileType.Image);
		f.setType(FileType.Executable);
		assert(f.getType() == FileType.Executable);
		assertFalse(f.getType() == FileType.Image);
	}

	@Test
	public void testGetName() {
<<<<<<< HEAD
		assert(f.getName().equalsIgnoreCase("lol"));

=======
		assert(f.name.equalsIgnoreCase("lol"));
>>>>>>> dddd
	}

	@Test
	public void testSetName() {
<<<<<<< HEAD
		assert(f.getName().equalsIgnoreCase("lol"));
		f.setName("not lol");
		assert(f.getName().equalsIgnoreCase("not lol"));
=======
		assert(f.name.equalsIgnoreCase("lol"));
		f.setName("not lol");
		assert(f.name.equalsIgnoreCase("not lol"));
>>>>>>> dddd
	}

}
