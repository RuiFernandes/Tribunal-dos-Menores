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
import tribunal.entities.PeticaoApenso;
import tribunal.entities.Processo;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type PeticaoApenso.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class PeticaoApensoDAO {
	
	public final static String FIELD__PROCESSO = getField(PeticaoApenso.class, "processo");
	
	/**
	 * Creates a PeticaoApenso using all read-only and all non-null properties.
	 */
	public PeticaoApenso create(EntityManager em, String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean archived, Processo processo) {
		return create(em, numeroId, data, requerente, requerido, resumo, remetente, archived, processo, null);
	}
	
	/**
	 * Creates a PeticaoApenso using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public PeticaoApenso create(EntityManager em, String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean archived, Processo processo, IAction<PeticaoApenso> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		PeticaoApenso newEntity = new PeticaoApenso(numeroId, data, requerente, requerido, resumo, remetente, archived, processo);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the PeticaoApenso with the given id.
	 */
	public PeticaoApenso get(EntityManager em, int id) {
		PeticaoApenso entity = (PeticaoApenso) em.find(PeticaoApenso.class, id);
		return entity;
	}
	
	/**
	 * Returns the PeticaoApensos with the given processo.
	 */
	public List<PeticaoApenso> getByProcesso(EntityManager em, Processo processo, boolean includeArchivedEntities) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoApenso> _query = _builder.createQuery(PeticaoApenso.class);
		Root<PeticaoApenso> _root = _query.from(PeticaoApenso.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (processo == null) {
			_expression1 = _builder.isNull(_root.get(PeticaoApensoDAO.FIELD__PROCESSO));
		} else {
			_expression1 = _builder.equal(_root.get(PeticaoApensoDAO.FIELD__PROCESSO), processo);
		}
		if (includeArchivedEntities) {
			_query.where(_expression1);
		} else {
			Expression<Boolean> _expression2 = _builder.equal(_root.get(PeticaoDAO.FIELD__ARCHIVED), false);
			_query.where(_builder.and(_expression1, _expression2));
		}
		List<PeticaoApenso> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value before '_maxDate'.
	 */
	public List<PeticaoApenso> getDataBefore(EntityManager em, Date _maxDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoApenso> _query = _builder.createQuery(PeticaoApenso.class);
		Root<PeticaoApenso> _root = _query.from(PeticaoApenso.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.lessThan(_root.<Date>get(PeticaoDAO.FIELD__DATA), _maxDate);
		_query.where(expression);
		List<PeticaoApenso> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where data is set to a value after '_minDate'.
	 */
	public List<PeticaoApenso> getDataAfter(EntityManager em, Date _minDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoApenso> _query = _builder.createQuery(PeticaoApenso.class);
		Root<PeticaoApenso> _root = _query.from(PeticaoApenso.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.greaterThan(_root.<Date>get(PeticaoDAO.FIELD__DATA), _minDate);
		_query.where(expression);
		List<PeticaoApenso> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all PeticaoApensos where the boolean property 'archived' is set to
	 * 'true'.
	 */
	public List<PeticaoApenso> getArchived(EntityManager em) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoApenso> _query = _builder.createQuery(PeticaoApenso.class);
		Root<PeticaoApenso> _root = _query.from(PeticaoApenso.class);
		_query.select(_root);
		Expression<Boolean> _expression1 = _builder.equal(_root.get(PeticaoDAO.FIELD__ARCHIVED), true);
		_query.where(_expression1);
		List<PeticaoApenso> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Sets the boolean property 'archived' for all PeticaoApensos.
	 */
	public void setArchived(EntityManager em, boolean value, boolean includeArchivedEntities) {
		List<PeticaoApenso> entities = getAll(em, includeArchivedEntities);
		for (PeticaoApenso entity : entities) {
			entity.setArchived(value);
			em.merge(entity);
		}
	}
	
	/**
	 * Returns all entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> getAll(EntityManager em, boolean includeArchivedEntities) {
		CriteriaQuery<PeticaoApenso> _query = buildGetAllQuery(em, includeArchivedEntities);
		List<PeticaoApenso> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type PeticaoApenso.
	 */
	public CriteriaQuery<PeticaoApenso> buildGetAllQuery(EntityManager em, boolean includeArchivedEntities) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<PeticaoApenso> _query = builder.createQuery(PeticaoApenso.class);
		Root<PeticaoApenso> root = _query.from(PeticaoApenso.class);
		_query.select(root);
		if (!includeArchivedEntities) {
			_query.where(builder.equal(root.get(PeticaoDAO.FIELD__ARCHIVED), false));
		}
		return _query;
	}
	
	/**
	 * Searches for entities of type PeticaoApenso.
	 */
	public List<PeticaoApenso> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<PeticaoApenso> _query = _builder.createQuery(PeticaoApenso.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<PeticaoApenso> _root = _query.from(PeticaoApenso.class);
		Predicate[] _predicates = new Predicate[5];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__NUMEROID), _builder.literal(_trimmedSearchString));
		_predicates[1] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__REQUERENTE), _builder.literal(_trimmedSearchString));
		_predicates[2] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__REQUERIDO), _builder.literal(_trimmedSearchString));
		_predicates[3] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__RESUMO), _builder.literal(_trimmedSearchString));
		_predicates[4] = _builder.like(_root.<java.lang.String>get(PeticaoDAO.FIELD__REMETENTE), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<PeticaoApenso> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a PeticaoApenso.
	 */
	public void delete(EntityManager em, PeticaoApenso entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<PeticaoApenso> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (PeticaoApenso entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + PeticaoApenso.class.getName() + " WHERE " + PeticaoDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of PeticaoApenso entities.
	 */
	public int count(EntityManager em, boolean includeArchivedEntities) {
		String query = "select count(p) from PeticaoApenso as p";
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

