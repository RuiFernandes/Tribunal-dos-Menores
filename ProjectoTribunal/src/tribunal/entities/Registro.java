package tribunal.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "registro")
/*
 * This class is generated from the entity 'Registro' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Registro implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "inforegisto", nullable = false)
	private String infoRegisto;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "processoautuado", nullable = false)
	private ProcessoAutuado processoAutuado;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "user", nullable = false)
	private Usuario user;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public Registro() {
		super();
	}
	
	/**
	 * <p>
	 * Constructor using all read-only and all non-nullable properties.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used
	 * directly. Rather, the respective create() method must be used instead.
	 * </p>
	 */
	@java.lang.Deprecated
	public Registro(Date data, String infoRegisto, ProcessoAutuado processoAutuado, Usuario user) {
		super();
		if (data == null) {
			throw new java.lang.IllegalArgumentException("'data' must not be null.");
		}
		if (infoRegisto == null) {
			throw new java.lang.IllegalArgumentException("'infoRegisto' must not be null.");
		}
		if (processoAutuado == null) {
			throw new java.lang.IllegalArgumentException("'processoAutuado' must not be null.");
		}
		if (user == null) {
			throw new java.lang.IllegalArgumentException("'user' must not be null.");
		}
		this.data = data;
		this.infoRegisto = infoRegisto;
		this.processoAutuado = processoAutuado;
		this.user = user;
	}
	
	/**
	 * Returns the automatically generated id that identifies this entity object.
	 */
	@java.lang.Override
	public int getId() {
		return id;
	}
	
	/**
	 * <p>
	 * The property 'id' is read-only.
	 * </p>
	 * <p>
	 * This setter is only provided for the JPA provider.
	 * </p>
	 * <p>
	 * It must not be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value of property {@link #data}.
	 */
	public Date getData() {
		return data == null ? null : new Date(data.getTime());
	}
	
	/**
	 * Sets the value of property {@link #data}.
	 */
	public void setData(Date newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'data' must not be null.");
		}
		this.data = new Date(newValue.getTime());
	}
	
	/**
	 * Returns the value of property {@link #infoRegisto}.
	 */
	public String getInfoRegisto() {
		return infoRegisto;
	}
	
	/**
	 * Sets the value of property {@link #infoRegisto}.
	 */
	public void setInfoRegisto(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'infoRegisto' must not be null.");
		}
		this.infoRegisto = newValue;
	}
	
	/**
	 * Returns the value of property {@link #processoAutuado}. This method does not
	 * return archived entities. This method is marked as deprecated, because it does
	 * not return archived entities. Please use {@link #getProcessoAutuado(boolean)}
	 * instead.
	 */
	@java.lang.Deprecated
	public ProcessoAutuado getProcessoAutuado() {
		return getProcessoAutuado(false);
	}
	
	/**
	 * Returns the value of property {@link #processoAutuado}. This method is marked
	 * as deprecated, because it does not return archived entities. Please use {@link
	 * #getProcessoAutuado(boolean)} instead.
	 */
	public ProcessoAutuado getProcessoAutuado(boolean includeArchivedEntities) {
		if (includeArchivedEntities) {
			return processoAutuado;
		} else {
			if (processoAutuado == null) {
				return processoAutuado;
			}
			if (!processoAutuado.isArchived() || includeArchivedEntities) {
				return processoAutuado;
			}
			return null;
		}
	}
	
	/**
	 * Sets the value of property {@link #processoAutuado}.
	 */
	public void setProcessoAutuado(ProcessoAutuado newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'processoAutuado' must not be null.");
		}
		this.processoAutuado = newValue;
	}
	
	/**
	 * Returns the value of property {@link #user}. This method does not return
	 * archived entities. This method is marked as deprecated, because it does not
	 * return archived entities. Please use {@link #getUser(boolean)} instead.
	 */
	@java.lang.Deprecated
	public Usuario getUser() {
		return getUser(false);
	}
	
	/**
	 * Returns the value of property {@link #user}. This method is marked as
	 * deprecated, because it does not return archived entities. Please use {@link
	 * #getUser(boolean)} instead.
	 */
	public Usuario getUser(boolean includeArchivedEntities) {
		if (includeArchivedEntities) {
			return user;
		} else {
			if (user == null) {
				return user;
			}
			if (!user.isArchived() || includeArchivedEntities) {
				return user;
			}
			return null;
		}
	}
	
	/**
	 * Sets the value of property {@link #user}.
	 */
	public void setUser(Usuario newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'user' must not be null.");
		}
		this.user = newValue;
	}
	
	@java.lang.Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + getId();
		return result;
	}
	
	@java.lang.Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Registro)) {
			return false;
		}
		Registro other = (Registro) obj;
		int thisId = getId();
		int otherId = other.getId();
		// this can happen if both intIdentifiables are created in the current database
		// transaction
		if (thisId == 0 && otherId == 0) {
			return this == other;
		}
		if (thisId != otherId) {
			return false;
		}
		return true;
	}
	
	@java.lang.Override
	public java.lang.String toString() {
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		result.append("Registro-");
		result.append(getId());
		result.append(" [");
		result.append("data = ");
		result.append(getData());
		result.append(", ");
		result.append("infoRegisto = ");
		result.append(getInfoRegisto());
		result.append("]");
		return result.toString();
	}
	
}
