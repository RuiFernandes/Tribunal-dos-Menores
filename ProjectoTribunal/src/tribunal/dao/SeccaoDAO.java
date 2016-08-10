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
import tribunal.entities.Seccao;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Seccao.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class SeccaoDAO {
	
	public final static String FIELD__ID = getField(Seccao.class, "id");
	public final static String FIELD__NOME = getField(Seccao.class, "nome");
	
	/**
	 * Creates a Seccao using all read-only and all non-null properties.
	 */
	public Seccao create(EntityManager em, String nome) {
		return create(em, nome, null);
	}
	
	/**
	 * Creates a Seccao using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Seccao create(EntityManager em, String nome, IAction<Seccao> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Seccao newEntity = new Seccao(nome);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Seccao with the given id.
	 */
	public Seccao get(EntityManager em, int id) {
		Seccao entity = (Seccao) em.find(Seccao.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Seccao.
	 */
	public List<Seccao> getAll(EntityManager em) {
		CriteriaQuery<Seccao> _query = buildGetAllQuery(em);
		List<Seccao> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Seccao.
	 */
	public CriteriaQuery<Seccao> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Seccao> _query = builder.createQuery(Seccao.class);
		Root<Seccao> root = _query.from(Seccao.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Seccao.
	 */
	public List<Seccao> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Seccao> _query = _builder.createQuery(Seccao.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Seccao> _root = _query.from(Seccao.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(SeccaoDAO.FIELD__NOME), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Seccao> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Seccao.
	 */
	public void delete(EntityManager em, Seccao entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Seccao> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Seccao entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Seccao.class.getName() + " WHERE " + SeccaoDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Seccao entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(s) from Seccao as s";
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

