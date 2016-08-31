package tribunal.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public abstract class OperationProviderBase implements IDBOperationsBase {
	
	protected UsuarioDAO usuarioDAO = new UsuarioDAO();
	protected CategoriaDAO categoriaDAO = new CategoriaDAO();
	protected SeccaoDAO seccaoDAO = new SeccaoDAO();
	protected LivroDAO livroDAO = new LivroDAO();
	protected PaginaDAO paginaDAO = new PaginaDAO();
	protected ProcessoDAO processoDAO = new ProcessoDAO();
	protected ProcessoAutuadoDAO processoAutuadoDAO = new ProcessoAutuadoDAO();
	protected RegistroDAO registroDAO = new RegistroDAO();
	protected PeticaoDAO peticaoDAO = new PeticaoDAO();
	protected PeticaoDistribuidaDAO peticaoDistribuidaDAO = new PeticaoDistribuidaDAO();
	protected PeticaoApensoDAO peticaoApensoDAO = new PeticaoApensoDAO();
	protected AutoDAO autoDAO = new AutoDAO();
	protected InqueritoSocialDAO inqueritoSocialDAO = new InqueritoSocialDAO();
	protected LogDAO logDAO = new LogDAO();
	
	private EntityManager entityManager;
	
	public OperationProviderBase(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void flush() {
		getEntityManager().flush();
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final Categoria categoria, final Seccao seccao, final boolean archived) {
		return usuarioDAO.create(getEntityManager(), nome, dataDeNascimento, username, password, categoria, seccao, archived);
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final Categoria categoria, final Seccao seccao, final boolean archived, final IAction<Usuario> prePersistAction) {
		return usuarioDAO.create(getEntityManager(), nome, dataDeNascimento, username, password, categoria, seccao, archived, prePersistAction);
	}
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id) {
		Usuario entity = usuarioDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username, final boolean includedArchivedEntities) {
		Usuario entity = usuarioDAO.getByUsername(getEntityManager(), username, includedArchivedEntities);
		return entity;
	}
	
	/**
	 * Returns the Usuarios with the given categoria.
	 */
	public List<Usuario> getUsuariosByCategoria(final Categoria categoria, final boolean includeArchivedEntities) {
		List<Usuario> entities = usuarioDAO.getByCategoria(getEntityManager(), categoria, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns the Usuarios with the given seccao.
	 */
	public List<Usuario> getUsuariosBySeccao(final Seccao seccao, final boolean includeArchivedEntities) {
		List<Usuario> entities = usuarioDAO.getBySeccao(getEntityManager(), seccao, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		final List<Usuario> entities = usuarioDAO.getDataDeNascimentoBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		final List<Usuario> entities = usuarioDAO.getDataDeNascimentoAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all Usuarios where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Usuario> getArchivedUsuarios() {
		final List<Usuario> entities = usuarioDAO.getArchived(getEntityManager());
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Usuarios to the given value.
	 */
	public void setUsuariosArchived(final boolean value, final boolean includeArchivedEntities) {
		usuarioDAO.setArchived(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios(final boolean includeArchivedEntities) {
		final List<Usuario> entities = usuarioDAO.getAll(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults) {
		return usuarioDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Usuario. This method is deprecated, because Usuario is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Usuario entity) {
		usuarioDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Usuarios. This method is deprecated, because Usuario is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteUsuarios(final List<Usuario> entities) {
		usuarioDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Usuario.class.getName() + " " + "WHERE " + UsuarioDAO.FIELD__DATADENASCIMENTO + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Usuario.class.getName() + " " + "WHERE " + UsuarioDAO.FIELD__DATADENASCIMENTO + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios(final boolean includeArchivedEntities) {
		return usuarioDAO.count(getEntityManager(), includeArchivedEntities);
	}
	
	public Usuario merge(Usuario entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(final String nome) {
		return categoriaDAO.create(getEntityManager(), nome);
	}
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(final String nome, final IAction<Categoria> prePersistAction) {
		return categoriaDAO.create(getEntityManager(), nome, prePersistAction);
	}
	
	/**
	 * Returns the Categoria with the given id.
	 */
	public Categoria getCategoria(final int id) {
		Categoria entity = categoriaDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Categoria.
	 */
	public List<Categoria> getAllCategorias() {
		final List<Categoria> entities = categoriaDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Categoria.
	 */
	public List<Categoria> searchCategorias(final java.lang.String _searchString, final int _maxResults) {
		return categoriaDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Categoria.
	 */
	public void delete(final Categoria entity) {
		categoriaDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Categorias.
	 */
	public void deleteCategorias(final List<Categoria> entities) {
		categoriaDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Categoria entities.
	 */
	public int countCategorias() {
		return categoriaDAO.count(getEntityManager());
	}
	
	public Categoria merge(Categoria entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(final String nome) {
		return seccaoDAO.create(getEntityManager(), nome);
	}
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(final String nome, final IAction<Seccao> prePersistAction) {
		return seccaoDAO.create(getEntityManager(), nome, prePersistAction);
	}
	
	/**
	 * Returns the Seccao with the given id.
	 */
	public Seccao getSeccao(final int id) {
		Seccao entity = seccaoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Seccao.
	 */
	public List<Seccao> getAllSeccaos() {
		final List<Seccao> entities = seccaoDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Seccao.
	 */
	public List<Seccao> searchSeccaos(final java.lang.String _searchString, final int _maxResults) {
		return seccaoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Seccao.
	 */
	public void delete(final Seccao entity) {
		seccaoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Seccaos.
	 */
	public void deleteSeccaos(final List<Seccao> entities) {
		seccaoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Seccao entities.
	 */
	public int countSeccaos() {
		return seccaoDAO.count(getEntityManager());
	}
	
	public Seccao merge(Seccao entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final long numero) {
		return livroDAO.create(getEntityManager(), nome, numero);
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final long numero, final IAction<Livro> prePersistAction) {
		return livroDAO.create(getEntityManager(), nome, numero, prePersistAction);
	}
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id) {
		Livro entity = livroDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome) {
		Livro entity = livroDAO.getByNome(getEntityManager(), nome);
		return entity;
	}
	
	/**
	 * Returns all Livros where the given pagina is contained in the collection
	 * 'pagina'.
	 */
	public List<Livro> getLivrosByPagina(final Pagina pagina) {
		List<Livro> entities = livroDAO.getByPagina(getEntityManager(), pagina);
		return entities;
	}
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros() {
		final List<Livro> entities = livroDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults) {
		return livroDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity) {
		livroDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities) {
		livroDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros() {
		return livroDAO.count(getEntityManager());
	}
	
	public Livro merge(Livro entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final int pag, final Livro livro) {
		return paginaDAO.create(getEntityManager(), pag, livro);
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final int pag, final Livro livro, final IAction<Pagina> prePersistAction) {
		return paginaDAO.create(getEntityManager(), pag, livro, prePersistAction);
	}
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id) {
		Pagina entity = paginaDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Paginas with the given livro.
	 */
	public List<Pagina> getPaginasByLivro(final Livro livro) {
		List<Pagina> entities = paginaDAO.getByLivro(getEntityManager(), livro);
		return entities;
	}
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas() {
		final List<Pagina> entities = paginaDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults) {
		return paginaDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity) {
		paginaDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities) {
		paginaDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas() {
		return paginaDAO.count(getEntityManager());
	}
	
	public Pagina merge(Pagina entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived) {
		return processoDAO.create(getEntityManager(), data, identification, peticao, auto, pagina, archived);
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived, final IAction<Processo> prePersistAction) {
		return processoDAO.create(getEntityManager(), data, identification, peticao, auto, pagina, archived, prePersistAction);
	}
	
	/**
	 * Returns the Processo with the given id.
	 */
	// This method is deprecated because the entity Processo has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Processo getProcesso(final int id) {
		Processo entity = processoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Processo with the given identification.
	 */
	public Processo getProcessoByIdentification(final String identification, final boolean includedArchivedEntities) {
		Processo entity = processoDAO.getByIdentification(getEntityManager(), identification, includedArchivedEntities);
		return entity;
	}
	
	/**
	 * Returns the Processos with the given peticao.
	 */
	public List<Processo> getProcessosByPeticao(final Peticao peticao, final boolean includeArchivedEntities) {
		List<Processo> entities = processoDAO.getByPeticao(getEntityManager(), peticao, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns the Processos with the given auto.
	 */
	public List<Processo> getProcessosByAuto(final Auto auto, final boolean includeArchivedEntities) {
		List<Processo> entities = processoDAO.getByAuto(getEntityManager(), auto, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns the Processos with the given pagina.
	 */
	public List<Processo> getProcessosByPagina(final Pagina pagina, final boolean includeArchivedEntities) {
		List<Processo> entities = processoDAO.getByPagina(getEntityManager(), pagina, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value before '_maxDate'.
	 */
	public List<Processo> getProcessosWithDataBefore(final Date _maxDate) {
		final List<Processo> entities = processoDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value after '_minDate'.
	 */
	public List<Processo> getProcessosWithDataAfter(final Date _minDate) {
		final List<Processo> entities = processoDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all Processos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Processo> getArchivedProcessos() {
		final List<Processo> entities = processoDAO.getArchived(getEntityManager());
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Processos to the given value.
	 */
	public void setProcessosArchived(final boolean value, final boolean includeArchivedEntities) {
		processoDAO.setArchived(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos(final boolean includeArchivedEntities) {
		final List<Processo> entities = processoDAO.getAll(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults) {
		return processoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Processo. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Processo entity) {
		processoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Processos. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessos(final List<Processo> entities) {
		processoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Processos where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessosWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Processo.class.getName() + " " + "WHERE " + ProcessoDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Processos where data is set to a value after '_minDate'.
	 */
	public void deleteProcessosWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Processo.class.getName() + " " + "WHERE " + ProcessoDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos(final boolean includeArchivedEntities) {
		return processoDAO.count(getEntityManager(), includeArchivedEntities);
	}
	
	public Processo merge(Processo entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived, final Boolean conclusao) {
		return processoAutuadoDAO.create(getEntityManager(), data, identification, peticao, auto, pagina, archived, conclusao);
	}
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(final Date data, final String identification, final Peticao peticao, final Auto auto, final Pagina pagina, final boolean archived, final Boolean conclusao, final IAction<ProcessoAutuado> prePersistAction) {
		return processoAutuadoDAO.create(getEntityManager(), data, identification, peticao, auto, pagina, archived, conclusao, prePersistAction);
	}
	
	/**
	 * Returns the ProcessoAutuado with the given id.
	 */
	// This method is deprecated because the entity ProcessoAutuado has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public ProcessoAutuado getProcessoAutuado(final int id) {
		ProcessoAutuado entity = processoAutuadoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the ProcessoAutuado with the given identification.
	 */
	public ProcessoAutuado getProcessoAutuadoByIdentification(final String identification, final boolean includedArchivedEntities) {
		ProcessoAutuado entity = processoAutuadoDAO.getByIdentification(getEntityManager(), identification, includedArchivedEntities);
		return entity;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given peticao.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPeticao(final Peticao peticao, final boolean includeArchivedEntities) {
		List<ProcessoAutuado> entities = processoAutuadoDAO.getByPeticao(getEntityManager(), peticao, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given auto.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByAuto(final Auto auto, final boolean includeArchivedEntities) {
		List<ProcessoAutuado> entities = processoAutuadoDAO.getByAuto(getEntityManager(), auto, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns the ProcessoAutuados with the given pagina.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPagina(final Pagina pagina, final boolean includeArchivedEntities) {
		List<ProcessoAutuado> entities = processoAutuadoDAO.getByPagina(getEntityManager(), pagina, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns all ProcessoAutuados where the given registro is contained in the
	 * collection 'registro'.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByRegistro(final Registro registro) {
		List<ProcessoAutuado> entities = processoAutuadoDAO.getByRegistro(getEntityManager(), registro);
		return entities;
	}
	
	/**
	 * Returns all ProcessoAutuados where data is set to a value before '_maxDate'.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosWithDataBefore(final Date _maxDate) {
		final List<ProcessoAutuado> entities = processoAutuadoDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all ProcessoAutuados where data is set to a value after '_minDate'.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosWithDataAfter(final Date _minDate) {
		final List<ProcessoAutuado> entities = processoAutuadoDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all ProcessoAutuados where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<ProcessoAutuado> getArchivedProcessoAutuados() {
		final List<ProcessoAutuado> entities = processoAutuadoDAO.getArchived(getEntityManager());
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all ProcessoAutuados to the given
	 * value.
	 */
	public void setProcessoAutuadosArchived(final boolean value, final boolean includeArchivedEntities) {
		processoAutuadoDAO.setArchived(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all ProcessoAutuados where the boolean property 'conclusao' is set to
	 * <code>true</code>.
	 */
	public List<ProcessoAutuado> getConclusaoProcessoAutuados(final boolean includeArchivedEntities) {
		final List<ProcessoAutuado> entities = processoAutuadoDAO.getConclusao(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Sets the boolean property 'conclusao' for all ProcessoAutuados to the given
	 * value.
	 */
	public void setProcessoAutuadosConclusao(final boolean value, final boolean includeArchivedEntities) {
		processoAutuadoDAO.setConclusao(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> getAllProcessoAutuados(final boolean includeArchivedEntities) {
		final List<ProcessoAutuado> entities = processoAutuadoDAO.getAll(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Searches for entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> searchProcessoAutuados(final java.lang.String _searchString, final int _maxResults) {
		return processoAutuadoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given ProcessoAutuado. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final ProcessoAutuado entity) {
		processoAutuadoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given ProcessoAutuados. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessoAutuados(final List<ProcessoAutuado> entities) {
		processoAutuadoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all ProcessoAutuados where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessoAutuadosWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + ProcessoAutuado.class.getName() + " " + "WHERE " + ProcessoDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all ProcessoAutuados where data is set to a value after '_minDate'.
	 */
	public void deleteProcessoAutuadosWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + ProcessoAutuado.class.getName() + " " + "WHERE " + ProcessoDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of ProcessoAutuado entities.
	 */
	public int countProcessoAutuados(final boolean includeArchivedEntities) {
		return processoAutuadoDAO.count(getEntityManager(), includeArchivedEntities);
	}
	
	public ProcessoAutuado merge(ProcessoAutuado entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(final Date data, final String infoRegisto, final ProcessoAutuado processoAutuado, final Usuario user) {
		return registroDAO.create(getEntityManager(), data, infoRegisto, processoAutuado, user);
	}
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(final Date data, final String infoRegisto, final ProcessoAutuado processoAutuado, final Usuario user, final IAction<Registro> prePersistAction) {
		return registroDAO.create(getEntityManager(), data, infoRegisto, processoAutuado, user, prePersistAction);
	}
	
	/**
	 * Returns the Registro with the given id.
	 */
	public Registro getRegistro(final int id) {
		Registro entity = registroDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Registros with the given processoAutuado.
	 */
	public List<Registro> getRegistrosByProcessoAutuado(final ProcessoAutuado processoAutuado) {
		List<Registro> entities = registroDAO.getByProcessoAutuado(getEntityManager(), processoAutuado);
		return entities;
	}
	
	/**
	 * Returns the Registros with the given user.
	 */
	public List<Registro> getRegistrosByUser(final Usuario user) {
		List<Registro> entities = registroDAO.getByUser(getEntityManager(), user);
		return entities;
	}
	
	/**
	 * Returns all Registros where data is set to a value before '_maxDate'.
	 */
	public List<Registro> getRegistrosWithDataBefore(final Date _maxDate) {
		final List<Registro> entities = registroDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Registros where data is set to a value after '_minDate'.
	 */
	public List<Registro> getRegistrosWithDataAfter(final Date _minDate) {
		final List<Registro> entities = registroDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type Registro.
	 */
	public List<Registro> getAllRegistros() {
		final List<Registro> entities = registroDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Registro.
	 */
	public List<Registro> searchRegistros(final java.lang.String _searchString, final int _maxResults) {
		return registroDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Registro.
	 */
	public void delete(final Registro entity) {
		registroDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Registros.
	 */
	public void deleteRegistros(final List<Registro> entities) {
		registroDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Registros where data is set to a value before '_maxDate'.
	 */
	public void deleteRegistrosWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Registro.class.getName() + " " + "WHERE " + RegistroDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Registros where data is set to a value after '_minDate'.
	 */
	public void deleteRegistrosWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Registro.class.getName() + " " + "WHERE " + RegistroDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Registro entities.
	 */
	public int countRegistros() {
		return registroDAO.count(getEntityManager());
	}
	
	public Registro merge(Registro entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived) {
		return peticaoDAO.create(getEntityManager(), numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived);
	}
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final IAction<Peticao> prePersistAction) {
		return peticaoDAO.create(getEntityManager(), numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, prePersistAction);
	}
	
	/**
	 * Returns the Peticao with the given id.
	 */
	public Peticao getPeticao(final int id) {
		Peticao entity = peticaoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all Peticaos where data is set to a value before '_maxDate'.
	 */
	public List<Peticao> getPeticaosWithDataBefore(final Date _maxDate) {
		final List<Peticao> entities = peticaoDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Peticaos where data is set to a value after '_minDate'.
	 */
	public List<Peticao> getPeticaosWithDataAfter(final Date _minDate) {
		final List<Peticao> entities = peticaoDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all Peticaos where the boolean property 'dist' is set to
	 * <code>true</code>.
	 */
	public List<Peticao> getDistPeticaos(final boolean includeArchivedEntities) {
		final List<Peticao> entities = peticaoDAO.getDist(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Sets the boolean property 'dist' for all Peticaos to the given value.
	 */
	public void setPeticaosDist(final boolean value, final boolean includeArchivedEntities) {
		peticaoDAO.setDist(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all Peticaos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Peticao> getArchivedPeticaos() {
		final List<Peticao> entities = peticaoDAO.getArchived(getEntityManager());
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Peticaos to the given value.
	 */
	public void setPeticaosArchived(final boolean value, final boolean includeArchivedEntities) {
		peticaoDAO.setArchived(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all entities of type Peticao.
	 */
	public List<Peticao> getAllPeticaos(final boolean includeArchivedEntities) {
		final List<Peticao> entities = peticaoDAO.getAll(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Searches for entities of type Peticao.
	 */
	public List<Peticao> searchPeticaos(final java.lang.String _searchString, final int _maxResults) {
		return peticaoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Peticao. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Peticao entity) {
		peticaoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Peticaos. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaos(final List<Peticao> entities) {
		peticaoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Peticaos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaosWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Peticao.class.getName() + " " + "WHERE " + PeticaoDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Peticaos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaosWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Peticao.class.getName() + " " + "WHERE " + PeticaoDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Peticao entities.
	 */
	public int countPeticaos(final boolean includeArchivedEntities) {
		return peticaoDAO.count(getEntityManager(), includeArchivedEntities);
	}
	
	public Peticao merge(Peticao entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Seccao seccao) {
		return peticaoDistribuidaDAO.create(getEntityManager(), numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, seccao);
	}
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Seccao seccao, final IAction<PeticaoDistribuida> prePersistAction) {
		return peticaoDistribuidaDAO.create(getEntityManager(), numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, seccao, prePersistAction);
	}
	
	/**
	 * Returns the PeticaoDistribuida with the given id.
	 */
	public PeticaoDistribuida getPeticaoDistribuida(final int id) {
		PeticaoDistribuida entity = peticaoDistribuidaDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the PeticaoDistribuidas with the given seccao.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasBySeccao(final Seccao seccao, final boolean includeArchivedEntities) {
		List<PeticaoDistribuida> entities = peticaoDistribuidaDAO.getBySeccao(getEntityManager(), seccao, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns all PeticaoDistribuidas where data is set to a value before '_maxDate'.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasWithDataBefore(final Date _maxDate) {
		final List<PeticaoDistribuida> entities = peticaoDistribuidaDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all PeticaoDistribuidas where data is set to a value after '_minDate'.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasWithDataAfter(final Date _minDate) {
		final List<PeticaoDistribuida> entities = peticaoDistribuidaDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all PeticaoDistribuidas where the boolean property 'dist' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoDistribuida> getDistPeticaoDistribuidas(final boolean includeArchivedEntities) {
		final List<PeticaoDistribuida> entities = peticaoDistribuidaDAO.getDist(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Sets the boolean property 'dist' for all PeticaoDistribuidas to the given value.
	 */
	public void setPeticaoDistribuidasDist(final boolean value, final boolean includeArchivedEntities) {
		peticaoDistribuidaDAO.setDist(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all PeticaoDistribuidas where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoDistribuida> getArchivedPeticaoDistribuidas() {
		final List<PeticaoDistribuida> entities = peticaoDistribuidaDAO.getArchived(getEntityManager());
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoDistribuidas to the given
	 * value.
	 */
	public void setPeticaoDistribuidasArchived(final boolean value, final boolean includeArchivedEntities) {
		peticaoDistribuidaDAO.setArchived(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> getAllPeticaoDistribuidas(final boolean includeArchivedEntities) {
		final List<PeticaoDistribuida> entities = peticaoDistribuidaDAO.getAll(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Searches for entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> searchPeticaoDistribuidas(final java.lang.String _searchString, final int _maxResults) {
		return peticaoDistribuidaDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given PeticaoDistribuida. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoDistribuida entity) {
		peticaoDistribuidaDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given PeticaoDistribuidas. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoDistribuidas(final List<PeticaoDistribuida> entities) {
		peticaoDistribuidaDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all PeticaoDistribuidas where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaoDistribuidasWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + PeticaoDistribuida.class.getName() + " " + "WHERE " + PeticaoDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all PeticaoDistribuidas where data is set to a value after '_minDate'.
	 */
	public void deletePeticaoDistribuidasWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + PeticaoDistribuida.class.getName() + " " + "WHERE " + PeticaoDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of PeticaoDistribuida entities.
	 */
	public int countPeticaoDistribuidas(final boolean includeArchivedEntities) {
		return peticaoDistribuidaDAO.count(getEntityManager(), includeArchivedEntities);
	}
	
	public PeticaoDistribuida merge(PeticaoDistribuida entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Processo processo) {
		return peticaoApensoDAO.create(getEntityManager(), numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, processo);
	}
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(final String numeroId, final Date data, final String requerente, final String requerido, final String resumo, final String remetente, final boolean dist, final String apenso, final boolean archived, final Processo processo, final IAction<PeticaoApenso> prePersistAction) {
		return peticaoApensoDAO.create(getEntityManager(), numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, processo, prePersistAction);
	}
	
	/**
	 * Returns the PeticaoApenso with the given id.
	 */
	public PeticaoApenso getPeticaoApenso(final int id) {
		PeticaoApenso entity = peticaoApensoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the PeticaoApensos with the given processo.
	 */
	public List<PeticaoApenso> getPeticaoApensosByProcesso(final Processo processo, final boolean includeArchivedEntities) {
		List<PeticaoApenso> entities = peticaoApensoDAO.getByProcesso(getEntityManager(), processo, includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataBefore(final Date _maxDate) {
		final List<PeticaoApenso> entities = peticaoApensoDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataAfter(final Date _minDate) {
		final List<PeticaoApenso> entities = peticaoApensoDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where the boolean property 'dist' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoApenso> getDistPeticaoApensos(final boolean includeArchivedEntities) {
		final List<PeticaoApenso> entities = peticaoApensoDAO.getDist(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Sets the boolean property 'dist' for all PeticaoApensos to the given value.
	 */
	public void setPeticaoApensosDist(final boolean value, final boolean includeArchivedEntities) {
		peticaoApensoDAO.setDist(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all PeticaoApensos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoApenso> getArchivedPeticaoApensos() {
		final List<PeticaoApenso> entities = peticaoApensoDAO.getArchived(getEntityManager());
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoApensos to the given value.
	 */
	public void setPeticaoApensosArchived(final boolean value, final boolean includeArchivedEntities) {
		peticaoApensoDAO.setArchived(getEntityManager(), value, includeArchivedEntities);
	}
	
	/**
	 * Returns all entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> getAllPeticaoApensos(final boolean includeArchivedEntities) {
		final List<PeticaoApenso> entities = peticaoApensoDAO.getAll(getEntityManager(), includeArchivedEntities);
		return entities;
	}
	
	/**
	 * Searches for entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> searchPeticaoApensos(final java.lang.String _searchString, final int _maxResults) {
		return peticaoApensoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given PeticaoApenso. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoApenso entity) {
		peticaoApensoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given PeticaoApensos. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoApensos(final List<PeticaoApenso> entities) {
		peticaoApensoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaoApensosWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + PeticaoApenso.class.getName() + " " + "WHERE " + PeticaoDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaoApensosWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + PeticaoApenso.class.getName() + " " + "WHERE " + PeticaoDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of PeticaoApenso entities.
	 */
	public int countPeticaoApensos(final boolean includeArchivedEntities) {
		return peticaoApensoDAO.count(getEntityManager(), includeArchivedEntities);
	}
	
	public PeticaoApenso merge(PeticaoApenso entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(final String auto) {
		return autoDAO.create(getEntityManager(), auto);
	}
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(final String auto, final IAction<Auto> prePersistAction) {
		return autoDAO.create(getEntityManager(), auto, prePersistAction);
	}
	
	/**
	 * Returns the Auto with the given id.
	 */
	public Auto getAuto(final int id) {
		Auto entity = autoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Auto.
	 */
	public List<Auto> getAllAutos() {
		final List<Auto> entities = autoDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Auto.
	 */
	public List<Auto> searchAutos(final java.lang.String _searchString, final int _maxResults) {
		return autoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Auto.
	 */
	public void delete(final Auto entity) {
		autoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Autos.
	 */
	public void deleteAutos(final List<Auto> entities) {
		autoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Auto entities.
	 */
	public int countAutos() {
		return autoDAO.count(getEntityManager());
	}
	
	public Auto merge(Auto entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial) {
		return inqueritoSocialDAO.create(getEntityManager(), processo, assistenteSocial);
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial, final IAction<InqueritoSocial> prePersistAction) {
		return inqueritoSocialDAO.create(getEntityManager(), processo, assistenteSocial, prePersistAction);
	}
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id) {
		InqueritoSocial entity = inqueritoSocialDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo) {
		List<InqueritoSocial> entities = inqueritoSocialDAO.getByProcesso(getEntityManager(), processo);
		return entities;
	}
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials() {
		final List<InqueritoSocial> entities = inqueritoSocialDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults) {
		return inqueritoSocialDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity) {
		inqueritoSocialDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities) {
		inqueritoSocialDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials() {
		return inqueritoSocialDAO.count(getEntityManager());
	}
	
	public InqueritoSocial merge(InqueritoSocial entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final Usuario user) {
		return logDAO.create(getEntityManager(), data, log, user);
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final Usuario user, final IAction<Log> prePersistAction) {
		return logDAO.create(getEntityManager(), data, log, user, prePersistAction);
	}
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id) {
		Log entity = logDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Logs with the given user.
	 */
	public List<Log> getLogsByUser(final Usuario user) {
		List<Log> entities = logDAO.getByUser(getEntityManager(), user);
		return entities;
	}
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate) {
		final List<Log> entities = logDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate) {
		final List<Log> entities = logDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs() {
		final List<Log> entities = logDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults) {
		return logDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity) {
		logDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities) {
		logDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Log.class.getName() + " " + "WHERE " + LogDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Log.class.getName() + " " + "WHERE " + LogDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs() {
		return logDAO.count(getEntityManager());
	}
	
	public Log merge(Log entity) {
		return getEntityManager().merge(entity);
	}
	
}
