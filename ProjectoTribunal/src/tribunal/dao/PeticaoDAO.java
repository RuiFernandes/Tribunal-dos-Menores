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
import tribunal.entities.Peticao;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Peticao.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class PeticaoDAO {
	
	public final static String FIELD__ID = getField(Peticao.class, "id");
	public final static String FIELD__NUMEROID = getField(Peticao.class, "numeroId");
	public final static String FIELD__DATA = getField(Peticao.class, "data");
	public final static String FIELD__REQUERENTE = getField(Peticao.class, "requerente");
	public final static String FIELD__REQUERIDO = getField(Peticao.class, "requerido");
	public final static String FIELD__RESUMO = getField(Peticao.class, "resumo");
	public final static String FIELD__REMETENTE = getField(Peticao.class, "remetente");
	public final static String FIELD__DIST = getField(Peticao.class, "dist");
	public final static String FIELD__APENSO = getField(Peticao.class, "apenso");
	public final static String FIELD__ARCHIVED = getField(Peticao.class, "archived");
	
	/**
	 * Creates a Peticao using all read-only and all non-null properties.
	 */
	public Peticao create(EntityManager em, String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean dist, String apenso, boolean archived) {
		return create(em, numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived, null);
	}
	
	/**
	 * Creates a Peticao using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Peticao create(EntityManager em, String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean dist, String apenso, boolean archived, IAction<Peticao> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Peticao newEntity = new Peticao(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Peticao with the given id.
	 */
	public Peticao get(EntityManager em, int id) {
		Peticao entity = (Peticao) em.find(Peticao.class, id);
		return entity;
	}
	
	/**
	 * Returns all Peticaos where data is set to a value before '_maxDate'.
	 */
	public List<Peticao> getDataBefore(EntityManager em, Date _maxDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Peticao> _query = _builder.createQuery(Peticao.class);
		Root<Peticao> _root = _query.from(Peticao.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.lessThan(_root.<Date>get(PeticaoDAO.FIELD__DATA), _maxDate);
		_query.where(expression);
		List<Peticao> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Peticaos where data is set to a value after '_minDate'.
	 */
	public List<Peticao> getDataAfter(EntityManager em, Date _minDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Peticao> _query = _builder.createQuery(Peticao.class);
		Root<Peticao> _root = _query.from(Peticao.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.greaterThan(_root.<Date>get(PeticaoDAO.FIELD__DATA), _minDate);
		_query.where(expression);
		List<Peticao> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Peticaos where the boolean property 'dist' is set to 'true'.
	 */
	public List<Peticao> getDist(EntityManager em, final boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Peticao> _query = _builder.createQuery(Peticao.class);
		Root<Peticao> _root = _query.from(Peticao.class);
		_query.select(_root);
		Expression<Boolean> _expression1 = _builder.equal(_root.get(PeticaoDAO.FIELD__DIST), true);
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(PeticaoDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<Peticao> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Sets the boolean property 'dist' for all Peticaos.
	 */
	public void setDist(EntityManager em, boolean value, boolean includeArchivedEntities) {
		List<Peticao> entities = getAll(em, includeArchivedEntities);
		for (Peticao entity : entities) {
			entity.setDist(value);
			em.merge(entity);
		}
	}
	
	/**
	 * Returns all Peticaos where the boolean property 'archived' is set to 'true'.
	 */
	public List<Peticao> getArchived(EntityManager em) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Peticao> _query = _builder.createQuery(Peticao.class);
		Root<Peticao> _root = _query.from(Peticao.class);
		_query.select(_root);
		Expression<Boolean> _expression1 = _builder.equal(_root.get(PeticaoDAO.FIELD__ARCHIVED), true);
		_query.where(_expression1);
		List<Peticao> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all Peticaos.
	 */
	public void setArchived(EntityManager em, boolean value, boolean includeArchivedEntities) {
		List<Peticao> entities = getAll(em, includeArchivedEntities);
		for (Peticao entity : entities) {
			entity.setArchived(value);
			em.merge(entity);
		}
	}
	
	/**
	 * Returns all entities of type Peticao.
	 */
	public List<Peticao> getAll(EntityManager em, boolean includeArchivedEntities) {
		CriteriaQuery<Peticao> _query = buildGetAllQuery(em, includeArchivedEntities);
		List<Peticao> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Peticao.
	 */
	public CriteriaQuery<Peticao> buildGetAllQuery(EntityManager em, boolean includeArchivedEntities) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Peticao> _query = builder.createQuery(Peticao.class);
		Root<Peticao> root = _query.from(Peticao.class);
		_query.select(root);
		if (!includeArchivedEntities) {
			_query.where(builder.equal(root.get(PeticaoDAO.FIELD__ARCHIVED), false));
		}
		return _query;
	}
	
	/**
	 * Searches for entities of type Peticao.
	 */
	public List<Peticao> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Peticao> _query = _builder.createQuery(Peticao.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Peticao> _root = _query.from(Peticao.class);
		Predicate[] _predicates = new Predicate[6];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__NUMEROID), _builder.literal(_trimmedSearchString));
		_predicates[1] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__REQUERENTE), _builder.literal(_trimmedSearchString));
		_predicates[2] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__REQUERIDO), _builder.literal(_trimmedSearchString));
		_predicates[3] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__RESUMO), _builder.literal(_trimmedSearchString));
		_predicates[4] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__REMETENTE), _builder.literal(_trimmedSearchString));
		_predicates[5] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__APENSO), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Peticao> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Peticao.
	 */
	public void delete(EntityManager em, Peticao entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Peticao> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Peticao entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Peticao.class.getName() + " WHERE " + PeticaoDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Peticao entities.
	 */
	public int count(EntityManager em, boolean includeArchivedEntities) {
		String query = "select count(p) from Peticao as p";
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

