package tribunal.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import tribunal.custom.IDBOperations;
import tribunal.custom.OperationProvider;
import tribunal.dao.IDBOperationsBase;
import tribunal.dao.ITransactionalRunner;
import tribunal.entities.Auto;
import tribunal.entities.Categoria;
import tribunal.entities.InqueritoSocial;
import tribunal.entities.Livro;
import tribunal.entities.Log;
import tribunal.entities.Pagina;
import tribunal.entities.Peticao;
import tribunal.entities.PeticaoApenso;
import tribunal.entities.PeticaoDistribuida;
import tribunal.entities.Processo;
import tribunal.entities.ProcessoAutuado;
import tribunal.entities.Registro;
import tribunal.entities.Seccao;
import tribunal.entities.Usuario;

// This class is generated. Any change will be overridden.
public abstract class TribunalDAOBase implements IDBOperationsBase, ITransactionalRunner {
	
	public final static List<java.lang.Class<?>> ENTITY_CLASSES = Collections.unmodifiableList(Arrays.<java.lang.Class<?>>asList(new java.lang.Class<?>[] {
		Usuario.class,
		Categoria.class,
		Seccao.class,
		Livro.class,
		Pagina.class,
		Processo.class,
		ProcessoAutuado.class,
		Registro.class,
		Peticao.class,
		PeticaoDistribuida.class,
		PeticaoApenso.class,
		Auto.class,
		InqueritoSocial.class,
		Log.class,
	}));
	
	private static EntityManagerFactory entityManagerFactory;
	
	private Class<?> contextClass;
	
	public TribunalDAOBase() {
		this(null);
	}
	
	/**
	 * Creates a new DAO that uses the given context class to load the JPA
	 * configuration file 'persistence.properties' using {@link
	 * Class#getResourceAsStream(String)}.
	 */
	public TribunalDAOBase(Class<?> contextClass) {
		this.contextClass = contextClass;
	}
	
	/**
	 * Returns the context class that was used to load the JPA configuration file.
	 */
	public Class<?> getContextClass() {
		return contextClass;
	}
	
	/**
	 * Returns the name of the service provider that is defined in the persistence.xml
	 * file.
	 */
	public String getServiceName() {
		return "Service";
	}
	
	/**
	 * Retrieves the persistence properties from a file called
	 * 'persistence.properties' which must be found next to the context class in the
	 * class path. Override {@link #getResourcePropertiesInputStream()} to customize
	 * the retrieval of the persistence properties.
	 */
	protected Map<Object, Object> getPersistenceProperties() {
		Map<Object, Object> properties = new LinkedHashMap<Object, Object>();
		if (contextClass != null) {
			InputStream stream = getResourcePropertiesInputStream();
			if (stream != null) {
				try {
					Properties loadedProperties = new Properties();
					loadedProperties.load(stream);
					properties.putAll(loadedProperties);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
	
	/**
	 * Returns an input stream from which the persistence properties are read. The
	 * default implementation reads the persistence properties from a file called
	 * 'persistence.properties' which must be found next to the context class in the
	 * class path.Sub classes may override this method to obtain the persistence
	 * properties from another location (e.g., from memory).
	 */
	protected InputStream getResourcePropertiesInputStream() {
		return contextClass.getResourceAsStream("persistence.properties");
	}
	
	/**
	 * Creates a new EntityManagerFactory based on the persistence properties that are
	 * returned by {@link #getPersistenceProperties()} and the service name returned
	 * by {@link #getServiceName()}. This method is required in unmanaged environments
	 * only and automatically called by {@link #getEntityManagerFactory()}.
	 */
	protected void configure() {
		Map<Object, Object> properties = getPersistenceProperties();
		configure(properties);
	}
	
	protected void configure(Map<Object, Object> properties) {
		performCustomSchemaUpdates(properties);
		entityManagerFactory = Persistence.createEntityManagerFactory(getServiceName(), properties);
	}
	
	protected void performCustomSchemaUpdates(Map<Object, Object> properties) {
		// Schema versioning is disabled.
	}
	
	/**
	 * Returns the existing EntityManagerFactory or creates one if required. This
	 * method is used in unmanaged environments only.
	 */
	protected EntityManagerFactory getEntityManagerFactory() {
		synchronized (TribunalDAOBase.class) {
			if (entityManagerFactory == null) {
				configure();
			}
			return entityManagerFactory;
		}
	}
	
	/**
	 * This method can be overridden if the DAO is used in a managed environment. In
	 * this case the injected EntityManager can be returned. By default this method
	 * returns <code>null</code>.
	 */
	protected EntityManager getEntityManager() {
		return null;
	}
	
	/**
	 * This method is only used if the DAO is used in an unmanaged environment. In
	 * this case the a new EntityManager is created using the EntityManagerFactory.
	 */
	protected EntityManager createEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#flush()} instead.
	 * </p>
	 */
	@Deprecated
	public void flush() {
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Usuario)} instead.
	 * </p>
	 */
	@Deprecated
	public Usuario merge(Usuario entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Categoria)} instead.
	 * </p>
	 */
	@Deprecated
	public Categoria merge(Categoria entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Seccao)} instead.
	 * </p>
	 */
	@Deprecated
	public Seccao merge(Seccao entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Livro)} instead.
	 * </p>
	 */
	@Deprecated
	public Livro merge(Livro entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Pagina)} instead.
	 * </p>
	 */
	@Deprecated
	public Pagina merge(Pagina entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Processo)} instead.
	 * </p>
	 */
	@Deprecated
	public Processo merge(Processo entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(ProcessoAutuado)} instead.
	 * </p>
	 */
	@Deprecated
	public ProcessoAutuado merge(ProcessoAutuado entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Registro)} instead.
	 * </p>
	 */
	@Deprecated
	public Registro merge(Registro entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Peticao)} instead.
	 * </p>
	 */
	@Deprecated
	public Peticao merge(Peticao entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(PeticaoDistribuida)} instead.
	 * </p>
	 */
	@Deprecated
	public PeticaoDistribuida merge(PeticaoDistribuida entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(PeticaoApenso)} instead.
	 * </p>
	 */
	@Deprecated
	public PeticaoApenso merge(PeticaoApenso entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Auto)} instead.
	 * </p>
	 */
	@Deprecated
	public Auto merge(Auto entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(InqueritoSocial)} instead.
	 * </p>
	 */
	@Deprecated
	public InqueritoSocial merge(InqueritoSocial entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Log)} instead.
	 * </p>
	 */
	@Deprecated
	public Log merge(Log entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * Executes the given command within a transaction. If the transaction fails, no
	 * retry is performed.
	 */
	public void executeInTransaction(ICommand command) {
		boolean retry = false;
		executeInTransaction(command, retry);
	}
	
	/**
	 * Executes the given command within a transaction. If retry is <code>true</code>,
	 * a retry is performed if the transaction fails.
	 */
	protected void executeInTransaction(ICommand command, boolean retry) {
		executeInTransaction(Collections.singleton(command));
	}
	
	/**
	 * Executes all commands within one transaction. If the transaction fails, no
	 * retry is performed.
	 */
	public void executeInTransaction(Collection<ICommand> commands) {
		boolean retry = false;
		executeInTransaction(commands, retry);
	}
	
	/**
	 * Executes all commands within one transaction. If retry is <code>true</code>, a
	 * retry is performed if the transaction fails.
	 */
	protected void executeInTransaction(Collection<ICommand> commands, boolean retry) {
		boolean successful = false;
		
		EntityManager entityManager = getEntityManager();
		if (entityManager != null) {
			doExecute(commands, entityManager);
		} else {
			entityManager = createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			try {
				tx.begin();
				doExecute(commands, entityManager);
				tx.commit();
				successful = true;
			} catch (java.lang.Exception e) {
				try {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}
				} catch (java.lang.Exception e2) {
					handleException(e2, retry);
				}
				handleException(e, retry);
			} finally {
				entityManager.close();
			}
			
			if (!successful && retry) {
				// retry once
				executeInTransaction(commands, false);
			}
		}
	}
	
	/**
	 * Executes all commands. This method assumes that a transaction has been
	 * previously obtained from the given EntityManager.
	 */
	protected void doExecute(Collection<ICommand> commands, EntityManager entityManager) {
		OperationProvider operationProvider = new OperationProvider(entityManager);
		for (ICommand command : commands) {
			command.execute(operationProvider);
		}
	}
	
	/**
	 * Executes the given function within a transaction and return the result. If the
	 * transaction fails, no retry is performed.
	 */
	public <ResultType> ResultType executeInTransaction(IFunction<ResultType> function) {
		boolean retry = false;
		return executeInTransaction(function, retry);
	}
	
	/**
	 * Executes the given function within a transaction and return the result. If
	 * retry is <code>true</code>, a retry is performed if the transaction fails.
	 */
	protected <ResultType> ResultType executeInTransaction(IFunction<ResultType> function, boolean retry) {
		boolean successful = false;
		ResultType result = null;
		EntityManager entityManager = getEntityManager();
		if (entityManager != null) {
			result = function.execute(new OperationProvider(entityManager));
		} else {
			entityManager = createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			try {
				tx.begin();
				result = function.execute(new OperationProvider(entityManager));
				tx.commit();
				successful = true;
			} catch (Throwable e) {
				try {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}
				} catch (java.lang.Exception e2) {
					handleException(e2, retry);
				}
				handleException(e, retry);
			} finally {
				entityManager.close();
			}
			
			if (!successful && retry) {
				// retry once
				return executeInTransaction(function, false);
			}
		}
		return result;
	}
	
	/**
	 * This method is called if an exception is thrown within a transaction or while
	 * rolling back a transaction. If retry is <code>true</code>, the transaction will
	 * be executed again. Implement this method to realize custom exception handling
	 * (e.g., logging).
	 */
	public abstract void handleException(Throwable e, boolean retry);
	
	/**
	 * Tears down this DAO by closing the EntityManagerFactory. Calling this method is
	 * required in unmanaged environments only.
	 */
	public void tearDown() {
		synchronized (TribunalDAOBase.class) {
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
				entityManagerFactory = null;
			}
		}
	}
	
	/**
	 * Returns all entities that are stored in the database. Note that this method
	 * loads all entities into memory.
	 */
	public List<java.lang.Object> getAll() {
		final List<java.lang.Object> entities = new ArrayList<java.lang.Object>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllUsuarios(true));
				entities.addAll(operations.getAllCategorias());
				entities.addAll(operations.getAllSeccaos());
				entities.addAll(operations.getAllLivros());
				entities.addAll(operations.getAllPaginas());
				entities.addAll(operations.getAllProcessos(true));
				entities.addAll(operations.getAllProcessoAutuados(true));
				entities.addAll(operations.getAllRegistros());
				entities.addAll(operations.getAllPeticaos(true));
				entities.addAll(operations.getAllPeticaoDistribuidas(true));
				entities.addAll(operations.getAllPeticaoApensos(true));
				entities.addAll(operations.getAllAutos());
				entities.addAll(operations.getAllInqueritoSocials());
				entities.addAll(operations.getAllLogs());
			}
		});
		return entities;
	}
	
	/**
	 * Loads all entities that are stored in the database using one transaction per
	 * entity. This method is useful to check whether the database schema matches the
	 * expectation of the JPA provider. Note that this method loads all entities of
	 * one type (and their eager references) into memory.
	 */
	public void loadAll() {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllUsuarios(true);
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllCategorias();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllSeccaos();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllLivros();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllPaginas();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllProcessos(true);
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllProcessoAutuados(true);
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllRegistros();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllPeticaos(true);
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllPeticaoDistribuidas(true);
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllPeticaoApensos(true);
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllAutos();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllInqueritoSocials();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllLogs();
			}
		});
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final Categoria categoria, final Seccao seccao, final boolean archived) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createUsuario(nome, dataDeNascimento, username, password, categoria, seccao, archived);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final Categoria categoria, final Seccao seccao, final boolean archived, final IAction<Usuario> prePersistAction) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createUsuario(nome, dataDeNascimento, username, password, categoria, seccao, archived, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getUsuario(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username, final boolean includedArchivedEntities) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getUsuarioByUsername(username, includedArchivedEntities);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Usuarios with the given categoria.
	 */
	public List<Usuario> getUsuariosByCategoria(final Categoria categoria, final boolean includeArchivedEntities) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getUsuariosByCategoria(categoria, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Usuarios with the given seccao.
	 */
	public List<Usuario> getUsuariosBySeccao(final Seccao seccao, final boolean includeArchivedEntities) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getUsuariosBySeccao(seccao, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getUsuariosWithDataDeNascimentoBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getUsuariosWithDataDeNascimentoAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all Usuarios where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Usuario> getArchivedUsuarios() {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getArchivedUsuarios());
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Usuarios to the given value.
	 */
	public void setUsuariosArchived(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setUsuariosArchived(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios(final boolean includeArchivedEntities) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllUsuarios(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchUsuarios(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Usuario. This method is deprecated, because Usuario is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Usuario entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Usuarios. This method is deprecated, because Usuario is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteUsuarios(final List<Usuario> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteUsuarios(entities);
			}
		});
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteUsuariosWithDataDeNascimentoBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteUsuariosWithDataDeNascimentoAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios(final boolean includeArchivedEntities) {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countUsuarios(true);
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(final String nome) {
		final Categoria[] entity = new Categoria[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createCategoria(nome);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(final String nome, final IAction<Categoria> prePersistAction) {
		final Categoria[] entity = new Categoria[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createCategoria(nome, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Categoria with the given id.
	 */
	public Categoria getCategoria(final int id) {
		final Categoria[] entity = new Categoria[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getCategoria(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Categoria.
	 */
	public List<Categoria> getAllCategorias() {
		final List<Categoria> entities = new ArrayList<Categoria>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllCategorias());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Categoria.
	 */
	public List<Categoria> searchCategorias(final java.lang.String _searchString, final int _maxResults) {
		final List<Categoria> entities = new ArrayList<Categoria>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchCategorias(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Categoria.
	 */
	public void delete(final Categoria entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Categorias.
	 */
	public void deleteCategorias(final List<Categoria> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteCategorias(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Categoria entities.
	 */
	public int countCategorias() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countCategorias();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(final String nome) {
		final Seccao[] entity = new Seccao[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createSeccao(nome);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(final String nome, final IAction<Seccao> prePersistAction) {
		final Seccao[] entity = new Seccao[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createSeccao(nome, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Seccao with the given id.
	 */
	public Seccao getSeccao(final int id) {
		final Seccao[] entity = new Seccao[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getSeccao(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Seccao.
	 */
	public List<Seccao> getAllSeccaos() {
		final List<Seccao> entities = new ArrayList<Seccao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllSeccaos());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Seccao.
	 */
	public List<Seccao> searchSeccaos(final java.lang.String _searchString, final int _maxResults) {
		final List<Seccao> entities = new ArrayList<Seccao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchSeccaos(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Seccao.
	 */
	public void delete(final Seccao entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Seccaos.
	 */
	public void deleteSeccaos(final List<Seccao> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteSeccaos(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Seccao entities.
	 */
	public int countSeccaos() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countSeccaos();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final long numero) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLivro(nome, numero);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final long numero, final IAction<Livro> prePersistAction) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLivro(nome, numero, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLivro(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLivroByNome(nome);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros() {
		final List<Livro> entities = new ArrayList<Livro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllLivros());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults) {
		final List<Livro> entities = new ArrayList<Livro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchLivros(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLivros(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countLivros();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final int pag, final Livro livro) {
		final Pagina[] entity = new Pagina[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPagina(pag, livro);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final int pag, final Livro livro, final IAction<Pagina> prePersistAction) {
		final Pagina[] entity = new Pagina[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPagina(pag, livro, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id) {
		final Pagina[] entity = new Pagina[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPagina(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Paginas with the given livro.
	 */
	public List<Pagina> getPaginasByLivro(final Livro livro) {
		final List<Pagina> entities = new ArrayList<Pagina>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPaginasByLivro(livro));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas() {
		final List<Pagina> entities = new ArrayList<Pagina>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPaginas());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults) {
		final List<Pagina> entities = new ArrayList<Pagina>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPaginas(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePaginas(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPaginas();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived) {
		final Processo[] entity = new Processo[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProcesso(data, identification, peticao, auto, pagina, archived);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived, final IAction<Processo> prePersistAction) {
		final Processo[] entity = new Processo[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProcesso(data, identification, peticao, auto, pagina, archived, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Processo with the given id.
	 */
	// This method is deprecated because the entity Processo has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Processo getProcesso(final int id) {
		final Processo[] entity = new Processo[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getProcesso(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Processo with the given identification.
	 */
	public Processo getProcessoByIdentification(final String identification, final boolean includedArchivedEntities) {
		final Processo[] entity = new Processo[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getProcessoByIdentification(identification, includedArchivedEntities);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Processos with the given peticao.
	 */
	public List<Processo> getProcessosByPeticao(final Peticao peticao, final boolean includeArchivedEntities) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosByPeticao(peticao, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Processos with the given auto.
	 */
	public List<Processo> getProcessosByAuto(final Auto auto, final boolean includeArchivedEntities) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosByAuto(auto, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Processos with the given pagina.
	 */
	public List<Processo> getProcessosByPagina(final Pagina pagina, final boolean includeArchivedEntities) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosByPagina(pagina, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value before '_maxDate'.
	 */
	public List<Processo> getProcessosWithDataBefore(final Date _maxDate) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value after '_minDate'.
	 */
	public List<Processo> getProcessosWithDataAfter(final Date _minDate) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all Processos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Processo> getArchivedProcessos() {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getArchivedProcessos());
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Processos to the given value.
	 */
	public void setProcessosArchived(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setProcessosArchived(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos(final boolean includeArchivedEntities) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllProcessos(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchProcessos(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Processo. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Processo entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Processos. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessos(final List<Processo> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessos(entities);
			}
		});
	}
	
	/**
	 * Deletes all Processos where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessosWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessosWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Processos where data is set to a value after '_minDate'.
	 */
	public void deleteProcessosWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessosWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos(final boolean includeArchivedEntities) {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countProcessos(true);
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived, final Boolean conclusao) {
		final ProcessoAutuado[] entity = new ProcessoAutuado[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProcessoAutuado(data, identification, peticao, auto, pagina, archived, conclusao);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived, final Boolean conclusao, final IAction<ProcessoAutuado> prePersistAction) {
		final ProcessoAutuado[] entity = new ProcessoAutuado[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProcessoAutuado(data, identification, peticao, auto, pagina, archived, conclusao, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the ProcessoAutuado with the given id.
	 */
	// This method is deprecated because the entity ProcessoAutuado has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public ProcessoAutuado getProcessoAutuado(final int id) {
		final ProcessoAutuado[] entity = new ProcessoAutuado[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getProcessoAutuado(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the ProcessoAutuado with the given identification.
	 */
	public ProcessoAutuado getProcessoAutuadoByIdentification(final String identification, final boolean includedArchivedEntities) {
		final ProcessoAutuado[] entity = new ProcessoAutuado[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getProcessoAutuadoByIdentification(identification, includedArchivedEntities);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the ProcessoAutuados with the given peticao.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPeticao(final Peticao peticao, final boolean includeArchivedEntities) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessoAutuadosByPeticao(peticao, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given auto.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByAuto(final Auto auto, final boolean includeArchivedEntities) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessoAutuadosByAuto(auto, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given pagina.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPagina(final Pagina pagina, final boolean includeArchivedEntities) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessoAutuadosByPagina(pagina, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all ProcessoAutuados where data is set to a value before '_maxDate'.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosWithDataBefore(final Date _maxDate) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessoAutuadosWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all ProcessoAutuados where data is set to a value after '_minDate'.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosWithDataAfter(final Date _minDate) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessoAutuadosWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all ProcessoAutuados where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<ProcessoAutuado> getArchivedProcessoAutuados() {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getArchivedProcessoAutuados());
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all ProcessoAutuados to the given
	 * value.
	 */
	public void setProcessoAutuadosArchived(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setProcessoAutuadosArchived(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all ProcessoAutuados where the boolean property 'conclusao' is set to
	 * <code>true</code>.
	 */
	public List<ProcessoAutuado> getConclusaoProcessoAutuados(final boolean includeArchivedEntities) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getConclusaoProcessoAutuados(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'conclusao' for all ProcessoAutuados to the given
	 * value.
	 */
	public void setProcessoAutuadosConclusao(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setProcessoAutuadosConclusao(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> getAllProcessoAutuados(final boolean includeArchivedEntities) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllProcessoAutuados(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> searchProcessoAutuados(final java.lang.String _searchString, final int _maxResults) {
		final List<ProcessoAutuado> entities = new ArrayList<ProcessoAutuado>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchProcessoAutuados(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given ProcessoAutuado. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final ProcessoAutuado entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given ProcessoAutuados. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessoAutuados(final List<ProcessoAutuado> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessoAutuados(entities);
			}
		});
	}
	
	/**
	 * Deletes all ProcessoAutuados where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessoAutuadosWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessoAutuadosWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all ProcessoAutuados where data is set to a value after '_minDate'.
	 */
	public void deleteProcessoAutuadosWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessoAutuadosWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of ProcessoAutuado entities.
	 */
	public int countProcessoAutuados(final boolean includeArchivedEntities) {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countProcessoAutuados(true);
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(final Date data, final String infoRegisto, final ProcessoAutuado processoAutuado, final Usuario user) {
		final Registro[] entity = new Registro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createRegistro(data, infoRegisto, processoAutuado, user);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(final Date data, final String infoRegisto, final ProcessoAutuado processoAutuado, final Usuario user, final IAction<Registro> prePersistAction) {
		final Registro[] entity = new Registro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createRegistro(data, infoRegisto, processoAutuado, user, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Registro with the given id.
	 */
	public Registro getRegistro(final int id) {
		final Registro[] entity = new Registro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getRegistro(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Registros with the given processoAutuado.
	 */
	public List<Registro> getRegistrosByProcessoAutuado(final ProcessoAutuado processoAutuado) {
		final List<Registro> entities = new ArrayList<Registro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getRegistrosByProcessoAutuado(processoAutuado));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Registros with the given user.
	 */
	public List<Registro> getRegistrosByUser(final Usuario user) {
		final List<Registro> entities = new ArrayList<Registro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getRegistrosByUser(user));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Registros where data is set to a value before '_maxDate'.
	 */
	public List<Registro> getRegistrosWithDataBefore(final Date _maxDate) {
		final List<Registro> entities = new ArrayList<Registro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getRegistrosWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Registros where data is set to a value after '_minDate'.
	 */
	public List<Registro> getRegistrosWithDataAfter(final Date _minDate) {
		final List<Registro> entities = new ArrayList<Registro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getRegistrosWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all entities of type Registro.
	 */
	public List<Registro> getAllRegistros() {
		final List<Registro> entities = new ArrayList<Registro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllRegistros());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Registro.
	 */
	public List<Registro> searchRegistros(final java.lang.String _searchString, final int _maxResults) {
		final List<Registro> entities = new ArrayList<Registro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchRegistros(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Registro.
	 */
	public void delete(final Registro entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Registros.
	 */
	public void deleteRegistros(final List<Registro> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteRegistros(entities);
			}
		});
	}
	
	/**
	 * Deletes all Registros where data is set to a value before '_maxDate'.
	 */
	public void deleteRegistrosWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteRegistrosWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Registros where data is set to a value after '_minDate'.
	 */
	public void deleteRegistrosWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteRegistrosWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Registro entities.
	 */
	public int countRegistros() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countRegistros();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived) {
		final Peticao[] entity = new Peticao[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPeticao(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final IAction<Peticao> prePersistAction) {
		final Peticao[] entity = new Peticao[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPeticao(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Peticao with the given id.
	 */
	public Peticao getPeticao(final int id) {
		final Peticao[] entity = new Peticao[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPeticao(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all Peticaos where data is set to a value before '_maxDate'.
	 */
	public List<Peticao> getPeticaosWithDataBefore(final Date _maxDate) {
		final List<Peticao> entities = new ArrayList<Peticao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaosWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Peticaos where data is set to a value after '_minDate'.
	 */
	public List<Peticao> getPeticaosWithDataAfter(final Date _minDate) {
		final List<Peticao> entities = new ArrayList<Peticao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaosWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all Peticaos where the boolean property 'dist' is set to
	 * <code>true</code>.
	 */
	public List<Peticao> getDistPeticaos(final boolean includeArchivedEntities) {
		final List<Peticao> entities = new ArrayList<Peticao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getDistPeticaos(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'dist' for all Peticaos to the given value.
	 */
	public void setPeticaosDist(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setPeticaosDist(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all Peticaos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Peticao> getArchivedPeticaos() {
		final List<Peticao> entities = new ArrayList<Peticao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getArchivedPeticaos());
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Peticaos to the given value.
	 */
	public void setPeticaosArchived(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setPeticaosArchived(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all entities of type Peticao.
	 */
	public List<Peticao> getAllPeticaos(final boolean includeArchivedEntities) {
		final List<Peticao> entities = new ArrayList<Peticao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPeticaos(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Peticao.
	 */
	public List<Peticao> searchPeticaos(final java.lang.String _searchString, final int _maxResults) {
		final List<Peticao> entities = new ArrayList<Peticao>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPeticaos(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Peticao. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Peticao entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Peticaos. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaos(final List<Peticao> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaos(entities);
			}
		});
	}
	
	/**
	 * Deletes all Peticaos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaosWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaosWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Peticaos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaosWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaosWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Peticao entities.
	 */
	public int countPeticaos(final boolean includeArchivedEntities) {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPeticaos(true);
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Seccao seccao) {
		final PeticaoDistribuida[] entity = new PeticaoDistribuida[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPeticaoDistribuida(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, seccao);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Seccao seccao, final IAction<PeticaoDistribuida> prePersistAction) {
		final PeticaoDistribuida[] entity = new PeticaoDistribuida[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPeticaoDistribuida(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, seccao, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the PeticaoDistribuida with the given id.
	 */
	public PeticaoDistribuida getPeticaoDistribuida(final int id) {
		final PeticaoDistribuida[] entity = new PeticaoDistribuida[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPeticaoDistribuida(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the PeticaoDistribuidas with the given seccao.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasBySeccao(final Seccao seccao, final boolean includeArchivedEntities) {
		final List<PeticaoDistribuida> entities = new ArrayList<PeticaoDistribuida>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaoDistribuidasBySeccao(seccao, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all PeticaoDistribuidas where data is set to a value before '_maxDate'.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasWithDataBefore(final Date _maxDate) {
		final List<PeticaoDistribuida> entities = new ArrayList<PeticaoDistribuida>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaoDistribuidasWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all PeticaoDistribuidas where data is set to a value after '_minDate'.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasWithDataAfter(final Date _minDate) {
		final List<PeticaoDistribuida> entities = new ArrayList<PeticaoDistribuida>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaoDistribuidasWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all PeticaoDistribuidas where the boolean property 'dist' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoDistribuida> getDistPeticaoDistribuidas(final boolean includeArchivedEntities) {
		final List<PeticaoDistribuida> entities = new ArrayList<PeticaoDistribuida>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getDistPeticaoDistribuidas(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'dist' for all PeticaoDistribuidas to the given value.
	 */
	public void setPeticaoDistribuidasDist(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setPeticaoDistribuidasDist(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all PeticaoDistribuidas where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoDistribuida> getArchivedPeticaoDistribuidas() {
		final List<PeticaoDistribuida> entities = new ArrayList<PeticaoDistribuida>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getArchivedPeticaoDistribuidas());
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoDistribuidas to the given
	 * value.
	 */
	public void setPeticaoDistribuidasArchived(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setPeticaoDistribuidasArchived(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> getAllPeticaoDistribuidas(final boolean includeArchivedEntities) {
		final List<PeticaoDistribuida> entities = new ArrayList<PeticaoDistribuida>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPeticaoDistribuidas(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> searchPeticaoDistribuidas(final java.lang.String _searchString, final int _maxResults) {
		final List<PeticaoDistribuida> entities = new ArrayList<PeticaoDistribuida>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPeticaoDistribuidas(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given PeticaoDistribuida. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoDistribuida entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given PeticaoDistribuidas. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoDistribuidas(final List<PeticaoDistribuida> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaoDistribuidas(entities);
			}
		});
	}
	
	/**
	 * Deletes all PeticaoDistribuidas where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaoDistribuidasWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaoDistribuidasWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all PeticaoDistribuidas where data is set to a value after '_minDate'.
	 */
	public void deletePeticaoDistribuidasWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaoDistribuidasWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of PeticaoDistribuida entities.
	 */
	public int countPeticaoDistribuidas(final boolean includeArchivedEntities) {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPeticaoDistribuidas(true);
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Processo processo) {
		final PeticaoApenso[] entity = new PeticaoApenso[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPeticaoApenso(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, processo);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Processo processo, final IAction<PeticaoApenso> prePersistAction) {
		final PeticaoApenso[] entity = new PeticaoApenso[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPeticaoApenso(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, processo, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the PeticaoApenso with the given id.
	 */
	public PeticaoApenso getPeticaoApenso(final int id) {
		final PeticaoApenso[] entity = new PeticaoApenso[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPeticaoApenso(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the PeticaoApensos with the given processo.
	 */
	public List<PeticaoApenso> getPeticaoApensosByProcesso(final Processo processo, final boolean includeArchivedEntities) {
		final List<PeticaoApenso> entities = new ArrayList<PeticaoApenso>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaoApensosByProcesso(processo, includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataBefore(final Date _maxDate) {
		final List<PeticaoApenso> entities = new ArrayList<PeticaoApenso>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaoApensosWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataAfter(final Date _minDate) {
		final List<PeticaoApenso> entities = new ArrayList<PeticaoApenso>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getPeticaoApensosWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all PeticaoApensos where the boolean property 'dist' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoApenso> getDistPeticaoApensos(final boolean includeArchivedEntities) {
		final List<PeticaoApenso> entities = new ArrayList<PeticaoApenso>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getDistPeticaoApensos(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'dist' for all PeticaoApensos to the given value.
	 */
	public void setPeticaoApensosDist(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setPeticaoApensosDist(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all PeticaoApensos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoApenso> getArchivedPeticaoApensos() {
		final List<PeticaoApenso> entities = new ArrayList<PeticaoApenso>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getArchivedPeticaoApensos());
			}
		});
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoApensos to the given value.
	 */
	public void setPeticaoApensosArchived(final boolean value, final boolean includeArchivedEntities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.setPeticaoApensosArchived(value, includeArchivedEntities);
			}
		});
	}
	
	/**
	 * Returns all entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> getAllPeticaoApensos(final boolean includeArchivedEntities) {
		final List<PeticaoApenso> entities = new ArrayList<PeticaoApenso>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPeticaoApensos(includeArchivedEntities));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> searchPeticaoApensos(final java.lang.String _searchString, final int _maxResults) {
		final List<PeticaoApenso> entities = new ArrayList<PeticaoApenso>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPeticaoApensos(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given PeticaoApenso. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoApenso entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given PeticaoApensos. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoApensos(final List<PeticaoApenso> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaoApensos(entities);
			}
		});
	}
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaoApensosWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaoApensosWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaoApensosWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePeticaoApensosWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of PeticaoApenso entities.
	 */
	public int countPeticaoApensos(final boolean includeArchivedEntities) {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPeticaoApensos(true);
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(final String auto) {
		final Auto[] entity = new Auto[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createAuto(auto);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(final String auto, final IAction<Auto> prePersistAction) {
		final Auto[] entity = new Auto[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createAuto(auto, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Auto with the given id.
	 */
	public Auto getAuto(final int id) {
		final Auto[] entity = new Auto[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getAuto(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Auto.
	 */
	public List<Auto> getAllAutos() {
		final List<Auto> entities = new ArrayList<Auto>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllAutos());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Auto.
	 */
	public List<Auto> searchAutos(final java.lang.String _searchString, final int _maxResults) {
		final List<Auto> entities = new ArrayList<Auto>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchAutos(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Auto.
	 */
	public void delete(final Auto entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Autos.
	 */
	public void deleteAutos(final List<Auto> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteAutos(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Auto entities.
	 */
	public int countAutos() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countAutos();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial) {
		final InqueritoSocial[] entity = new InqueritoSocial[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createInqueritoSocial(processo, assistenteSocial);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial, final IAction<InqueritoSocial> prePersistAction) {
		final InqueritoSocial[] entity = new InqueritoSocial[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createInqueritoSocial(processo, assistenteSocial, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id) {
		final InqueritoSocial[] entity = new InqueritoSocial[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getInqueritoSocial(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo) {
		final List<InqueritoSocial> entities = new ArrayList<InqueritoSocial>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getInqueritoSocialsByProcesso(processo));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials() {
		final List<InqueritoSocial> entities = new ArrayList<InqueritoSocial>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllInqueritoSocials());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults) {
		final List<InqueritoSocial> entities = new ArrayList<InqueritoSocial>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchInqueritoSocials(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteInqueritoSocials(entities);
			}
		});
	}
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countInqueritoSocials();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final Usuario user) {
		final Log[] entity = new Log[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLog(data, log, user);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final Usuario user, final IAction<Log> prePersistAction) {
		final Log[] entity = new Log[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLog(data, log, user, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id) {
		final Log[] entity = new Log[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLog(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Logs with the given user.
	 */
	public List<Log> getLogsByUser(final Usuario user) {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getLogsByUser(user));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate) {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getLogsWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate) {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getLogsWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs() {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllLogs());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults) {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchLogs(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLogs(entities);
			}
		});
	}
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLogsWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLogsWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countLogs();
			}
		});
		return count[0];
	}
	
}

