package tribunal.dao;

import java.util.Date;
import java.util.List;
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
public interface IDBOperationsBase {
	
	public void flush();
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(String nome, Date dataDeNascimento, String username, String password, Categoria categoria, Seccao seccao);
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(String nome, Date dataDeNascimento, String username, String password, Categoria categoria, Seccao seccao, IAction<Usuario> prePersistAction);
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id);
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username);
	
	/**
	 * Returns the Usuarios with the given categoria.
	 */
	public List<Usuario> getUsuariosByCategoria(final Categoria categoria);
	
	/**
	 * Returns the Usuarios with the given seccao.
	 */
	public List<Usuario> getUsuariosBySeccao(final Seccao seccao);
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate);
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios();
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Usuario.
	 */
	public void delete(final Usuario entity);
	
	/**
	 * Deletes all given Usuarios.
	 */
	public void deleteUsuarios(final List<Usuario> entities);
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate);
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate);
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Usuario merge(Usuario entity);
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(String nome);
	
	/**
	 * Creates a new Categoria using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Categoria createCategoria(String nome, IAction<Categoria> prePersistAction);
	
	/**
	 * Returns the Categoria with the given id.
	 */
	public Categoria getCategoria(final int id);
	
	/**
	 * Returns all entities of type Categoria.
	 */
	public List<Categoria> getAllCategorias();
	
	/**
	 * Searches for entities of type Categoria.
	 */
	public List<Categoria> searchCategorias(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Categoria.
	 */
	public void delete(final Categoria entity);
	
	/**
	 * Deletes all given Categorias.
	 */
	public void deleteCategorias(final List<Categoria> entities);
	
	/**
	 * Counts the number of Categoria entities.
	 */
	public int countCategorias();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Categoria merge(Categoria entity);
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(String nome);
	
	/**
	 * Creates a new Seccao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Seccao createSeccao(String nome, IAction<Seccao> prePersistAction);
	
	/**
	 * Returns the Seccao with the given id.
	 */
	public Seccao getSeccao(final int id);
	
	/**
	 * Returns all entities of type Seccao.
	 */
	public List<Seccao> getAllSeccaos();
	
	/**
	 * Searches for entities of type Seccao.
	 */
	public List<Seccao> searchSeccaos(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Seccao.
	 */
	public void delete(final Seccao entity);
	
	/**
	 * Deletes all given Seccaos.
	 */
	public void deleteSeccaos(final List<Seccao> entities);
	
	/**
	 * Counts the number of Seccao entities.
	 */
	public int countSeccaos();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Seccao merge(Seccao entity);
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(String nome, long numero);
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(String nome, long numero, IAction<Livro> prePersistAction);
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id);
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome);
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros();
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity);
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities);
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Livro merge(Livro entity);
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(int pag, Livro livro);
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(int pag, Livro livro, IAction<Pagina> prePersistAction);
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id);
	
	/**
	 * Returns the Paginas with the given livro.
	 */
	public List<Pagina> getPaginasByLivro(final Livro livro);
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas();
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity);
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities);
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Pagina merge(Pagina entity);
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(String identification, PeticaoDistribuida peticao, Auto auto, Pagina pagina, boolean archived);
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(String identification, PeticaoDistribuida peticao, Auto auto, Pagina pagina, boolean archived, IAction<Processo> prePersistAction);
	
	/**
	 * Returns the Processo with the given id.
	 */
	// This method is deprecated because the entity Processo has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Processo getProcesso(final int id);
	
	/**
	 * Returns the Processo with the given identification.
	 */
	public Processo getProcessoByIdentification(final String identification, final boolean includedArchivedEntities);
	
	/**
	 * Returns the Processos with the given peticao.
	 */
	public List<Processo> getProcessosByPeticao(final PeticaoDistribuida peticao, final boolean includeArchivedEntities);
	
	/**
	 * Returns the Processos with the given auto.
	 */
	public List<Processo> getProcessosByAuto(final Auto auto, final boolean includeArchivedEntities);
	
	/**
	 * Returns the Processos with the given pagina.
	 */
	public List<Processo> getProcessosByPagina(final Pagina pagina, final boolean includeArchivedEntities);
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos(final boolean includeArchivedEntities);
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Processo. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Processo entity);
	
	/**
	 * Deletes all given Processos. This method is deprecated, because Processo is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessos(final List<Processo> entities);
	
	/**
	 * Returns all Processos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Processo> getArchivedProcessos();
	
	/**
	 * Sets the boolean property 'archived' for all Processos to the given value.
	 */
	public void setProcessosArchived(final boolean value, final boolean includeArchivedEntities);
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos(final boolean includeArchivedEntities);
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Processo merge(Processo entity);
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(String identification, PeticaoDistribuida peticao, Auto auto, Pagina pagina, boolean archived);
	
	/**
	 * Creates a new ProcessoAutuado using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public ProcessoAutuado createProcessoAutuado(String identification, PeticaoDistribuida peticao, Auto auto, Pagina pagina, boolean archived, IAction<ProcessoAutuado> prePersistAction);
	
	/**
	 * Returns the ProcessoAutuado with the given id.
	 */
	// This method is deprecated because the entity ProcessoAutuado has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public ProcessoAutuado getProcessoAutuado(final int id);
	
	/**
	 * Returns the ProcessoAutuado with the given identification.
	 */
	public ProcessoAutuado getProcessoAutuadoByIdentification(final String identification, final boolean includedArchivedEntities);
	
	/**
	 * Returns the ProcessoAutuados with the given peticao.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPeticao(final PeticaoDistribuida peticao, final boolean includeArchivedEntities);
	
	/**
	 * Returns the ProcessoAutuados with the given auto.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByAuto(final Auto auto, final boolean includeArchivedEntities);
	
	/**
	 * Returns the ProcessoAutuados with the given pagina.
	 */
	public List<ProcessoAutuado> getProcessoAutuadosByPagina(final Pagina pagina, final boolean includeArchivedEntities);
	
	/**
	 * Returns all entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> getAllProcessoAutuados(final boolean includeArchivedEntities);
	
	/**
	 * Searches for entities of type ProcessoAutuado.
	 */
	public List<ProcessoAutuado> searchProcessoAutuados(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given ProcessoAutuado. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final ProcessoAutuado entity);
	
	/**
	 * Deletes all given ProcessoAutuados. This method is deprecated, because
	 * ProcessoAutuado is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deleteProcessoAutuados(final List<ProcessoAutuado> entities);
	
	/**
	 * Returns all ProcessoAutuados where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<ProcessoAutuado> getArchivedProcessoAutuados();
	
	/**
	 * Sets the boolean property 'archived' for all ProcessoAutuados to the given
	 * value.
	 */
	public void setProcessoAutuadosArchived(final boolean value, final boolean includeArchivedEntities);
	
	/**
	 * Counts the number of ProcessoAutuado entities.
	 */
	public int countProcessoAutuados(final boolean includeArchivedEntities);
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public ProcessoAutuado merge(ProcessoAutuado entity);
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(Date data, String infoRegisto, ProcessoAutuado processoAutuado);
	
	/**
	 * Creates a new Registro using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Registro createRegistro(Date data, String infoRegisto, ProcessoAutuado processoAutuado, IAction<Registro> prePersistAction);
	
	/**
	 * Returns the Registro with the given id.
	 */
	public Registro getRegistro(final int id);
	
	/**
	 * Returns the Registros with the given processoAutuado.
	 */
	public List<Registro> getRegistrosByProcessoAutuado(final ProcessoAutuado processoAutuado);
	
	/**
	 * Returns all Registros where data is set to a value before '_maxDate'.
	 */
	public List<Registro> getRegistrosWithDataBefore(final Date _maxDate);
	
	/**
	 * Returns all Registros where data is set to a value after '_minDate'.
	 */
	public List<Registro> getRegistrosWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type Registro.
	 */
	public List<Registro> getAllRegistros();
	
	/**
	 * Searches for entities of type Registro.
	 */
	public List<Registro> searchRegistros(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Registro.
	 */
	public void delete(final Registro entity);
	
	/**
	 * Deletes all given Registros.
	 */
	public void deleteRegistros(final List<Registro> entities);
	
	/**
	 * Deletes all Registros where data is set to a value before '_maxDate'.
	 */
	public void deleteRegistrosWithDataBefore(final Date _maxDate);
	
	/**
	 * Deletes all Registros where data is set to a value after '_minDate'.
	 */
	public void deleteRegistrosWithDataAfter(final Date _minDate);
	
	/**
	 * Counts the number of Registro entities.
	 */
	public int countRegistros();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Registro merge(Registro entity);
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean archived);
	
	/**
	 * Creates a new Peticao using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Peticao createPeticao(String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean archived, IAction<Peticao> prePersistAction);
	
	/**
	 * Returns the Peticao with the given id.
	 */
	public Peticao getPeticao(final int id);
	
	/**
	 * Returns all Peticaos where data is set to a value before '_maxDate'.
	 */
	public List<Peticao> getPeticaosWithDataBefore(final Date _maxDate);
	
	/**
	 * Returns all Peticaos where data is set to a value after '_minDate'.
	 */
	public List<Peticao> getPeticaosWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type Peticao.
	 */
	public List<Peticao> getAllPeticaos(final boolean includeArchivedEntities);
	
	/**
	 * Searches for entities of type Peticao.
	 */
	public List<Peticao> searchPeticaos(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Peticao. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final Peticao entity);
	
	/**
	 * Deletes all given Peticaos. This method is deprecated, because Peticao is an
	 * archivable entity. Therefore, it should be archived instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaos(final List<Peticao> entities);
	
	/**
	 * Deletes all Peticaos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaosWithDataBefore(final Date _maxDate);
	
	/**
	 * Deletes all Peticaos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaosWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all Peticaos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<Peticao> getArchivedPeticaos();
	
	/**
	 * Sets the boolean property 'archived' for all Peticaos to the given value.
	 */
	public void setPeticaosArchived(final boolean value, final boolean includeArchivedEntities);
	
	/**
	 * Counts the number of Peticao entities.
	 */
	public int countPeticaos(final boolean includeArchivedEntities);
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Peticao merge(Peticao entity);
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(Peticao peticao, Seccao seccao, boolean archived);
	
	/**
	 * Creates a new PeticaoDistribuida using all read-only and all non-null
	 * properties. If the new entity violates uniqueness constraints and a Cache is
	 * used, an java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoDistribuida createPeticaoDistribuida(Peticao peticao, Seccao seccao, boolean archived, IAction<PeticaoDistribuida> prePersistAction);
	
	/**
	 * Returns the PeticaoDistribuida with the given id.
	 */
	public PeticaoDistribuida getPeticaoDistribuida(final int id);
	
	/**
	 * Returns the PeticaoDistribuidas with the given peticao.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasByPeticao(final Peticao peticao, final boolean includeArchivedEntities);
	
	/**
	 * Returns the PeticaoDistribuidas with the given seccao.
	 */
	public List<PeticaoDistribuida> getPeticaoDistribuidasBySeccao(final Seccao seccao, final boolean includeArchivedEntities);
	
	/**
	 * Returns all entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> getAllPeticaoDistribuidas(final boolean includeArchivedEntities);
	
	/**
	 * Searches for entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> searchPeticaoDistribuidas(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given PeticaoDistribuida. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoDistribuida entity);
	
	/**
	 * Deletes all given PeticaoDistribuidas. This method is deprecated, because
	 * PeticaoDistribuida is an archivable entity. Therefore, it should be archived
	 * instead of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoDistribuidas(final List<PeticaoDistribuida> entities);
	
	/**
	 * Returns all PeticaoDistribuidas where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoDistribuida> getArchivedPeticaoDistribuidas();
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoDistribuidas to the given
	 * value.
	 */
	public void setPeticaoDistribuidasArchived(final boolean value, final boolean includeArchivedEntities);
	
	/**
	 * Counts the number of PeticaoDistribuida entities.
	 */
	public int countPeticaoDistribuidas(final boolean includeArchivedEntities);
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public PeticaoDistribuida merge(PeticaoDistribuida entity);
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean archived, Processo processo);
	
	/**
	 * Creates a new PeticaoApenso using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public PeticaoApenso createPeticaoApenso(String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean archived, Processo processo, IAction<PeticaoApenso> prePersistAction);
	
	/**
	 * Returns the PeticaoApenso with the given id.
	 */
	public PeticaoApenso getPeticaoApenso(final int id);
	
	/**
	 * Returns the PeticaoApensos with the given processo.
	 */
	public List<PeticaoApenso> getPeticaoApensosByProcesso(final Processo processo, final boolean includeArchivedEntities);
	
	/**
	 * Returns all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataBefore(final Date _maxDate);
	
	/**
	 * Returns all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public List<PeticaoApenso> getPeticaoApensosWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> getAllPeticaoApensos(final boolean includeArchivedEntities);
	
	/**
	 * Searches for entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> searchPeticaoApensos(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given PeticaoApenso. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void delete(final PeticaoApenso entity);
	
	/**
	 * Deletes all given PeticaoApensos. This method is deprecated, because
	 * PeticaoApenso is an archivable entity. Therefore, it should be archived instead
	 * of deleted.
	 */
	@java.lang.Deprecated
	public void deletePeticaoApensos(final List<PeticaoApenso> entities);
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public void deletePeticaoApensosWithDataBefore(final Date _maxDate);
	
	/**
	 * Deletes all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public void deletePeticaoApensosWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all PeticaoApensos where the boolean property 'archived' is set to
	 * <code>true</code>.
	 */
	public List<PeticaoApenso> getArchivedPeticaoApensos();
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoApensos to the given value.
	 */
	public void setPeticaoApensosArchived(final boolean value, final boolean includeArchivedEntities);
	
	/**
	 * Counts the number of PeticaoApenso entities.
	 */
	public int countPeticaoApensos(final boolean includeArchivedEntities);
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public PeticaoApenso merge(PeticaoApenso entity);
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(String auto);
	
	/**
	 * Creates a new Auto using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Auto createAuto(String auto, IAction<Auto> prePersistAction);
	
	/**
	 * Returns the Auto with the given id.
	 */
	public Auto getAuto(final int id);
	
	/**
	 * Returns all entities of type Auto.
	 */
	public List<Auto> getAllAutos();
	
	/**
	 * Searches for entities of type Auto.
	 */
	public List<Auto> searchAutos(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Auto.
	 */
	public void delete(final Auto entity);
	
	/**
	 * Deletes all given Autos.
	 */
	public void deleteAutos(final List<Auto> entities);
	
	/**
	 * Counts the number of Auto entities.
	 */
	public int countAutos();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Auto merge(Auto entity);
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(Processo processo, String assistenteSocial);
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(Processo processo, String assistenteSocial, IAction<InqueritoSocial> prePersistAction);
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id);
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo);
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials();
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity);
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities);
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public InqueritoSocial merge(InqueritoSocial entity);
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(Date data, String log);
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(Date data, String log, IAction<Log> prePersistAction);
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id);
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate);
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs();
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity);
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities);
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate);
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate);
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Log merge(Log entity);
	
}
