package tribunal.test;

import java.util.Date;
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
				result[0] = operations.createPeticaoDistribuida(operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), false), operations.createSeccao("stringValue" + (dummyValueCounter++)), false);
			}
		});
		return result[0];
	}
}
