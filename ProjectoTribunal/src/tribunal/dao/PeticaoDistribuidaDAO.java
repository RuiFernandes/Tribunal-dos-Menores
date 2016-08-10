package tribunal.dao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import tribunal.entities.Peticao;
import tribunal.entities.PeticaoDistribuida;
import tribunal.entities.Seccao;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type PeticaoDistribuida.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class PeticaoDistribuidaDAO {
	
	public final static String FIELD__ID = getField(PeticaoDistribuida.class, "id");
	public final static String FIELD__PETICAO = getField(PeticaoDistribuida.class, "peticao");
	public final static String FIELD__SECCAO = getField(PeticaoDistribuida.class, "seccao");
	public final static String FIELD__ARCHIVED = getField(PeticaoDistribuida.class, "archived");
	
	/**
	 * Creates a PeticaoDistribuida using all read-only and all non-null properties.
	 */
	public PeticaoDistribuida create(EntityManager em, Peticao peticao, Seccao seccao, boolean archived) {
		return create(em, peticao, seccao, archived, null);
	}
	
	/**
	 * Creates a PeticaoDistribuida using all read-only and all non-null properties.
	 * The per-persist action is executed before the entity is persisted and allows to
	 * set properties which are not read-only or nullable.
	 */
	public PeticaoDistribuida create(EntityManager em, Peticao peticao, Seccao seccao, boolean archived, IAction<PeticaoDistribuida> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		PeticaoDistribuida newEntity = new PeticaoDistribuida(peticao, seccao, archived);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the PeticaoDistribuida with the given id.
	 */
	public PeticaoDistribuida get(EntityManager em, int id) {
		PeticaoDistribuida entity = (PeticaoDistribuida) em.find(PeticaoDistribuida.class, id);
		return entity;
	}
	
	/**
	 * Returns the PeticaoDistribuidas with the given peticao.
	 */
	public List<PeticaoDistribuida> getByPeticao(EntityManager em, Peticao peticao, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoDistribuida> _query = _builder.createQuery(PeticaoDistribuida.class);
		Root<PeticaoDistribuida> _root = _query.from(PeticaoDistribuida.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (peticao == null) {
			_expression1 = _builder.isNull(_root.get(PeticaoDistribuidaDAO.FIELD__PETICAO));
		} else {
			_expression1 = _builder.equal(_root.get(PeticaoDistribuidaDAO.FIELD__PETICAO), peticao);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(PeticaoDistribuidaDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<PeticaoDistribuida> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns the PeticaoDistribuidas with the given seccao.
	 */
	public List<PeticaoDistribuida> getBySeccao(EntityManager em, Seccao seccao, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoDistribuida> _query = _builder.createQuery(PeticaoDistribuida.class);
		Root<PeticaoDistribuida> _root = _query.from(PeticaoDistribuida.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (seccao == null) {
			_expression1 = _builder.isNull(_root.get(PeticaoDistribuidaDAO.FIELD__SECCAO));
		} else {
			_expression1 = _builder.equal(_root.get(PeticaoDistribuidaDAO.FIELD__SECCAO), seccao);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(PeticaoDistribuidaDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<PeticaoDistribuida> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all PeticaoDistribuidas where the boolean property 'archived' is set to
	 * 'true'.
	 */
	public List<PeticaoDistribuida> getArchived(EntityManager em) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoDistribuida> _query = _builder.createQuery(PeticaoDistribuida.class);
		Root<PeticaoDistribuida> _root = _query.from(PeticaoDistribuida.class);
		_query.select(_root);
		Expression<Boolean> _expression1 = _builder.equal(_root.get(PeticaoDistribuidaDAO.FIELD__ARCHIVED), true);
		_query.where(_expression1);
		List<PeticaoDistribuida> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoDistribuidas.
	 */
	public void setArchived(EntityManager em, boolean value, boolean includeArchivedEntities) {
		List<PeticaoDistribuida> entities = getAll(em, includeArchivedEntities);
		for (PeticaoDistribuida entity : entities) {
			entity.setArchived(value);
			em.merge(entity);
		}
	}
	
	/**
	 * Returns all entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> getAll(EntityManager em, boolean includeArchivedEntities) {
		CriteriaQuery<PeticaoDistribuida> _query = buildGetAllQuery(em, includeArchivedEntities);
		List<PeticaoDistribuida> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type PeticaoDistribuida.
	 */
	public CriteriaQuery<PeticaoDistribuida> buildGetAllQuery(EntityManager em, boolean includeArchivedEntities) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoDistribuida> _query = builder.createQuery(PeticaoDistribuida.class);
		Root<PeticaoDistribuida> root = _query.from(PeticaoDistribuida.class);
		_query.select(root);
		if (!includeArchivedEntities) {
			_query.where(builder.equal(root.get(PeticaoDistribuidaDAO.FIELD__ARCHIVED), false));
		}
		return _query;
	}
	
	/**
	 * Searches for entities of type PeticaoDistribuida.
	 */
	public List<PeticaoDistribuida> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<PeticaoDistribuida> _query = _builder.createQuery(PeticaoDistribuida.class);
		// Return all entities as there are no string properties we could search in.
		List<PeticaoDistribuida> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a PeticaoDistribuida.
	 */
	public void delete(EntityManager em, PeticaoDistribuida entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<PeticaoDistribuida> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (PeticaoDistribuida entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + PeticaoDistribuida.class.getName() + " WHERE " + PeticaoDistribuidaDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of PeticaoDistribuida entities.
	 */
	public int count(EntityManager em, boolean includeArchivedEntities) {
		String query = "select count(p) from PeticaoDistribuida as p";
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

