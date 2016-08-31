package tribunal.test;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.Registro;

/**
 * <p>
 * This test is generated for the entity 'Registro' defined in the HEDL model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class RegistroTest {
	
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
		Registro newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countRegistros());
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countRegistros());
		Registro newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countRegistros());
	}
	
	@Test
	public void testStringPropertyInfoRegisto() {
		final Registro[] entities = new Registro[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createRegistro(new Date(), "stringValue" + (dummyValueCounter++), operations.createProcessoAutuado(new Date(), "stringValue" + (dummyValueCounter++), operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false, true), operations.createUsuario("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), operations.createCategoria("stringValue" + (dummyValueCounter++)), operations.createSeccao("stringValue" + (dummyValueCounter++)), false));
				entities[0].setInfoRegisto("a");
				entities[1] = operations.createRegistro(new Date(), "stringValue" + (dummyValueCounter++), operations.createProcessoAutuado(new Date(), "stringValue" + (dummyValueCounter++), operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false, true), operations.createUsuario("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), operations.createCategoria("stringValue" + (dummyValueCounter++)), operations.createSeccao("stringValue" + (dummyValueCounter++)), false));
				entities[1].setInfoRegisto("ab");
				entities[2] = operations.createRegistro(new Date(), "stringValue" + (dummyValueCounter++), operations.createProcessoAutuado(new Date(), "stringValue" + (dummyValueCounter++), operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false, true), operations.createUsuario("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), operations.createCategoria("stringValue" + (dummyValueCounter++)), operations.createSeccao("stringValue" + (dummyValueCounter++)), false));
				entities[2].setInfoRegisto("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<Registro> result = dao.searchRegistros("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchRegistros("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchRegistros("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchRegistros("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchRegistros("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testDatePropertyData() {
		// create test object
		assertEquals(0, dao.countRegistros());
		Registro newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countRegistros());
		
		final int id = newEntity.getId();
		long oneHour = 60 * 1000;
		final Date newDate = new Date(oneHour);
		
		// change date property
		setData(dao, id, newDate);
		
		// fetch again from database
		newEntity = dao.getRegistro(id);
		assertEquals(newDate, newEntity.getData());
		
		List<Registro> before = dao.getRegistrosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		List<Registro> after = dao.getRegistrosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
		
		// change date property again (add one hour)
		setData(dao, id, new Date(2 * oneHour));
		
		before = dao.getRegistrosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		after = dao.getRegistrosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(1, after.size());
		
		// change date property again (subtract one hour)
		setData(dao, id, new java.util.Date(0 * oneHour));
		
		before = dao.getRegistrosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(1, before.size());
		
		after = dao.getRegistrosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
	}
	
	private void setData(TribunalDAO dao, final int id, final Date newValue) {
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				
				Registro entity = operations.getRegistro(id);
				assertNotNull(entity);
				entity.setData(newValue);
			}
		});
	}
	
	private Registro createInstance(TribunalDAO dao) {
		final Registro[] result = new Registro[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createRegistro(new Date(), "stringValue" + (dummyValueCounter++), operations.createProcessoAutuado(new Date(), "stringValue" + (dummyValueCounter++), operations.createPeticao("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), true, "stringValue" + (dummyValueCounter++), false), operations.createAuto("stringValue" + (dummyValueCounter++)), operations.createPagina((dummyValueCounter++), operations.createLivro("stringValue" + (dummyValueCounter++), (dummyValueCounter++))), false, true), operations.createUsuario("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), operations.createCategoria("stringValue" + (dummyValueCounter++)), operations.createSeccao("stringValue" + (dummyValueCounter++)), false));
			}
		});
		return result[0];
	}
}
