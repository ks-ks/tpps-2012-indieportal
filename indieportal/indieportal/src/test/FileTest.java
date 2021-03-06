package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.File;
import domain.File.FileType;

public class FileTest {
	File f;
	@Before
	public void setUp() {
		f = new File("lol", File.FileType.Image);
	}

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

		assert(f.getName().equalsIgnoreCase("lol"));

	}

	@Test
	public void testSetName() {

		assert(f.getName().equalsIgnoreCase("lol"));
		f.setName("not lol");
		assert(f.getName().equalsIgnoreCase("not lol"));

	}

}
