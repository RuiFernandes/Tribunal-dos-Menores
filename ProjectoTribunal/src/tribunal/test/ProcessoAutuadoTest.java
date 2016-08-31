package tribunal.test;

import java.util.Date;
import java.util.List;
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
				entities[0] = operations.createProcessoAutuado(new Date(), "stringValue" + (dummyValueCounter++), operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false, true);
			}
		});
		final ProcessoAutuado entity = entities[0];
		assertNotNull("Entity must be created.", entity);
		
		assertNull("There must not be exceptions up to this point.", lastException);
		// test creation of a second object having the same (unique) value
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				ProcessoAutuado secondEntity = operations.createProcessoAutuado(new Date(), "stringValue" + (dummyValueCounter++), operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false, true);
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
	public void testDatePropertyData() {
		// create test object
		assertEquals(0, dao.countProcessoAutuados(true));
		ProcessoAutuado newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countProcessoAutuados(true));
		
		final int id = newEntity.getId();
		long oneHour = 60 * 1000;
		final Date newDate = new Date(oneHour);
		
		// change date property
		setData(dao, id, newDate);
		
		// fetch again from database
		newEntity = dao.getProcessoAutuado(id);
		assertEquals(newDate, newEntity.getData());
		
		List<ProcessoAutuado> before = dao.getProcessoAutuadosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		List<ProcessoAutuado> after = dao.getProcessoAutuadosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
		
		// change date property again (add one hour)
		setData(dao, id, new Date(2 * oneHour));
		
		before = dao.getProcessoAutuadosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		after = dao.getProcessoAutuadosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(1, after.size());
		
		// change date property again (subtract one hour)
		setData(dao, id, new java.util.Date(0 * oneHour));
		
		before = dao.getProcessoAutuadosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(1, before.size());
		
		after = dao.getProcessoAutuadosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
	}
	
	private void setData(TribunalDAO dao, final int id, final Date newValue) {
		dao.executeInTransaction(new ICommand() {
			@java.lang.SuppressWarnings("deprecation")
			public void execute(IDBOperations operations) {
				
				ProcessoAutuado entity = operations.getProcessoAutuado(id);
				assertNotNull(entity);
				entity.setData(newValue);
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
	
	@Test
	@java.lang.SuppressWarnings("deprecation")
	public void testBooleanPropertyConclusao() {
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
		setConclusao(dao, id1, true);
		
		// fetch again from database
		newEntity1 = dao.getProcessoAutuado(id1);
		assertTrue(newEntity1.isConclusao());
		
		// change boolean property
		setConclusao(dao, id1, false);
		
		// fetch again from database
		newEntity1 = dao.getProcessoAutuado(id1);
		assertFalse(newEntity1.isConclusao());
		
		// change boolean property of all entries
		dao.setProcessoAutuadosConclusao(true, true);
		newEntity1 = dao.getProcessoAutuado(id1);
		assertTrue(newEntity1.isConclusao());
		newEntity2 = dao.getProcessoAutuado(id2);
		assertTrue(newEntity2.isConclusao());
	}
	
	private void setConclusao(TribunalDAO dao, final int id, final boolean newValue) {
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				
				@java.lang.SuppressWarnings("deprecation")
				ProcessoAutuado entity = operations.getProcessoAutuado(id);
				assertNotNull(entity);
				entity.setConclusao(newValue);
			}
		});
	}
	
	private ProcessoAutuado createInstance(TribunalDAO dao) {
		final ProcessoAutuado[] result = new ProcessoAutuado[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createProcessoAutuado(new Date(), "stringValue" + (dummyValueCounter++), operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false, true);
			}
		});
		return result[0];
	}
}
