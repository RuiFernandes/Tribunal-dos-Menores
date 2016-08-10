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
import tribunal.entities.Seccao;

/**
 * <p>
 * This test is generated for the entity 'Seccao' defined in the HEDL model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class SeccaoTest {
	
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
		Seccao newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countSeccaos());
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countSeccaos());
		Seccao newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countSeccaos());
	}
	
	@Test
	public void testStringPropertyNome() {
		final Seccao[] entities = new Seccao[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createSeccao("stringValue" + (dummyValueCounter++));
				entities[0].setNome("a");
				entities[1] = operations.createSeccao("stringValue" + (dummyValueCounter++));
				entities[1].setNome("ab");
				entities[2] = operations.createSeccao("stringValue" + (dummyValueCounter++));
				entities[2].setNome("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<Seccao> result = dao.searchSeccaos("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchSeccaos("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchSeccaos("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchSeccaos("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchSeccaos("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	private Seccao createInstance(TribunalDAO dao) {
		final Seccao[] result = new Seccao[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createSeccao("stringValue" + (dummyValueCounter++));
			}
		});
		return result[0];
	}
}
