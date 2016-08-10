package tribunal.test;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.ProcessoAutuado;

/**
 * <p>
 * This test is generated for the entity 'ProcessoAutuado' defined in the HEDL
 * model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class ProcessoAutuadoTest {
	
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
		ProcessoAutuado newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countProcessoAutuados(true));
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countProcessoAutuados(true));
		ProcessoAutuado newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countProcessoAutuados(true));
	}
	
	@Test
	public void testUniquePropertyIdentification() {
		final ProcessoAutuado[] entities = new ProcessoAutuado[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createProcessoAutuado("stringValue" + (dummyValueCounter++), operations.createPeticaoDistribuida(operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), false), operations.createSeccao("stringValue" + (dummyValueCounter++)), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false);
			}
		});
		final ProcessoAutuado entity = entities[0];
		assertNotNull("Entity must be created.", entity);
		
		assertNull("There must not be exceptions up to this point.", lastException);
		// test creation of a second object having the same (unique) value
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				ProcessoAutuado secondEntity = operations.createProcessoAutuado("stringValue" + (dummyValueCounter++), operations.createPeticaoDistribuida(operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), false), operations.createSeccao("stringValue" + (dummyValueCounter++)), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false);
				secondEntity.setIdentification(entities[0].getIdentification());
			}
		});
		assertNotNull("Must not be able to create second object with same value for unique property.", lastException);
		lastException = null;
		
		// Use final arrays to store result of execute()
		final String[] identification1 = new String[1];
		final String[] identification2 = new String[1];
		
		// Create two new values for unique property
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				identification1[0] = "stringValue" + (dummyValueCounter++);
				identification2[0] = "stringValue" + (dummyValueCounter++);
			}
		});
		
		// Check that objects were actually created
		assertNull(lastException);
		assertNotNull(identification1[0]);
		assertNotNull(identification2[0]);
		
		// Change value of unique property and test retrieval
		setIdentification(entity.getId(), identification2[0]);
		
		assertNull("Entity must not exist.", dao.getProcessoAutuadoByIdentification(identification1[0], false));
		assertNotNull("Entity must exist.", dao.getProcessoAutuadoByIdentification(identification2[0], false));
	}
	
	private void setIdentification(final int id, final String newValue) {
		dao.executeInTransaction(new ICommand() {
			
			@java.lang.SuppressWarnings("deprecation")
			public void execute(IDBOperations operations) {
				
				ProcessoAutuado entity = operations.getProcessoAutuado(id);
				assertNotNull(entity);
				entity.setIdentification(newValue);
				
			}
		});
	}
	
	@Test
	@java.lang.SuppressWarnings("deprecation")
	public void testBooleanPropertyArchived() {
		// create test objects
		assertEquals(0, dao.countProcessoAutuados(true));
		
		ProcessoAutuado newEntity1 = createInstance(dao);
		assertNotNull(newEntity1);
		
		ProcessoAutuado newEntity2 = createInstance(dao);
		assertNotNull(newEntity2);
		assertEquals(2, dao.countProcessoAutuados(true));
		
		final int id1 = newEntity1.getId();
		final int id2 = newEntity2.getId();
		
		// change boolean property
		setArchived(dao, id1, true);
		
		// fetch again from database
		newEntity1 = dao.getProcessoAutuado(id1);
		assertTrue(newEntity1.isArchived());
		
		// change boolean property
		setArchived(dao, id1, false);
		
		// fetch again from database
		newEntity1 = dao.getProcessoAutuado(id1);
		assertFalse(newEntity1.isArchived());
		
		// change boolean property of all entries
		dao.setProcessoAutuadosArchived(true, true);
		newEntity1 = dao.getProcessoAutuado(id1);
		assertTrue(newEntity1.isArchived());
		newEntity2 = dao.getProcessoAutuado(id2);
		assertTrue(newEntity2.isArchived());
	}
	
	private void setArchived(TribunalDAO dao, final int id, final boolean newValue) {
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
				@java.lang.SuppressWarnings("deprecation")
				ProcessoAutuado entity = operations.getProcessoAutuado(id);
				assertNotNull(entity);
				entity.setArchived(newValue);
			}
		});
	}
	
	private ProcessoAutuado createInstance(TribunalDAO dao) {
		final ProcessoAutuado[] result = new ProcessoAutuado[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createProcessoAutuado("stringValue" + (dummyValueCounter++), operations.createPeticaoDistribuida(operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), false), operations.createSeccao("stringValue" + (dummyValueCounter++)), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false);
			}
		});
		return result[0];
	}
}