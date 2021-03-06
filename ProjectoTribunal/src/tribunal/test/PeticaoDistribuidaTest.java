package tribunal.test;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.PeticaoDistribuida;

/**
 * <p>
 * This test is generated for the entity 'PeticaoDistribuida' defined in the HEDL
 * model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class PeticaoDistribuidaTest {
	
	protected int dummyValueCounter;
	protected Throwable lastException;
	
	private TribunalDAO dao;
	
	@Before
	public void setUp() {
		dao = new TribunalDAO(this.getClass()) {
			
			@Override
			public void handleException(Throwable e, boolean retry) {
				super.handleException(e, retry);
				lastException = e;
			}
		};
		dummyValueCounter = 0;
	}
	
	@After
	public void tearDown() {
		dao.tearDown();
		dao = null;
		lastException = null;
	}
	
	@Test
	public void testCreate() {
		PeticaoDistribuida newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countPeticaoDistribuidas(true));
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countPeticaoDistribuidas(true));
		PeticaoDistribuida newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countPeticaoDistribuidas(true));
	}
	
	@Test
	public void testStringPropertyNumeroId() {
		final PeticaoDistribuida[] entities = new PeticaoDistribuida[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[0].setNumeroId("a");
				entities[1] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[1].setNumeroId("ab");
				entities[2] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[2].setNumeroId("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<PeticaoDistribuida> result = dao.searchPeticaoDistribuidas("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchPeticaoDistribuidas("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchPeticaoDistribuidas("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testStringPropertyRequerente() {
		final PeticaoDistribuida[] entities = new PeticaoDistribuida[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[0].setRequerente("a");
				entities[1] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[1].setRequerente("ab");
				entities[2] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[2].setRequerente("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<PeticaoDistribuida> result = dao.searchPeticaoDistribuidas("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchPeticaoDistribuidas("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchPeticaoDistribuidas("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testStringPropertyRequerido() {
		final PeticaoDistribuida[] entities = new PeticaoDistribuida[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[0].setRequerido("a");
				entities[1] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[1].setRequerido("ab");
				entities[2] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[2].setRequerido("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<PeticaoDistribuida> result = dao.searchPeticaoDistribuidas("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchPeticaoDistribuidas("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchPeticaoDistribuidas("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testStringPropertyResumo() {
		final PeticaoDistribuida[] entities = new PeticaoDistribuida[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[0].setResumo("a");
				entities[1] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[1].setResumo("ab");
				entities[2] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[2].setResumo("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<PeticaoDistribuida> result = dao.searchPeticaoDistribuidas("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchPeticaoDistribuidas("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchPeticaoDistribuidas("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testStringPropertyRemetente() {
		final PeticaoDistribuida[] entities = new PeticaoDistribuida[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[0].setRemetente("a");
				entities[1] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[1].setRemetente("ab");
				entities[2] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[2].setRemetente("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<PeticaoDistribuida> result = dao.searchPeticaoDistribuidas("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchPeticaoDistribuidas("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchPeticaoDistribuidas("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testStringPropertyApenso() {
		final PeticaoDistribuida[] entities = new PeticaoDistribuida[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[0].setApenso("a");
				entities[1] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[1].setApenso("ab");
				entities[2] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
				entities[2].setApenso("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<PeticaoDistribuida> result = dao.searchPeticaoDistribuidas("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchPeticaoDistribuidas("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchPeticaoDistribuidas("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchPeticaoDistribuidas("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testDatePropertyData() {
		// create test object
		assertEquals(0, dao.countPeticaoDistribuidas(true));
		PeticaoDistribuida newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countPeticaoDistribuidas(true));
		
		final int id = newEntity.getId();
		long oneHour = 60 * 1000;
		final Date newDate = new Date(oneHour);
		
		// change date property
		setData(dao, id, newDate);
		
		// fetch again from database
		newEntity = dao.getPeticaoDistribuida(id);
		assertEquals(newDate, newEntity.getData());
		
		List<PeticaoDistribuida> before = dao.getPeticaoDistribuidasWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		List<PeticaoDistribuida> after = dao.getPeticaoDistribuidasWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
		
		// change date property again (add one hour)
		setData(dao, id, new Date(2 * oneHour));
		
		before = dao.getPeticaoDistribuidasWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		after = dao.getPeticaoDistribuidasWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(1, after.size());
		
		// change date property again (subtract one hour)
		setData(dao, id, new java.util.Date(0 * oneHour));
		
		before = dao.getPeticaoDistribuidasWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(1, before.size());
		
		after = dao.getPeticaoDistribuidasWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
	}
	
	private void setData(TribunalDAO dao, final int id, final Date newValue) {
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				
				PeticaoDistribuida entity = operations.getPeticaoDistribuida(id);
				assertNotNull(entity);
				entity.setData(newValue);
			}
		});
	}
	
	@Test
	public void testBooleanPropertyDist() {
		// create test objects
		assertEquals(0, dao.countPeticaoDistribuidas(true));
		
		PeticaoDistribuida newEntity1 = createInstance(dao);
		assertNotNull(newEntity1);
		
		PeticaoDistribuida newEntity2 = createInstance(dao);
		assertNotNull(newEntity2);
		assertEquals(2, dao.countPeticaoDistribuidas(true));
		
		final int id1 = newEntity1.getId();
		final int id2 = newEntity2.getId();
		
		// change boolean property
		setDist(dao, id1, true);
		
		// fetch again from database
		newEntity1 = dao.getPeticaoDistribuida(id1);
		assertTrue(newEntity1.isDist());
		
		// change boolean property
		setDist(dao, id1, false);
		
		// fetch again from database
		newEntity1 = dao.getPeticaoDistribuida(id1);
		assertFalse(newEntity1.isDist());
		
		// change boolean property of all entries
		dao.setPeticaoDistribuidasDist(true, true);
		newEntity1 = dao.getPeticaoDistribuida(id1);
		assertTrue(newEntity1.isDist());
		newEntity2 = dao.getPeticaoDistribuida(id2);
		assertTrue(newEntity2.isDist());
	}
	
	private void setDist(TribunalDAO dao, final int id, final boolean newValue) {
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
				PeticaoDistribuida entity = operations.getPeticaoDistribuida(id);
				assertNotNull(entity);
				entity.setDist(newValue);
			}
		});
	}
	
	@Test
	public void testBooleanPropertyArchived() {
		// create test objects
		assertEquals(0, dao.countPeticaoDistribuidas(true));
		
		PeticaoDistribuida newEntity1 = createInstance(dao);
		assertNotNull(newEntity1);
		
		PeticaoDistribuida newEntity2 = createInstance(dao);
		assertNotNull(newEntity2);
		assertEquals(2, dao.countPeticaoDistribuidas(true));
		
		final int id1 = newEntity1.getId();
		final int id2 = newEntity2.getId();
		
		// change boolean property
		setArchived(dao, id1, true);
		
		// fetch again from database
		newEntity1 = dao.getPeticaoDistribuida(id1);
		assertTrue(newEntity1.isArchived());
		
		// change boolean property
		setArchived(dao, id1, false);
		
		// fetch again from database
		newEntity1 = dao.getPeticaoDistribuida(id1);
		assertFalse(newEntity1.isArchived());
		
		// change boolean property of all entries
		dao.setPeticaoDistribuidasArchived(true, true);
		newEntity1 = dao.getPeticaoDistribuida(id1);
		assertTrue(newEntity1.isArchived());
		newEntity2 = dao.getPeticaoDistribuida(id2);
		assertTrue(newEntity2.isArchived());
	}
	
	private void setArchived(TribunalDAO dao, final int id, final boolean newValue) {
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
				PeticaoDistribuida entity = operations.getPeticaoDistribuida(id);
				assertNotNull(entity);
				entity.setArchived(newValue);
			}
		});
	}
	
	private PeticaoDistribuida createInstance(TribunalDAO dao) {
		final PeticaoDistribuida[] result = new PeticaoDistribuida[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createPeticaoDistribuida("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false, null);
			}
		});
		return result[0];
	}
}
