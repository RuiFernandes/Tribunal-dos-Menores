package tribunal.dao;

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
import tribunal.entities.Auto;
import tribunal.entities.Pagina;
import tribunal.entities.PeticaoDistribuida;
import tribunal.entities.Processo;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Processo.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class ProcessoDAO {
	
	public final static String FIELD__ID = getField(Processo.class, "id");
	public final static String FIELD__IDENTIFICATION = getField(Processo.class, "identification");
	public final static String FIELD__PETICAO = getField(Processo.class, "peticao");
	public final static String FIELD__AUTO = getField(Processo.class, "auto");
	public final static String FIELD__PAGINA = getField(Processo.class, "pagina");
	public final static String FIELD__ARCHIVED = getField(Processo.class, "archived");
	
	/**
	 * Creates a Processo using all read-only and all non-null properties.
	 */
	public Processo create(EntityManager em, String identification, PeticaoDistribuida peticao, Auto auto, Pagina pagina, boolean archived) {
		return create(em, identification, peticao, auto, pagina, archived, null);
	}
	
	/**
	 * Creates a Processo using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Processo create(EntityManager em, String identification, PeticaoDistribuida peticao, Auto auto, Pagina pagina, boolean archived, IAction<Processo> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Processo newEntity = new Processo(identification, peticao, auto, pagina, archived);
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
	 * Returns the Processo with the given id.
	 */
	public Processo get(EntityManager em, int id) {
		Processo entity = (Processo) em.find(Processo.class, id);
		return entity;
	}
	
	/**
	 * Returns the Processo with the given identification.
	 */
	public Processo getByIdentification(EntityManager _em, String identification, boolean includedArchivedEntities) {
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (identification == null) {
			_expression1 = _builder.isNull(_root.get(ProcessoDAO.FIELD__IDENTIFICATION));
		} else {
			_expression1 = _builder.equal(_root.get(ProcessoDAO.FIELD__IDENTIFICATION), identification);
		}
		if (includedArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(ProcessoDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Processo> _entities = _em.createQuery(_query).getResultList();
		if (_entities != null && !_entities.isEmpty()) {
			return _entities.get(0);
		}
		return null;
	}
	
	/**
	 * Returns the Processos with the given peticao.
	 */
	public List<Processo> getByPeticao(EntityManager em, PeticaoDistribuida peticao, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (peticao == null) {
			_expression1 = _builder.isNull(_root.get(ProcessoDAO.FIELD__PETICAO));
		} else {
			_expression1 = _builder.equal(_root.get(ProcessoDAO.FIELD__PETICAO), peticao);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(ProcessoDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns the Processos with the given auto.
	 */
	public List<Processo> getByAuto(EntityManager em, Auto auto, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (auto == null) {
			_expression1 = _builder.isNull(_root.get(ProcessoDAO.FIELD__AUTO));
		} else {
			_expression1 = _builder.equal(_root.get(ProcessoDAO.FIELD__AUTO), auto);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(ProcessoDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns the Processos with the given pagina.
	 */
	public List<Processo> getByPagina(EntityManager em, Pagina pagina, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (pagina == null) {
			_expression1 = _builder.isNull(_root.get(ProcessoDAO.FIELD__PAGINA));
		} else {
			_expression1 = _builder.equal(_root.get(ProcessoDAO.FIELD__PAGINA), pagina);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(ProcessoDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Processos where the boolean property 'archived' is set to 'true'.
	 */
	public List<Processo> getArchived(EntityManager em) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> _expression1 = _builder.equal(_root.get(ProcessoDAO.FIELD__ARCHIVED), true);
		_query.where(_expression1);
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Processos.
	 */
	public void setArchived(EntityManager em, boolean value, boolean includeArchivedEntities) {
		List<Processo> entities = getAll(em, includeArchivedEntities);
		for (Processo entity : entities) {
			entity.setArchived(value);
			em.merge(entity);
		}
	}
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAll(EntityManager em, boolean includeArchivedEntities) {
		CriteriaQuery<Processo> _query = buildGetAllQuery(em, includeArchivedEntities);
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Processo.
	 */
	public CriteriaQuery<Processo> buildGetAllQuery(EntityManager em, boolean includeArchivedEntities) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = builder.createQuery(Processo.class);
		Root<Processo> root = _query.from(Processo.class);
		_query.select(root);
		if (!includeArchivedEntities) {
			_query.where(builder.equal(root.get(ProcessoDAO.FIELD__ARCHIVED), false));
		}
		return _query;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Processo> _root = _query.from(Processo.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(ProcessoDAO.FIELD__IDENTIFICATION), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Processo> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Processo.
	 */
	public void delete(EntityManager em, Processo entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Processo> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Processo entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Processo.class.getName() + " WHERE " + ProcessoDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int count(EntityManager em, boolean includeArchivedEntities) {
		String query = "select count(p) from Processo as p";
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

