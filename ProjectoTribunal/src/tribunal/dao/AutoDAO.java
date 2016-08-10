package tribunal.dao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tribunal.entities.Auto;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Auto.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class AutoDAO {
	
	public final static String FIELD__ID = getField(Auto.class, "id");
	public final static String FIELD__AUTO = getField(Auto.class, "auto");
	
	/**
	 * Creates a Auto using all read-only and all non-null properties.
	 */
	public Auto create(EntityManager em, String auto) {
		return create(em, auto, null);
	}
	
	/**
	 * Creates a Auto using all read-only and all non-null properties. The per-persist
	 * action is executed before the entity is persisted and allows to set properties
	 * which are not read-only or nullable.
	 */
	public Auto create(EntityManager em, String auto, IAction<Auto> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Auto newEntity = new Auto(auto);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Auto with the given id.
	 */
	public Auto get(EntityManager em, int id) {
		Auto entity = (Auto) em.find(Auto.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Auto.
	 */
	public List<Auto> getAll(EntityManager em) {
		CriteriaQuery<Auto> _query = buildGetAllQuery(em);
		List<Auto> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Auto.
	 */
	public CriteriaQuery<Auto> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Auto> _query = builder.createQuery(Auto.class);
		Root<Auto> root = _query.from(Auto.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Auto.
	 */
	public List<Auto> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Auto> _query = _builder.createQuery(Auto.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Auto> _root = _query.from(Auto.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(AutoDAO.FIELD__AUTO), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Auto> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Auto.
	 */
	public void delete(EntityManager em, Auto entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Auto> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Auto entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Auto.class.getName() + " WHERE " + AutoDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Auto entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(a) from Auto as a";
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

