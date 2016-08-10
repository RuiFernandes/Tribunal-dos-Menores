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
import tribunal.entities.Categoria;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Categoria.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class CategoriaDAO {
	
	public final static String FIELD__ID = getField(Categoria.class, "id");
	public final static String FIELD__NOME = getField(Categoria.class, "nome");
	
	/**
	 * Creates a Categoria using all read-only and all non-null properties.
	 */
	public Categoria create(EntityManager em, String nome) {
		return create(em, nome, null);
	}
	
	/**
	 * Creates a Categoria using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Categoria create(EntityManager em, String nome, IAction<Categoria> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Categoria newEntity = new Categoria(nome);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Categoria with the given id.
	 */
	public Categoria get(EntityManager em, int id) {
		Categoria entity = (Categoria) em.find(Categoria.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Categoria.
	 */
	public List<Categoria> getAll(EntityManager em) {
		CriteriaQuery<Categoria> _query = buildGetAllQuery(em);
		List<Categoria> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Categoria.
	 */
	public CriteriaQuery<Categoria> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Categoria> _query = builder.createQuery(Categoria.class);
		Root<Categoria> root = _query.from(Categoria.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Categoria.
	 */
	public List<Categoria> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Categoria> _query = _builder.createQuery(Categoria.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Categoria> _root = _query.from(Categoria.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(CategoriaDAO.FIELD__NOME), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Categoria> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Categoria.
	 */
	public void delete(EntityManager em, Categoria entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Categoria> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Categoria entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Categoria.class.getName() + " WHERE " + CategoriaDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Categoria entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(c) from Categoria as c";
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

