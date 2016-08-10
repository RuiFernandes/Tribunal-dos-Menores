package tribunal.test;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.Auto;

/**
 * <p>
 * This test is generated for the entity 'Auto' defined in the HEDL model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class AutoTest {
	
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
		Auto newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countAutos());
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countAutos());
		Auto newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countAutos());
	}
	
	@Test
	public void testStringPropertyAuto() {
		final Auto[] entities = new Auto[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createAuto("stringValue" + (dummyValueCounter++));
				entities[0].setAuto("a");
				entities[1] = operations.createAuto("stringValue" + (dummyValueCounter++));
				entities[1].setAuto("ab");
				entities[2] = operations.createAuto("stringValue" + (dummyValueCounter++));
				entities[2].setAuto("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<Auto> result = dao.searchAutos("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchAutos("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchAutos("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchAutos("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchAutos("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	private Auto createInstance(TribunalDAO dao) {
		final Auto[] result = new Auto[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createAuto("stringValue" + (dummyValueCounter++));
			}
		});
		return result[0];
	}
}
