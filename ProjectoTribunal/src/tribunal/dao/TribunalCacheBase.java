package tribunal.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import tribunal.custom.IDBOperations;
import tribunal.dao.ICommand;
import tribunal.dao.IDBOperationsBase;
import tribunal.dao.IFunction;
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
public abstract class TribunalCacheBase implements IDBOperationsBase, ITransactionalRunner {
	
	protected IDBOperations delegate;
	
	private int nextUsuarioID = 1;
	private int nextCategoriaID = 1;
	private int nextSeccaoID = 1;
	private int nextLivroID = 1;
	private int nextPaginaID = 1;
	private int nextProcessoID = 1;
	private int nextRegistroID = 1;
	private int nextPeticaoID = 1;
	private int nextPeticaoDistribuidaID = 1;
	private int nextAutoID = 1;
	private int nextInqueritoSocialID = 1;
	private int nextLogID = 1;
	
	private Set<Usuario> cachedUsuario = null;
	
	private Set<Categoria> cachedCategoria = null;
	
	private Set<Seccao> cachedSeccao = null;
	
	private Set<Livro> cachedLivro = null;
	
	private Set<Pagina> cachedPagina = null;
	
	private Set<Processo> cachedProcesso = null;
	
	private Set<Registro> cachedRegistro = null;
	
	private Set<Peticao> cachedPeticao = null;
	
	private Set<PeticaoDistribuida> cachedPeticaoDistribuida = null;
	
	private Set<Auto> cachedAuto = null;
	
	private Set<InqueritoSocial> cachedInqueritoSocial = null;
	
	private Set<Log> cachedLog = null;
	
	/**
	 * <p>
	 * Creates a new TribunalCacheBase.
	 * </p>
	 * 
	 * <p>
	 * If the delegate is not null, it is used to obtain entities by means of the
	 * getAll() methods. Once the objects are obtained, they are stored in memory and
	 * returned directly upon future calls.
	 * </p>
	 * 
	 * <p>
	 * The delegate can also be null. In this case, the cache can serve as in-memory
	 * replacement for the database, which is quite useful to write fast test cases.
	 * </p>
	 */
	public TribunalCacheBase(IDBOperations delegate) {
		super();
		this.delegate = delegate;
	}
	
	public void flush() {
		if (delegate == null) {
			return;
		}
		delegate.flush();
	}
	
	/**
	 * Returns all entities that are stored in the cache.
	 */
	public List<java.lang.Object> getAll() {
		final List<java.lang.Object> entities = new ArrayList<java.lang.Object>();
		entities.addAll(getAllUsuarios());
		entities.addAll(getAllCategorias());
		entities.addAll(getAllSeccaos());
		entities.addAll(getAllLivros());
		entities.addAll(getAllPaginas());
		entities.addAll(getAllProcessos(true));
		entities.addAll(getAllProcessoAutuados(true));
		entities.addAll(getAllRegistros());
		entities.addAll(getAllPeticaos(true));
		entities.addAll(getAllPeticaoDistribuidas(true));
		entities.addAll(getAllPeticaoApensos(true));
		entities.addAll(getAllAutos());
		entities.addAll(getAllInqueritoSocials());
		entities.addAll(getAllLogs());
		return entities;
	}
	
	/**
	 * Removes all entities that are stored from the cache.
	 */
	public void removeAll() {
		if (cachedUsuario != null) {
			cachedUsuario.clear();
		}
		if (cachedCategoria != null) {
			cachedCategoria.clear();
		}
		if (cachedSeccao != null) {
			cachedSeccao.clear();
		}
		if (cachedLivro != null) {
			cachedLivro.clear();
		}
		if (cachedPagina != null) {
			cachedPagina.clear();
		}
		if (cachedProcesso != null) {
			cachedProcesso.clear();
		}
		if (cachedRegistro != null) {
			cachedRegistro.clear();
		}
		if (cachedPeticao != null) {
			cachedPeticao.clear();
		}
		if (cachedPeticaoDistribuida != null) {
			cachedPeticaoDistribuida.clear();
		}
		if (cachedAuto != null) {
			cachedAuto.clear();
		}
		if (cachedInqueritoSocial != null) {
			cachedInqueritoSocial.clear();
		}
		if (cachedLog != null) {
			cachedLog.clear();
		}
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final Categoria categoria, final Seccao seccao) {
		return createUsuario(nome, dataDeNascimento, username, password, categoria, seccao, null);
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final Categoria categoria, final Seccao seccao, final IAction<Usuario> prePersistAction) {
		
		Usuario newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(categoria, true);
			checkPersisted(seccao, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextUsuarioID;
			nextUsuarioID++;
			@java.lang.SuppressWarnings("deprecation")
			Usuario newUsuario = new Usuario(nome, dataDeNascimento, username, password, categoria, seccao) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setUsername(String newValue) {
					checkUniqueUsuarioUsername(this, newValue);
					super.setUsername(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setCategoria(Categoria newValue) {
					checkPersisted(newValue, false);
					super.setCategoria(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setSeccao(Seccao newValue) {
					checkPersisted(newValue, false);
					super.setSeccao(newValue);
				}
				
			};
			newEntity = newUsuario;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueUsuario(newEntity);
		} else {
			newEntity = delegate.createUsuario(nome, dataDeNascimento, username, password, categoria, seccao);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getUsuarioCache().add(newEntity);
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id) {
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username) {
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario concreteNext : cache) {
			Object usernameValue = concreteNext.getUsername();
			if (isSameValue(username, usernameValue)) {
				return concreteNext;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Usuarios with the given categoria.
	 */
	public List<Usuario> getUsuariosByCategoria(final Categoria categoria) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario concreteNext : cache) {
			if (categoria != null && categoria.equals(concreteNext.getCategoria())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns the Usuarios with the given seccao.
	 */
	public List<Usuario> getUsuariosBySeccao(final Seccao seccao) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario concreteNext : cache) {
			if (seccao != null && seccao.equals(concreteNext.getSeccao())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario next : cache) {
			if (!(next instanceof Usuario)) {
				continue;
			}
			Usuario concreteNext = (Usuario) next;
			Date value = concreteNext.getDataDeNascimento();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario next : cache) {
			if (!(next instanceof Usuario)) {
				continue;
			}
			Usuario concreteNext = (Usuario) next;
			Date value = concreteNext.getDataDeNascimento();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios() {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String username = concreteNext.getUsername();
				if (username != null && username.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String password = concreteNext.getPassword();
				if (password != null && password.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Usuario.
	 */
	public void delete(final Usuario entity) {
		// Check whether entity is contained in cache
		if (!_getUsuarioCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getUsuarioCache().remove(entity);
	}
	
	/**
	 * Deletes all given Usuarios.
	 */
	public void deleteUsuarios(final List<Usuario> entities) {
		for (Usuario entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		_getUsuarioCache().removeAll(getUsuariosWithDataDeNascimentoBefore(_maxDate));
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		_getUsuarioCache().removeAll(getUsuariosWithDataDeNascimentoAfter(_minDate));
	}
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios() {
		return _getUsuarioCache().size();
	}
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(final String nome) {
		return createCategoria(nome, null);
	}
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(final String nome, final IAction<Categoria> prePersistAction) {
		
		Categoria newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextCategoriaID;
			nextCategoriaID++;
			@java.lang.SuppressWarnings("deprecation")
			Categoria newCategoria = new Categoria(nome) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newCategoria;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueCategoria(newEntity);
		} else {
			newEntity = delegate.createCategoria(nome);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getCategoriaCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Categoria with the given id.
	 */
	public Categoria getCategoria(final int id) {
		Set<Categoria> cache = _getCategoriaCache();
		for (Categoria next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Categoria.
	 */
	public List<Categoria> getAllCategorias() {
		List<Categoria> result = new ArrayList<Categoria>();
		Set<Categoria> cache = _getCategoriaCache();
		for (Categoria castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Categoria.
	 */
	public List<Categoria> searchCategorias(final java.lang.String _searchString, final int _maxResults) {
		List<Categoria> result = new ArrayList<Categoria>();
		Set<Categoria> cache = _getCategoriaCache();
		for (Categoria concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Categoria.
	 */
	public void delete(final Categoria entity) {
		// Check whether entity is contained in cache
		if (!_getCategoriaCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getCategoriaCache().remove(entity);
	}
	
	/**
	 * Deletes all given Categorias.
	 */
	public void deleteCategorias(final List<Categoria> entities) {
		for (Categoria entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Categoria entities.
	 */
	public int countCategorias() {
		return _getCategoriaCache().size();
	}
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(final String nome) {
		return createSeccao(nome, null);
	}
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(final String nome, final IAction<Seccao> prePersistAction) {
		
		Seccao newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextSeccaoID;
			nextSeccaoID++;
			@java.lang.SuppressWarnings("deprecation")
			Seccao newSeccao = new Seccao(nome) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newSeccao;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueSeccao(newEntity);
		} else {
			newEntity = delegate.createSeccao(nome);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getSeccaoCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Seccao with the given id.
	 */
	public Seccao getSeccao(final int id) {
		Set<Seccao> cache = _getSeccaoCache();
		for (Seccao next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Seccao.
	 */
	public List<Seccao> getAllSeccaos() {
		List<Seccao> result = new ArrayList<Seccao>();
		Set<Seccao> cache = _getSeccaoCache();
		for (Seccao castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Seccao.
	 */
	public List<Seccao> searchSeccaos(final java.lang.String _searchString, final int _maxResults) {
		List<Seccao> result = new ArrayList<Seccao>();
		Set<Seccao> cache = _getSeccaoCache();
		for (Seccao concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Seccao.
	 */
	public void delete(final Seccao entity) {
		// Check whether entity is contained in cache
		if (!_getSeccaoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getSeccaoCache().remove(entity);
	}
	
	/**
	 * Deletes all given Seccaos.
	 */
	public void deleteSeccaos(final List<Seccao> entities) {
		for (Seccao entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Seccao entities.
	 */
	public int countSeccaos() {
		return _getSeccaoCache().size();
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final long numero) {
		return createLivro(nome, numero, null);
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final long numero, final IAction<Livro> prePersistAction) {
		
		Livro newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextLivroID;
			nextLivroID++;
			@java.lang.SuppressWarnings("deprecation")
			Livro newLivro = new Livro(nome, numero) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setNome(String newValue) {
					checkUniqueLivroNome(this, newValue);
					super.setNome(newValue);
				}
				
				@java.lang.Override
				public List<Pagina> getPagina() {
					List<Pagina> pagina = super.getPagina();
					Set<Pagina> paginaCache = _getPaginaCache();
					return new TribunalCacheList<Pagina>(pagina, paginaCache);
				}
				
			};
			newEntity = newLivro;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueLivro(newEntity);
		} else {
			newEntity = delegate.createLivro(nome, numero);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getLivroCache().add(newEntity);
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id) {
		Set<Livro> cache = _getLivroCache();
		for (Livro next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome) {
		Set<Livro> cache = _getLivroCache();
		for (Livro concreteNext : cache) {
			Object nomeValue = concreteNext.getNome();
			if (isSameValue(nome, nomeValue)) {
				return concreteNext;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros() {
		List<Livro> result = new ArrayList<Livro>();
		Set<Livro> cache = _getLivroCache();
		for (Livro castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults) {
		List<Livro> result = new ArrayList<Livro>();
		Set<Livro> cache = _getLivroCache();
		for (Livro concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity) {
		// Check whether entity is contained in cache
		if (!_getLivroCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getLivroCache().remove(entity);
	}
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities) {
		for (Livro entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros() {
		return _getLivroCache().size();
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final int pag, final Livro livro) {
		return createPagina(pag, livro, null);
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final int pag, final Livro livro, final IAction<Pagina> prePersistAction) {
		
		Pagina newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(livro, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextPaginaID;
			nextPaginaID++;
			@java.lang.SuppressWarnings("deprecation")
			Pagina newPagina = new Pagina(pag, livro) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setLivro(Livro newValue) {
					checkPersisted(newValue, false);
					super.setLivro(newValue);
				}
				
			};
			newEntity = newPagina;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniquePagina(newEntity);
		} else {
			newEntity = delegate.createPagina(pag, livro);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getPaginaCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id) {
		Set<Pagina> cache = _getPaginaCache();
		for (Pagina next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Paginas with the given livro.
	 */
	public List<Pagina> getPaginasByLivro(final Livro livro) {
		List<Pagina> result = new ArrayList<Pagina>();
		Set<Pagina> cache = _getPaginaCache();
		for (Pagina concreteNext : cache) {
			if (livro != null && livro.equals(concreteNext.getLivro())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas() {
		List<Pagina> result = new ArrayList<Pagina>();
		Set<Pagina> cache = _getPaginaCache();
		for (Pagina castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults) {
		List<Pagina> result = new ArrayList<Pagina>();
		Set<Pagina> cache = _getPaginaCache();
		for (Pagina concreteNext : cache) {
			boolean matches = false;
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity) {
		// Check whether entity is contained in cache
		if (!_getPaginaCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getPaginaCache().remove(entity);
	}
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities) {
		for (Pagina entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas() {
		return _getPaginaCache().size();
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String identification, final PeticaoDistribuida peticao, final Auto auto, final Pagina pagina, final boolean archived) {
		return createProcesso(identification, peticao, auto, pagina, archived, null);
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String identification, final PeticaoDistribuida peticao, final Auto auto, final Pagina pagina, final boolean archived, final IAction<Processo> prePersistAction) {
		
		Processo newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(peticao, true);
			checkPersisted(auto, true);
			checkPersisted(pagina, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextProcessoID;
			nextProcessoID++;
			@java.lang.SuppressWarnings("deprecation")
			Processo newProcesso = new Processo(identification, peticao, auto, pagina, archived) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setIdentification(String newValue) {
					checkUniqueProcessoIdentification(this, newValue);
					super.setIdentification(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setPeticao(PeticaoDistribuida newValue) {
					checkPersisted(newValue, false);
					super.setPeticao(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setAuto(Auto newValue) {
					checkPersisted(newValue, false);
					super.setAuto(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setPagina(Pagina newValue) {
					checkPersisted(newValue, false);
					super.setPagina(newValue);
				}
				
			};
			newEntity = newProcesso;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueProcesso(newEntity);
		} else {
			newEntity = delegate.createProcesso(identification, peticao, auto, pagina, archived);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getProcessoCache().add(newEntity);
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Processo with the given id.
	 */
	// This method is deprecated because the entity Processo has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Processo getProcesso(final int id) {
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Processo with the given identification.
	 */
	public Processo getProcessoByIdentification(final String identification, final boolean includedArchivedEntities) {
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			if (concreteNext.isArchived() && !includedArchivedEntities) {
				continue;
			}
			
			Object identificationValue = concreteNext.getIdentification();
			if (isSameValue(identification, identificationValue)) {
				return concreteNext;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Processos with the given peticao.
	 */
	public List<Processo> getProcessosByPeticao(final PeticaoDistribuida peticao, final boolean includeArchivedEntities) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (peticao != null && peticao.equals(concreteNext.getPeticao(true))) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns the Processos with the given auto.
	 */
	public List<Processo> getProcessosByAuto(final Auto auto, final boolean includeArchivedEntities) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (auto != null && auto.equals(concreteNext.getAuto())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns the Processos with the given pagina.
	 */
	public List<Processo> getProcessosByPagina(final Pagina pagina, final boolean includeArchivedEntities) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (pagina != null && pagina.equals(concreteNext.getPagina())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos(final boolean includeArchivedEntities) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo castedNext : cache) {
			if (castedNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String identification = concreteNext.getIdentification();
				if (identification != null && identification.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Processo. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Processo entity) {
		// Check whether entity is contained in cache
		if (!_getProcessoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getProcessoCache().remove(entity);
	}
	
	/**
	 * Deletes all given Processos. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessos(final List<Processo> entities) {
		for (Processo entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Returns all Processos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Processo> getArchivedProcessos() {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			if (concreteNext.isArchived()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Processos to the given value.
	 */
	public void setProcessosArchived(final boolean value, final boolean includeArchivedEntities) {
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			concreteNext.setArchived(value);
		}
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos(final boolean includeArchivedEntities) {
		int count = 0;
		Set<Processo> entities = _getProcessoCache();
		for (Processo castedNext : entities) {
			if (!castedNext.isArchived() || includeArchivedEntities) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(final String identification, final PeticaoDistribuida peticao, final Auto auto, final Pagina pagina, final boolean archived) {
		return createProcessoAutuado(identification, peticao, auto, pagina, archived, null);
	}
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(final String identification, final PeticaoDistribuida peticao, final Auto auto, final Pagina pagina, final boolean archived, final IAction<ProcessoAutuado> prePersistAction) {
		
		ProcessoAutuado newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(peticao, true);
			checkPersisted(auto, true);
			checkPersisted(pagina, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextProcessoID;
			nextProcessoID++;
			@java.lang.SuppressWarnings("deprecation")
			ProcessoAutuado newProcessoAutuado = new ProcessoAutuado(identification, peticao, auto, pagina, archived) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setIdentification(String newValue) {
					checkUniqueProcessoAutuadoIdentification(this, newValue);
					super.setIdentification(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setPeticao(PeticaoDistribuida newValue) {
					checkPersisted(newValue, false);
					super.setPeticao(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setAuto(Auto newValue) {
					checkPersisted(newValue, false);
					super.setAuto(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setPagina(Pagina newValue) {
					checkPersisted(newValue, false);
					super.setPagina(newValue);
				}
				
				@java.lang.Override
				public List<Registro> getRegistro() {
					List<Registro> registro = super.getRegistro();
					Set<Registro> registroCache = _getRegistroCache();
					return new TribunalCacheList<Registro>(registro, registroCache);
				}
				
			};
			newEntity = newProcessoAutuado;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueProcessoAutuado(newEntity);
		} else {
			newEntity = delegate.createProcessoAutuado(identification, peticao, auto, pagina, archived);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getProcessoCache().add(newEntity);
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the ProcessoAutuado with the given id.
	 */
	// This method is deprecated because the entity ProcessoAutuado has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public ProcessoAutuado getProcessoAutuado(final int id) {
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			if (next.getId() == id) {
				return (ProcessoAutuado) next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the ProcessoAutuado with the given identification.
	 */
	public ProcessoAutuado getProcessoAutuadoByIdentification(final String identification, final boolean includedArchivedEntities) {
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado concreteNext = (ProcessoAutuado) next;
			if (concreteNext.isArchived() && !includedArchivedEntities) {
				continue;
			}
			
			Object identificationValue = concreteNext.getIdentification();
			if (isSameValue(identification, identificationValue)) {
				return concreteNext;
			}
		}
		return null;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given peticao.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPeticao(final PeticaoDistribuida peticao, final boolean includeArchivedEntities) {
		List<ProcessoAutuado> result = new ArrayList<ProcessoAutuado>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado concreteNext = (ProcessoAutuado) next;
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (peticao != null && peticao.equals(concreteNext.getPeticao(true))) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given auto.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByAuto(final Auto auto, final boolean includeArchivedEntities) {
		List<ProcessoAutuado> result = new ArrayList<ProcessoAutuado>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado concreteNext = (ProcessoAutuado) next;
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (auto != null && auto.equals(concreteNext.getAuto())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given pagina.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPagina(final Pagina pagina, final boolean includeArchivedEntities) {
		List<ProcessoAutuado> result = new ArrayList<ProcessoAutuado>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado concreteNext = (ProcessoAutuado) next;
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (pagina != null && pagina.equals(concreteNext.getPagina())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> getAllProcessoAutuados(final boolean includeArchivedEntities) {
		List<ProcessoAutuado> result = new ArrayList<ProcessoAutuado>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado castedNext = (ProcessoAutuado) next;
			if (castedNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> searchProcessoAutuados(final java.lang.String _searchString, final int _maxResults) {
		List<ProcessoAutuado> result = new ArrayList<ProcessoAutuado>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado concreteNext = (ProcessoAutuado) next;
			boolean matches = false;
			
			if (!matches) {
				java.lang.String identification = concreteNext.getIdentification();
				if (identification != null && identification.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given ProcessoAutuado. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final ProcessoAutuado entity) {
		// Check whether entity is contained in cache
		if (!_getProcessoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getProcessoCache().remove(entity);
	}
	
	/**
	 * Deletes all given ProcessoAutuados. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessoAutuados(final List<ProcessoAutuado> entities) {
		for (ProcessoAutuado entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Returns all ProcessoAutuados where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<ProcessoAutuado> getArchivedProcessoAutuados() {
		List<ProcessoAutuado> result = new ArrayList<ProcessoAutuado>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado concreteNext = (ProcessoAutuado) next;
			if (concreteNext.isArchived()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Sets the boolean property 'archived' for all ProcessoAutuados to the given
	 * value.
	 */
	public void setProcessoAutuadosArchived(final boolean value, final boolean includeArchivedEntities) {
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado concreteNext = (ProcessoAutuado) next;
			concreteNext.setArchived(value);
		}
	}
	
	/**
	 * Counts the number of ProcessoAutuado entities.
	 */
	public int countProcessoAutuados(final boolean includeArchivedEntities) {
		int count = 0;
		Set<Processo> entities = _getProcessoCache();
		for (Processo next : entities) {
			if (!(next instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado castedNext = (ProcessoAutuado) next;
			if (!castedNext.isArchived() || includeArchivedEntities) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(final Date data, final String infoRegisto, final ProcessoAutuado processoAutuado) {
		return createRegistro(data, infoRegisto, processoAutuado, null);
	}
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(final Date data, final String infoRegisto, final ProcessoAutuado processoAutuado, final IAction<Registro> prePersistAction) {
		
		Registro newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(processoAutuado, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextRegistroID;
			nextRegistroID++;
			@java.lang.SuppressWarnings("deprecation")
			Registro newRegistro = new Registro(data, infoRegisto, processoAutuado) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setProcessoAutuado(ProcessoAutuado newValue) {
					checkPersisted(newValue, false);
					super.setProcessoAutuado(newValue);
				}
				
			};
			newEntity = newRegistro;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueRegistro(newEntity);
		} else {
			newEntity = delegate.createRegistro(data, infoRegisto, processoAutuado);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getRegistroCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Registro with the given id.
	 */
	public Registro getRegistro(final int id) {
		Set<Registro> cache = _getRegistroCache();
		for (Registro next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Registros with the given processoAutuado.
	 */
	public List<Registro> getRegistrosByProcessoAutuado(final ProcessoAutuado processoAutuado) {
		List<Registro> result = new ArrayList<Registro>();
		Set<Registro> cache = _getRegistroCache();
		for (Registro concreteNext : cache) {
			if (processoAutuado != null && processoAutuado.equals(concreteNext.getProcessoAutuado(true))) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Registros where data is set to a value before '_maxDate'.
	 */
	public List<Registro> getRegistrosWithDataBefore(final Date _maxDate) {
		List<Registro> result = new ArrayList<Registro>();
		Set<Registro> cache = _getRegistroCache();
		for (Registro next : cache) {
			if (!(next instanceof Registro)) {
				continue;
			}
			Registro concreteNext = (Registro) next;
			Date value = concreteNext.getData();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Registros where data is set to a value after '_minDate'.
	 */
	public List<Registro> getRegistrosWithDataAfter(final Date _minDate) {
		List<Registro> result = new ArrayList<Registro>();
		Set<Registro> cache = _getRegistroCache();
		for (Registro next : cache) {
			if (!(next instanceof Registro)) {
				continue;
			}
			Registro concreteNext = (Registro) next;
			Date value = concreteNext.getData();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Registro.
	 */
	public List<Registro> getAllRegistros() {
		List<Registro> result = new ArrayList<Registro>();
		Set<Registro> cache = _getRegistroCache();
		for (Registro castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Registro.
	 */
	public List<Registro> searchRegistros(final java.lang.String _searchString, final int _maxResults) {
		List<Registro> result = new ArrayList<Registro>();
		Set<Registro> cache = _getRegistroCache();
		for (Registro concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String infoRegisto = concreteNext.getInfoRegisto();
				if (infoRegisto != null && infoRegisto.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Registro.
	 */
	public void delete(final Registro entity) {
		// Check whether entity is contained in cache
		if (!_getRegistroCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getRegistroCache().remove(entity);
	}
	
	/**
	 * Deletes all given Registros.
	 */
	public void deleteRegistros(final List<Registro> entities) {
		for (Registro entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all Registros where data is set to a value before '_maxDate'.
	 */
	public void deleteRegistrosWithDataBefore(final Date _maxDate) {
		_getRegistroCache().removeAll(getRegistrosWithDataBefore(_maxDate));
	}
	
	/**
	 * Deletes all Registros where data is set to a value after '_minDate'.
	 */
	public void deleteRegistrosWithDataAfter(final Date _minDate) {
		_getRegistroCache().removeAll(getRegistrosWithDataAfter(_minDate));
	}
	
	/**
	 * Counts the number of Registro entities.
	 */
	public int countRegistros() {
		return _getRegistroCache().size();
	}
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean archived) {
		return createPeticao(numeroId, data, requerente, requerido, resumo, remetente, archived, null);
	}
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean archived, final IAction<Peticao> prePersistAction) {
		
		Peticao newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextPeticaoID;
			nextPeticaoID++;
			@java.lang.SuppressWarnings("deprecation")
			Peticao newPeticao = new Peticao(numeroId, data, requerente, requerido, resumo, remetente, archived) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newPeticao;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniquePeticao(newEntity);
		} else {
			newEntity = delegate.createPeticao(numeroId, data, requerente, requerido, resumo, remetente, archived);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getPeticaoCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Peticao with the given id.
	 */
	public Peticao getPeticao(final int id) {
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all Peticaos where data is set to a value before '_maxDate'.
	 */
	public List<Peticao> getPeticaosWithDataBefore(final Date _maxDate) {
		List<Peticao> result = new ArrayList<Peticao>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof Peticao)) {
				continue;
			}
			Peticao concreteNext = (Peticao) next;
			Date value = concreteNext.getData();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Peticaos where data is set to a value after '_minDate'.
	 */
	public List<Peticao> getPeticaosWithDataAfter(final Date _minDate) {
		List<Peticao> result = new ArrayList<Peticao>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof Peticao)) {
				continue;
			}
			Peticao concreteNext = (Peticao) next;
			Date value = concreteNext.getData();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Peticao.
	 */
	public List<Peticao> getAllPeticaos(final boolean includeArchivedEntities) {
		List<Peticao> result = new ArrayList<Peticao>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao castedNext : cache) {
			if (castedNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Peticao.
	 */
	public List<Peticao> searchPeticaos(final java.lang.String _searchString, final int _maxResults) {
		List<Peticao> result = new ArrayList<Peticao>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String numeroId = concreteNext.getNumeroId();
				if (numeroId != null && numeroId.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String requerente = concreteNext.getRequerente();
				if (requerente != null && requerente.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String requerido = concreteNext.getRequerido();
				if (requerido != null && requerido.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String resumo = concreteNext.getResumo();
				if (resumo != null && resumo.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String remetente = concreteNext.getRemetente();
				if (remetente != null && remetente.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Peticao. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Peticao entity) {
		// Check whether entity is contained in cache
		if (!_getPeticaoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getPeticaoCache().remove(entity);
	}
	
	/**
	 * Deletes all given Peticaos. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaos(final List<Peticao> entities) {
		for (Peticao entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all Peticaos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaosWithDataBefore(final Date _maxDate) {
		_getPeticaoCache().removeAll(getPeticaosWithDataBefore(_maxDate));
	}
	
	/**
	 * Deletes all Peticaos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaosWithDataAfter(final Date _minDate) {
		_getPeticaoCache().removeAll(getPeticaosWithDataAfter(_minDate));
	}
	
	/**
	 * Returns all Peticaos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Peticao> getArchivedPeticaos() {
		List<Peticao> result = new ArrayList<Peticao>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao concreteNext : cache) {
			if (concreteNext.isArchived()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Peticaos to the given value.
	 */
	public void setPeticaosArchived(final boolean value, final boolean includeArchivedEntities) {
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao concreteNext : cache) {
			concreteNext.setArchived(value);
		}
	}
	
	/**
	 * Counts the number of Peticao entities.
	 */
	public int countPeticaos(final boolean includeArchivedEntities) {
		int count = 0;
		Set<Peticao> entities = _getPeticaoCache();
		for (Peticao castedNext : entities) {
			if (!castedNext.isArchived() || includeArchivedEntities) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(final Peticao peticao, final Seccao seccao, final boolean archived) {
		return createPeticaoDistribuida(peticao, seccao, archived, null);
	}
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(final Peticao peticao, final Seccao seccao, final boolean archived, final IAction<PeticaoDistribuida> prePersistAction) {
		
		PeticaoDistribuida newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(peticao, true);
			checkPersisted(seccao, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextPeticaoDistribuidaID;
			nextPeticaoDistribuidaID++;
			@java.lang.SuppressWarnings("deprecation")
			PeticaoDistribuida newPeticaoDistribuida = new PeticaoDistribuida(peticao, seccao, archived) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setPeticao(Peticao newValue) {
					checkPersisted(newValue, false);
					super.setPeticao(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setSeccao(Seccao newValue) {
					checkPersisted(newValue, false);
					super.setSeccao(newValue);
				}
				
			};
			newEntity = newPeticaoDistribuida;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniquePeticaoDistribuida(newEntity);
		} else {
			newEntity = delegate.createPeticaoDistribuida(peticao, seccao, archived);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getPeticaoDistribuidaCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the PeticaoDistribuida with the given id.
	 */
	public PeticaoDistribuida getPeticaoDistribuida(final int id) {
		Set<PeticaoDistribuida> cache = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the PeticaoDistribuidas with the given peticao.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasByPeticao(final Peticao peticao, final boolean includeArchivedEntities) {
		List<PeticaoDistribuida> result = new ArrayList<PeticaoDistribuida>();
		Set<PeticaoDistribuida> cache = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida concreteNext : cache) {
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (peticao != null && peticao.equals(concreteNext.getPeticao(true))) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns the PeticaoDistribuidas with the given seccao.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasBySeccao(final Seccao seccao, final boolean includeArchivedEntities) {
		List<PeticaoDistribuida> result = new ArrayList<PeticaoDistribuida>();
		Set<PeticaoDistribuida> cache = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida concreteNext : cache) {
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (seccao != null && seccao.equals(concreteNext.getSeccao())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> getAllPeticaoDistribuidas(final boolean includeArchivedEntities) {
		List<PeticaoDistribuida> result = new ArrayList<PeticaoDistribuida>();
		Set<PeticaoDistribuida> cache = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida castedNext : cache) {
			if (castedNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> searchPeticaoDistribuidas(final java.lang.String _searchString, final int _maxResults) {
		List<PeticaoDistribuida> result = new ArrayList<PeticaoDistribuida>();
		Set<PeticaoDistribuida> cache = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida concreteNext : cache) {
			boolean matches = false;
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given PeticaoDistribuida. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoDistribuida entity) {
		// Check whether entity is contained in cache
		if (!_getPeticaoDistribuidaCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getPeticaoDistribuidaCache().remove(entity);
	}
	
	/**
	 * Deletes all given PeticaoDistribuidas. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoDistribuidas(final List<PeticaoDistribuida> entities) {
		for (PeticaoDistribuida entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Returns all PeticaoDistribuidas where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoDistribuida> getArchivedPeticaoDistribuidas() {
		List<PeticaoDistribuida> result = new ArrayList<PeticaoDistribuida>();
		Set<PeticaoDistribuida> cache = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida concreteNext : cache) {
			if (concreteNext.isArchived()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoDistribuidas to the given
	 * value.
	 */
	public void setPeticaoDistribuidasArchived(final boolean value, final boolean includeArchivedEntities) {
		Set<PeticaoDistribuida> cache = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida concreteNext : cache) {
			concreteNext.setArchived(value);
		}
	}
	
	/**
	 * Counts the number of PeticaoDistribuida entities.
	 */
	public int countPeticaoDistribuidas(final boolean includeArchivedEntities) {
		int count = 0;
		Set<PeticaoDistribuida> entities = _getPeticaoDistribuidaCache();
		for (PeticaoDistribuida castedNext : entities) {
			if (!castedNext.isArchived() || includeArchivedEntities) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean archived, final Processo processo) {
		return createPeticaoApenso(numeroId, data, requerente, requerido, resumo, remetente, archived, processo, null);
	}
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean archived, final Processo processo, final IAction<PeticaoApenso> prePersistAction) {
		
		PeticaoApenso newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(processo, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextPeticaoID;
			nextPeticaoID++;
			@java.lang.SuppressWarnings("deprecation")
			PeticaoApenso newPeticaoApenso = new PeticaoApenso(numeroId, data, requerente, requerido, resumo, remetente, archived, processo) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setProcesso(Processo newValue) {
					checkPersisted(newValue, false);
					super.setProcesso(newValue);
				}
				
			};
			newEntity = newPeticaoApenso;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniquePeticaoApenso(newEntity);
		} else {
			newEntity = delegate.createPeticaoApenso(numeroId, data, requerente, requerido, resumo, remetente, archived, processo);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getPeticaoCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the PeticaoApenso with the given id.
	 */
	public PeticaoApenso getPeticaoApenso(final int id) {
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			if (next.getId() == id) {
				return (PeticaoApenso) next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the PeticaoApensos with the given processo.
	 */
	public List<PeticaoApenso> getPeticaoApensosByProcesso(final Processo processo, final boolean includeArchivedEntities) {
		List<PeticaoApenso> result = new ArrayList<PeticaoApenso>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso concreteNext = (PeticaoApenso) next;
			if (concreteNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			
			if (processo == null && concreteNext.getProcesso(true) == null) {
				result.add(concreteNext);
				continue;
			}
			if (processo != null && processo.equals(concreteNext.getProcesso(true))) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataBefore(final Date _maxDate) {
		List<PeticaoApenso> result = new ArrayList<PeticaoApenso>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso concreteNext = (PeticaoApenso) next;
			Date value = concreteNext.getData();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataAfter(final Date _minDate) {
		List<PeticaoApenso> result = new ArrayList<PeticaoApenso>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso concreteNext = (PeticaoApenso) next;
			Date value = concreteNext.getData();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> getAllPeticaoApensos(final boolean includeArchivedEntities) {
		List<PeticaoApenso> result = new ArrayList<PeticaoApenso>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso castedNext = (PeticaoApenso) next;
			if (castedNext.isArchived() && !includeArchivedEntities) {
				continue;
			}
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> searchPeticaoApensos(final java.lang.String _searchString, final int _maxResults) {
		List<PeticaoApenso> result = new ArrayList<PeticaoApenso>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso concreteNext = (PeticaoApenso) next;
			boolean matches = false;
			
			if (!matches) {
				java.lang.String numeroId = concreteNext.getNumeroId();
				if (numeroId != null && numeroId.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String requerente = concreteNext.getRequerente();
				if (requerente != null && requerente.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String requerido = concreteNext.getRequerido();
				if (requerido != null && requerido.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String resumo = concreteNext.getResumo();
				if (resumo != null && resumo.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String remetente = concreteNext.getRemetente();
				if (remetente != null && remetente.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given PeticaoApenso. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoApenso entity) {
		// Check whether entity is contained in cache
		if (!_getPeticaoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getPeticaoCache().remove(entity);
	}
	
	/**
	 * Deletes all given PeticaoApensos. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoApensos(final List<PeticaoApenso> entities) {
		for (PeticaoApenso entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaoApensosWithDataBefore(final Date _maxDate) {
		_getPeticaoCache().removeAll(getPeticaoApensosWithDataBefore(_maxDate));
	}
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaoApensosWithDataAfter(final Date _minDate) {
		_getPeticaoCache().removeAll(getPeticaoApensosWithDataAfter(_minDate));
	}
	
	/**
	 * Returns all PeticaoApensos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoApenso> getArchivedPeticaoApensos() {
		List<PeticaoApenso> result = new ArrayList<PeticaoApenso>();
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso concreteNext = (PeticaoApenso) next;
			if (concreteNext.isArchived()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoApensos to the given value.
	 */
	public void setPeticaoApensosArchived(final boolean value, final boolean includeArchivedEntities) {
		Set<Peticao> cache = _getPeticaoCache();
		for (Peticao next : cache) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso concreteNext = (PeticaoApenso) next;
			concreteNext.setArchived(value);
		}
	}
	
	/**
	 * Counts the number of PeticaoApenso entities.
	 */
	public int countPeticaoApensos(final boolean includeArchivedEntities) {
		int count = 0;
		Set<Peticao> entities = _getPeticaoCache();
		for (Peticao next : entities) {
			if (!(next instanceof PeticaoApenso)) {
				continue;
			}
			PeticaoApenso castedNext = (PeticaoApenso) next;
			if (!castedNext.isArchived() || includeArchivedEntities) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(final String auto) {
		return createAuto(auto, null);
	}
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(final String auto, final IAction<Auto> prePersistAction) {
		
		Auto newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextAutoID;
			nextAutoID++;
			@java.lang.SuppressWarnings("deprecation")
			Auto newAuto = new Auto(auto) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newAuto;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueAuto(newEntity);
		} else {
			newEntity = delegate.createAuto(auto);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getAutoCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Auto with the given id.
	 */
	public Auto getAuto(final int id) {
		Set<Auto> cache = _getAutoCache();
		for (Auto next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Auto.
	 */
	public List<Auto> getAllAutos() {
		List<Auto> result = new ArrayList<Auto>();
		Set<Auto> cache = _getAutoCache();
		for (Auto castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Auto.
	 */
	public List<Auto> searchAutos(final java.lang.String _searchString, final int _maxResults) {
		List<Auto> result = new ArrayList<Auto>();
		Set<Auto> cache = _getAutoCache();
		for (Auto concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String auto = concreteNext.getAuto();
				if (auto != null && auto.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Auto.
	 */
	public void delete(final Auto entity) {
		// Check whether entity is contained in cache
		if (!_getAutoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getAutoCache().remove(entity);
	}
	
	/**
	 * Deletes all given Autos.
	 */
	public void deleteAutos(final List<Auto> entities) {
		for (Auto entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Auto entities.
	 */
	public int countAutos() {
		return _getAutoCache().size();
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial) {
		return createInqueritoSocial(processo, assistenteSocial, null);
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial, final IAction<InqueritoSocial> prePersistAction) {
		
		InqueritoSocial newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(processo, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextInqueritoSocialID;
			nextInqueritoSocialID++;
			@java.lang.SuppressWarnings("deprecation")
			InqueritoSocial newInqueritoSocial = new InqueritoSocial(processo, assistenteSocial) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setProcesso(Processo newValue) {
					checkPersisted(newValue, false);
					super.setProcesso(newValue);
				}
				
			};
			newEntity = newInqueritoSocial;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueInqueritoSocial(newEntity);
		} else {
			newEntity = delegate.createInqueritoSocial(processo, assistenteSocial);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getInqueritoSocialCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id) {
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo) {
		List<InqueritoSocial> result = new ArrayList<InqueritoSocial>();
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial concreteNext : cache) {
			if (processo != null && processo.equals(concreteNext.getProcesso(true))) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials() {
		List<InqueritoSocial> result = new ArrayList<InqueritoSocial>();
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults) {
		List<InqueritoSocial> result = new ArrayList<InqueritoSocial>();
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String assistenteSocial = concreteNext.getAssistenteSocial();
				if (assistenteSocial != null && assistenteSocial.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity) {
		// Check whether entity is contained in cache
		if (!_getInqueritoSocialCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getInqueritoSocialCache().remove(entity);
	}
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities) {
		for (InqueritoSocial entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials() {
		return _getInqueritoSocialCache().size();
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log) {
		return createLog(data, log, null);
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final IAction<Log> prePersistAction) {
		
		Log newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextLogID;
			nextLogID++;
			@java.lang.SuppressWarnings("deprecation")
			Log newLog = new Log(data, log) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newLog;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueLog(newEntity);
		} else {
			newEntity = delegate.createLog(data, log);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getLogCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id) {
		Set<Log> cache = _getLogCache();
		for (Log next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate) {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log next : cache) {
			if (!(next instanceof Log)) {
				continue;
			}
			Log concreteNext = (Log) next;
			Date value = concreteNext.getData();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate) {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log next : cache) {
			if (!(next instanceof Log)) {
				continue;
			}
			Log concreteNext = (Log) next;
			Date value = concreteNext.getData();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs() {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults) {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String log = concreteNext.getLog();
				if (log != null && log.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity) {
		// Check whether entity is contained in cache
		if (!_getLogCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getLogCache().remove(entity);
	}
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities) {
		for (Log entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate) {
		_getLogCache().removeAll(getLogsWithDataBefore(_maxDate));
	}
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate) {
		_getLogCache().removeAll(getLogsWithDataAfter(_minDate));
	}
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs() {
		return _getLogCache().size();
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Categoria categoria, boolean includeEntityNameInExceptionMessage) {
		if (categoria != null && !_getCategoriaCache().contains(categoria)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'categoria'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Seccao seccao, boolean includeEntityNameInExceptionMessage) {
		if (seccao != null && !_getSeccaoCache().contains(seccao)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'seccao'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Livro livro, boolean includeEntityNameInExceptionMessage) {
		if (livro != null && !_getLivroCache().contains(livro)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'livro'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(PeticaoDistribuida peticaoDistribuida, boolean includeEntityNameInExceptionMessage) {
		if (peticaoDistribuida != null && !_getPeticaoDistribuidaCache().contains(peticaoDistribuida)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'peticaoDistribuida'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Auto auto, boolean includeEntityNameInExceptionMessage) {
		if (auto != null && !_getAutoCache().contains(auto)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'auto'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Pagina pagina, boolean includeEntityNameInExceptionMessage) {
		if (pagina != null && !_getPaginaCache().contains(pagina)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'pagina'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(ProcessoAutuado processoAutuado, boolean includeEntityNameInExceptionMessage) {
		if (processoAutuado != null && !_getProcessoCache().contains(processoAutuado)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'processoAutuado'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Peticao peticao, boolean includeEntityNameInExceptionMessage) {
		if (peticao != null && !_getPeticaoCache().contains(peticao)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'peticao'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Processo processo, boolean includeEntityNameInExceptionMessage) {
		if (processo != null && !_getProcessoCache().contains(processo)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'processo'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Usuario merge(Usuario entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Usuario> _getUsuarioCache() {
		if (cachedUsuario == null) {
			cachedUsuario = new LinkedHashSet<Usuario>();
			if (delegate != null) {
				cachedUsuario.addAll(delegate.getAllUsuarios());
			}
		}
		return cachedUsuario;
	}
	
	protected void checkUniqueUsuario(Usuario entity) {
		checkUniqueUsuarioUsername(entity);
	}
	
	protected void checkUniqueUsuarioUsername(Usuario entity) {
		Object username = entity.getUsername();
		checkUniqueUsuarioUsername(entity, username);
	}
	
	protected void checkUniqueUsuarioUsername(Usuario entity, Object username) {
		// Check whether there is already an entity with the same value.
		for (Object existingObject : _getUsuarioCache()) {
			if (existingObject == entity) {
				continue;
			}
			if (!(existingObject instanceof Usuario)) {
				continue;
			}
			Usuario existingEntity = (Usuario) existingObject;
			if (username == null) {
				continue;
			}
			Object existingUsername = existingEntity.getUsername();
			if (!username.equals(existingUsername)) {
				continue;
			}
			throw new java.lang.IllegalArgumentException("Constraint violated for unique property 'username'.");
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Categoria merge(Categoria entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Categoria> _getCategoriaCache() {
		if (cachedCategoria == null) {
			cachedCategoria = new LinkedHashSet<Categoria>();
			if (delegate != null) {
				cachedCategoria.addAll(delegate.getAllCategorias());
			}
		}
		return cachedCategoria;
	}
	
	protected void checkUniqueCategoria(Categoria entity) {
		// The entity Categoria does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Seccao merge(Seccao entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Seccao> _getSeccaoCache() {
		if (cachedSeccao == null) {
			cachedSeccao = new LinkedHashSet<Seccao>();
			if (delegate != null) {
				cachedSeccao.addAll(delegate.getAllSeccaos());
			}
		}
		return cachedSeccao;
	}
	
	protected void checkUniqueSeccao(Seccao entity) {
		// The entity Seccao does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Livro merge(Livro entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Livro> _getLivroCache() {
		if (cachedLivro == null) {
			cachedLivro = new LinkedHashSet<Livro>();
			if (delegate != null) {
				cachedLivro.addAll(delegate.getAllLivros());
			}
		}
		return cachedLivro;
	}
	
	protected void checkUniqueLivro(Livro entity) {
		checkUniqueLivroNome(entity);
	}
	
	protected void checkUniqueLivroNome(Livro entity) {
		Object nome = entity.getNome();
		checkUniqueLivroNome(entity, nome);
	}
	
	protected void checkUniqueLivroNome(Livro entity, Object nome) {
		// Check whether there is already an entity with the same value.
		for (Object existingObject : _getLivroCache()) {
			if (existingObject == entity) {
				continue;
			}
			if (!(existingObject instanceof Livro)) {
				continue;
			}
			Livro existingEntity = (Livro) existingObject;
			if (nome == null) {
				continue;
			}
			Object existingNome = existingEntity.getNome();
			if (!nome.equals(existingNome)) {
				continue;
			}
			throw new java.lang.IllegalArgumentException("Constraint violated for unique property 'nome'.");
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Pagina merge(Pagina entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Pagina> _getPaginaCache() {
		if (cachedPagina == null) {
			cachedPagina = new LinkedHashSet<Pagina>();
			if (delegate != null) {
				cachedPagina.addAll(delegate.getAllPaginas());
			}
		}
		return cachedPagina;
	}
	
	protected void checkUniquePagina(Pagina entity) {
		// The entity Pagina does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Processo merge(Processo entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Processo> _getProcessoCache() {
		if (cachedProcesso == null) {
			cachedProcesso = new LinkedHashSet<Processo>();
			if (delegate != null) {
				cachedProcesso.addAll(delegate.getAllProcessos(true));
			}
		}
		return cachedProcesso;
	}
	
	protected void checkUniqueProcesso(Processo entity) {
		checkUniqueProcessoIdentification(entity);
	}
	
	protected void checkUniqueProcessoIdentification(Processo entity) {
		Object identification = entity.getIdentification();
		checkUniqueProcessoIdentification(entity, identification);
	}
	
	protected void checkUniqueProcessoIdentification(Processo entity, Object identification) {
		// Check whether there is already an entity with the same value.
		for (Object existingObject : _getProcessoCache()) {
			if (existingObject == entity) {
				continue;
			}
			if (!(existingObject instanceof Processo)) {
				continue;
			}
			Processo existingEntity = (Processo) existingObject;
			if (identification == null) {
				continue;
			}
			Object existingIdentification = existingEntity.getIdentification();
			if (!identification.equals(existingIdentification)) {
				continue;
			}
			throw new java.lang.IllegalArgumentException("Constraint violated for unique property 'identification'.");
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public ProcessoAutuado merge(ProcessoAutuado entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected void checkUniqueProcessoAutuado(ProcessoAutuado entity) {
		checkUniqueProcessoAutuadoIdentification(entity);
	}
	
	protected void checkUniqueProcessoAutuadoIdentification(ProcessoAutuado entity) {
		Object identification = entity.getIdentification();
		checkUniqueProcessoAutuadoIdentification(entity, identification);
	}
	
	protected void checkUniqueProcessoAutuadoIdentification(ProcessoAutuado entity, Object identification) {
		// Check whether there is already an entity with the same value.
		for (Object existingObject : _getProcessoCache()) {
			if (existingObject == entity) {
				continue;
			}
			if (!(existingObject instanceof ProcessoAutuado)) {
				continue;
			}
			ProcessoAutuado existingEntity = (ProcessoAutuado) existingObject;
			if (identification == null) {
				continue;
			}
			Object existingIdentification = existingEntity.getIdentification();
			if (!identification.equals(existingIdentification)) {
				continue;
			}
			throw new java.lang.IllegalArgumentException("Constraint violated for unique property 'identification'.");
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Registro merge(Registro entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Registro> _getRegistroCache() {
		if (cachedRegistro == null) {
			cachedRegistro = new LinkedHashSet<Registro>();
			if (delegate != null) {
				cachedRegistro.addAll(delegate.getAllRegistros());
			}
		}
		return cachedRegistro;
	}
	
	protected void checkUniqueRegistro(Registro entity) {
		// The entity Registro does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Peticao merge(Peticao entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Peticao> _getPeticaoCache() {
		if (cachedPeticao == null) {
			cachedPeticao = new LinkedHashSet<Peticao>();
			if (delegate != null) {
				cachedPeticao.addAll(delegate.getAllPeticaos(true));
			}
		}
		return cachedPeticao;
	}
	
	protected void checkUniquePeticao(Peticao entity) {
		// The entity Peticao does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public PeticaoDistribuida merge(PeticaoDistribuida entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<PeticaoDistribuida> _getPeticaoDistribuidaCache() {
		if (cachedPeticaoDistribuida == null) {
			cachedPeticaoDistribuida = new LinkedHashSet<PeticaoDistribuida>();
			if (delegate != null) {
				cachedPeticaoDistribuida.addAll(delegate.getAllPeticaoDistribuidas(true));
			}
		}
		return cachedPeticaoDistribuida;
	}
	
	protected void checkUniquePeticaoDistribuida(PeticaoDistribuida entity) {
		// The entity PeticaoDistribuida does not have any uniqueness constraints.
		// Therefore, this method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public PeticaoApenso merge(PeticaoApenso entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected void checkUniquePeticaoApenso(PeticaoApenso entity) {
		// The entity PeticaoApenso does not have any uniqueness constraints. Therefore,
		// this method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Auto merge(Auto entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Auto> _getAutoCache() {
		if (cachedAuto == null) {
			cachedAuto = new LinkedHashSet<Auto>();
			if (delegate != null) {
				cachedAuto.addAll(delegate.getAllAutos());
			}
		}
		return cachedAuto;
	}
	
	protected void checkUniqueAuto(Auto entity) {
		// The entity Auto does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public InqueritoSocial merge(InqueritoSocial entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<InqueritoSocial> _getInqueritoSocialCache() {
		if (cachedInqueritoSocial == null) {
			cachedInqueritoSocial = new LinkedHashSet<InqueritoSocial>();
			if (delegate != null) {
				cachedInqueritoSocial.addAll(delegate.getAllInqueritoSocials());
			}
		}
		return cachedInqueritoSocial;
	}
	
	protected void checkUniqueInqueritoSocial(InqueritoSocial entity) {
		// The entity InqueritoSocial does not have any uniqueness constraints. Therefore,
		// this method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Log merge(Log entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Log> _getLogCache() {
		if (cachedLog == null) {
			cachedLog = new LinkedHashSet<Log>();
			if (delegate != null) {
				cachedLog.addAll(delegate.getAllLogs());
			}
		}
		return cachedLog;
	}
	
	protected void checkUniqueLog(Log entity) {
		// The entity Log does not have any uniqueness constraints. Therefore, this method
		// remains empty.
	}
	
	/**
	 * Executes the given function. Currently, the generated cache basically executes
	 * the function without any transaction behavior.
	 */
	public <T> T executeInTransaction(IFunction<T> function) {
		if (this instanceof tribunal.custom.IDBOperations) {
			return function.execute((tribunal.custom.IDBOperations) this);
		} else {
			throw new java.lang.RuntimeException("All sub classes of TribunalCacheBase must implement tribunal.custom.IDBOperations");
		}
	}
	
	/**
	 * Executes the given command. Currently, the generated cache basically executes
	 * the function without any transaction behavior.
	 */
	public void executeInTransaction(ICommand command) {
		if (this instanceof tribunal.custom.IDBOperations) {
			command.execute((tribunal.custom.IDBOperations) this);
		} else {
			throw new java.lang.RuntimeException("All sub classes of TribunalCacheBase must implement tribunal.custom.IDBOperations");
		}
	}
	
	protected boolean isSameValue(Object value1, Object value2) {
		if (value1 == null) {
			if (value2 != null) {
				return false;
			}
		} else {
			if (value1.equals(value2)) {
				return true;
			}
		}
		return false;
	}
	
}
