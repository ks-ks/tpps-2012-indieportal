package test;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import services.GenericService;
import services.IGenericService;
import domain.DomainObject;
import domain.User;

public class IGenericServiceTest {
	DomainObject u;
	IGenericService<DomainObject> gs;
	
	@Before
	public void setUp() throws Exception {
		gs = new GenericService<DomainObject>();
		u = new User();
		u.setId(0l);
		
	}

	@Test
	public void testSave() {
		gs.save(u);
		assert(gs.exists(0l));
	}

	@Test
	public void testDelEntityLong() {
		gs.delEntity(0l);
		assertFalse(gs.exists(0l));
	}

	@Test
	public void testDelEntityT() {
		gs.save(u);
		assert(gs.exists(0l));

		gs.delEntity(u);
		assertFalse(gs.exists(0l));
	}

	@Test
	public void testGetById() {
		gs.save(u);
		assert(gs.getById(0l) == u);

	}

	@Test
	public void testExists() {
		assert(gs.exists(0l));
	}

	@Test
	public void testGetAllEntitiesCount() {
		assert(gs.getAllEntitiesCount() == 1);
	}

	@Test
	public void testGetAllEntites() {
		assert(gs.getAllEntites().contains(u));
		assert(gs.getAllEntites().size() == 1);
		
	}

}
