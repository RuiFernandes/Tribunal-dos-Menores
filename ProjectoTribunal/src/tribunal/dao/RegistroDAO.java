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
import tribunal.entities.ProcessoAutuado;
import tribunal.entities.Registro;
import tribunal.entities.Usuario;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Registro.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class RegistroDAO {
	
	public final static String FIELD__ID = getField(Registro.class, "id");
	public final static String FIELD__DATA = getField(Registro.class, "data");
	public final static String FIELD__INFOREGISTO = getField(Registro.class, "infoRegisto");
	public final static String FIELD__PROCESSOAUTUADO = getField(Registro.class, "processoAutuado");
	public final static String FIELD__USER = getField(Registro.class, "user");
	
	/**
	 * Creates a Registro using all read-only and all non-null properties.
	 */
	public Registro create(EntityManager em, Date data, String infoRegisto, ProcessoAutuado processoAutuado, Usuario user) {
		return create(em, data, infoRegisto, processoAutuado, user, null);
	}
	
	/**
	 * Creates a Registro using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Registro create(EntityManager em, Date data, String infoRegisto, ProcessoAutuado processoAutuado, Usuario user, IAction<Registro> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Registro newEntity = new Registro(data, infoRegisto, processoAutuado, user);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Registro with the given id.
	 */
	public Registro get(EntityManager em, int id) {
		Registro entity = (Registro) em.find(Registro.class, id);
		return entity;
	}
	
	/**
	 * Returns the Registros with the given processoAutuado.
	 */
	public List<Registro> getByProcessoAutuado(EntityManager em, ProcessoAutuado processoAutuado) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Registro> _query = _builder.createQuery(Registro.class);
		Root<Registro> _root = _query.from(Registro.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (processoAutuado == null) {
			_expression1 = _builder.isNull(_root.get(RegistroDAO.FIELD__PROCESSOAUTUADO));
		} else {
			_expression1 = _builder.equal(_root.get(RegistroDAO.FIELD__PROCESSOAUTUADO), processoAutuado);
		}
		_query.where(_expression1);
		List<Registro> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns the Registros with the given user.
	 */
	public List<Registro> getByUser(EntityManager em, Usuario user) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Registro> _query = _builder.createQuery(Registro.class);
		Root<Registro> _root = _query.from(Registro.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (user == null) {
			_expression1 = _builder.isNull(_root.get(RegistroDAO.FIELD__USER));
		} else {
			_expression1 = _builder.equal(_root.get(RegistroDAO.FIELD__USER), user);
		}
		_query.where(_expression1);
		List<Registro> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Registros where data is set to a value before '_maxDate'.
	 */
	public List<Registro> getDataBefore(EntityManager em, Date _maxDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Registro> _query = _builder.createQuery(Registro.class);
		Root<Registro> _root = _query.from(Registro.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.lessThan(_root.<Date>get(RegistroDAO.FIELD__DATA), _maxDate);
		_query.where(expression);
		List<Registro> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Registros where data is set to a value after '_minDate'.
	 */
	public List<Registro> getDataAfter(EntityManager em, Date _minDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Registro> _query = _builder.createQuery(Registro.class);
		Root<Registro> _root = _query.from(Registro.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.greaterThan(_root.<Date>get(RegistroDAO.FIELD__DATA), _minDate);
		_query.where(expression);
		List<Registro> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all entities of type Registro.
	 */
	public List<Registro> getAll(EntityManager em) {
		CriteriaQuery<Registro> _query = buildGetAllQuery(em);
		List<Registro> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Registro.
	 */
	public CriteriaQuery<Registro> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Registro> _query = builder.createQuery(Registro.class);
		Root<Registro> root = _query.from(Registro.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Registro.
	 */
	public List<Registro> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Registro> _query = _builder.createQuery(Registro.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Registro> _root = _query.from(Registro.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(RegistroDAO.FIELD__INFOREGISTO), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Registro> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Registro.
	 */
	public void delete(EntityManager em, Registro entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Registro> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Registro entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Registro.class.getName() + " WHERE " + RegistroDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Registro entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(r) from Registro as r";
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

