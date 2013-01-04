
package test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import services.SectionService;
import domain.Section;
import domain.User;

public class SectionServiceTest {
	SectionService ss;
	Section s;
	@Before
	public void setUp() {
		ss = new SectionService();
		s = new Section("title", new User());
		s.setId(0l);
	}

	@Ignore
	public void testCalculatePositions() {
		
	}

	@Test
	public void testSave() {
		ss.save(s);
		assert(ss.exists(0l));
	}

}

