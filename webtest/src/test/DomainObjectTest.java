package test;

import org.junit.Before;
import org.junit.Test;

import domain.DomainObject;

public class DomainObjectTest {
	DomainObject d;
	@Before
	public void setUp() {
		d = new DomainObject();
		d.setId(0l);
	}

	@Test
	public void testGetId() {
		assert(d.getId() == 0l);
	}

	@Test
	public void testSetId() {
		assert(d.getId() == 0l);
		d.setId(1l);
		assert(d.getId() == 1l);
	}

}
