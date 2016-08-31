package tribunal.dao;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tribunal.entities.Categoria;
import tribunal.entities.Seccao;
import tribunal.entities.Usuario;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Usuario.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class UsuarioDAO {
	
	public final static String FIELD__ID = getField(Usuario.class, "id");
	public final static String FIELD__NOME = getField(Usuario.class, "nome");
	public final static String FIELD__DATADENASCIMENTO = getField(Usuario.class, "dataDeNascimento");
	public final static String FIELD__USERNAME = getField(Usuario.class, "username");
	public final static String FIELD__PASSWORD = getField(Usuario.class, "password");
	public final static String FIELD__CATEGORIA = getField(Usuario.class, "categoria");
	public final static String FIELD__SECCAO = getField(Usuario.class, "seccao");
	public final static String FIELD__ARCHIVED = getField(Usuario.class, "archived");
	
	/**
	 * Creates a Usuario using all read-only and all non-null properties.
	 */
	public Usuario create(EntityManager em, String nome, Date dataDeNascimento, String username, String password, Categoria categoria, Seccao seccao, boolean archived) {
		return create(em, nome, dataDeNascimento, username, password, categoria, seccao, archived, null);
	}
	
	/**
	 * Creates a Usuario using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Usuario create(EntityManager em, String nome, Date dataDeNascimento, String username, String password, Categoria categoria, Seccao seccao, boolean archived, IAction<Usuario> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Usuario newEntity = new Usuario(nome, dataDeNascimento, username, password, categoria, seccao, archived);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Usuario with the given id.
	 */
	public Usuario get(EntityManager em, int id) {
		Usuario entity = (Usuario) em.find(Usuario.class, id);
		return entity;
	}
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getByUsername(EntityManager _em, String username, boolean includedArchivedEntities) {
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = _builder.createQuery(Usuario.class);
		Root<Usuario> _root = _query.from(Usuario.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (username == null) {
			_expression1 = _builder.isNull(_root.get(UsuarioDAO.FIELD__USERNAME));
		} else {
			_expression1 = _builder.equal(_root.get(UsuarioDAO.FIELD__USERNAME), username);
		}
		if (includedArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(UsuarioDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Usuario> _entities = _em.createQuery(_query).getResultList();
		if (_entities != null && !_entities.isEmpty()) {
			return _entities.get(0);
		}
		return null;
	}
	
	/**
	 * Returns the Usuarios with the given categoria.
	 */
	public List<Usuario> getByCategoria(EntityManager em, Categoria categoria, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = _builder.createQuery(Usuario.class);
		Root<Usuario> _root = _query.from(Usuario.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (categoria == null) {
			_expression1 = _builder.isNull(_root.get(UsuarioDAO.FIELD__CATEGORIA));
		} else {
			_expression1 = _builder.equal(_root.get(UsuarioDAO.FIELD__CATEGORIA), categoria);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(UsuarioDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Usuario> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns the Usuarios with the given seccao.
	 */
	public List<Usuario> getBySeccao(EntityManager em, Seccao seccao, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = _builder.createQuery(Usuario.class);
		Root<Usuario> _root = _query.from(Usuario.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (seccao == null) {
			_expression1 = _builder.isNull(_root.get(UsuarioDAO.FIELD__SECCAO));
		} else {
			_expression1 = _builder.equal(_root.get(UsuarioDAO.FIELD__SECCAO), seccao);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(UsuarioDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Usuario> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getDataDeNascimentoBefore(EntityManager em, Date _maxDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = _builder.createQuery(Usuario.class);
		Root<Usuario> _root = _query.from(Usuario.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.lessThan(_root.<Date>get(UsuarioDAO.FIELD__DATADENASCIMENTO), _maxDate);
		_query.where(expression);
		List<Usuario> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getDataDeNascimentoAfter(EntityManager em, Date _minDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = _builder.createQuery(Usuario.class);
		Root<Usuario> _root = _query.from(Usuario.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.greaterThan(_root.<Date>get(UsuarioDAO.FIELD__DATADENASCIMENTO), _minDate);
		_query.where(expression);
		List<Usuario> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Usuarios where the boolean property 'archived' is set to 'true'.
	 */
	public List<Usuario> getArchived(EntityManager em) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = _builder.createQuery(Usuario.class);
		Root<Usuario> _root = _query.from(Usuario.class);
		_query.select(_root);
		Expression<Boolean> _expression1 = _builder.equal(_root.get(UsuarioDAO.FIELD__ARCHIVED), true);
		_query.where(_expression1);
		List<Usuario> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Usuarios.
	 */
	public void setArchived(EntityManager em, boolean value, boolean includeArchivedEntities) {
		List<Usuario> entities = getAll(em, includeArchivedEntities);
		for (Usuario entity : entities) {
			entity.setArchived(value);
			em.merge(entity);
		}
	}
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAll(EntityManager em, boolean includeArchivedEntities) {
		CriteriaQuery<Usuario> _query = buildGetAllQuery(em, includeArchivedEntities);
		List<Usuario> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Usuario.
	 */
	public CriteriaQuery<Usuario> buildGetAllQuery(EntityManager em, boolean includeArchivedEntities) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = builder.createQuery(Usuario.class);
		Root<Usuario> root = _query.from(Usuario.class);
		_query.select(root);
		if (!includeArchivedEntities) {
			_query.where(builder.equal(root.get(UsuarioDAO.FIELD__ARCHIVED), false));
		}
		return _query;
	}
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Usuario> _query = _builder.createQuery(Usuario.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Usuario> _root = _query.from(Usuario.class);
		Predicate[] _predicates = new Predicate[3];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(UsuarioDAO.FIELD__NOME), _builder.literal(_trimmedSearchString));
		_predicates[1] = _builder.like(_root.<java.lang.String>get(UsuarioDAO.FIELD__USERNAME), _builder.literal(_trimmedSearchString));
		_predicates[2] = _builder.like(_root.<java.lang.String>get(UsuarioDAO.FIELD__PASSWORD), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Usuario> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Usuario.
	 */
	public void delete(EntityManager em, Usuario entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Usuario> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Usuario entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Usuario.class.getName() + " WHERE " + UsuarioDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int count(EntityManager em, boolean includeArchivedEntities) {
		String query = "select count(u) from Usuario as u";
		if (!includeArchivedEntities) {
			query += " where archived = 0";
		}
		Object first = em.createQuery(query).getResultList().get(0);
		if (first instanceof Long) {
			return ((Long) first).intValue();
		}
		throw new RuntimeException("Unexpected result for count query: " + first);
	}
	
	protected static String getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName).getName();
		} catch (SecurityException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
}

