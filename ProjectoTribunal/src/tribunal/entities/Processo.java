package tribunal.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import tribunal.dao.TribunalListenerRegistry;

@Entity
@Table(name = "processo")
@DiscriminatorColumn(length = 255)
/*
 * This class is generated from the entity 'Processo' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Processo implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "identification", unique = true, nullable = false)
	private String identification;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "peticao", nullable = false)
	private Peticao peticao;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "auto", nullable = false)
	private Auto auto;
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "pagina", nullable = false)
	private Pagina pagina;
	
	@Column(name = "archived", nullable = false)
	private boolean archived;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public Processo() {
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
	public Processo(Date data, String identification, Peticao peticao, Auto auto, Pagina pagina, boolean archived) {
		super();
		if (data == null) {
			throw new java.lang.IllegalArgumentException("'data' must not be null.");
		}
		if (identification == null) {
			throw new java.lang.IllegalArgumentException("'identification' must not be null.");
		}
		if (peticao == null) {
			throw new java.lang.IllegalArgumentException("'peticao' must not be null.");
		}
		if (auto == null) {
			throw new java.lang.IllegalArgumentException("'auto' must not be null.");
		}
		if (pagina == null) {
			throw new java.lang.IllegalArgumentException("'pagina' must not be null.");
		}
		this.data = data;
		this.identification = identification;
		this.peticao = peticao;
		this.auto = auto;
		this.pagina = pagina;
		this.archived = archived;
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
	 * Returns the value of property {@link #identification}.
	 */
	public String getIdentification() {
		return identification;
	}
	
	/**
	 * Sets the value of property {@link #identification}.
	 */
	public void setIdentification(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'identification' must not be null.");
		}
		this.identification = newValue;
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(this);
	}
	
	/**
	 * Returns the value of property {@link #peticao}. This method does not return
	 * archived entities. This method is marked as deprecated, because it does not
	 * return archived entities. Please use {@link #getPeticao(boolean)} instead.
	 */
	@java.lang.Deprecated
	public Peticao getPeticao() {
		return getPeticao(false);
	}
	
	/**
	 * Returns the value of property {@link #peticao}. This method is marked as
	 * deprecated, because it does not return archived entities. Please use {@link
	 * #getPeticao(boolean)} instead.
	 */
	public Peticao getPeticao(boolean includeArchivedEntities) {
		if (includeArchivedEntities) {
			return peticao;
		} else {
			if (peticao == null) {
				return peticao;
			}
			if (!peticao.isArchived() || includeArchivedEntities) {
				return peticao;
			}
			return null;
		}
	}
	
	/**
	 * Sets the value of property {@link #peticao}.
	 */
	public void setPeticao(Peticao newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'peticao' must not be null.");
		}
		this.peticao = newValue;
	}
	
	/**
	 * Returns the value of property {@link #auto}.
	 */
	public Auto getAuto() {
		return auto;
	}
	
	/**
	 * Sets the value of property {@link #auto}.
	 */
	public void setAuto(Auto newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'auto' must not be null.");
		}
		this.auto = newValue;
	}
	
	/**
	 * Returns the value of property {@link #pagina}.
	 */
	public Pagina getPagina() {
		return pagina;
	}
	
	/**
	 * Sets the value of property {@link #pagina}.
	 */
	public void setPagina(Pagina newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'pagina' must not be null.");
		}
		this.pagina = newValue;
	}
	
	/**
	 * Returns the value of property {@link #archived}. Use {@link #isArchived()}
	 * instead.
	 */
	@java.lang.Deprecated
	public boolean getArchived() {
		return archived;
	}
	
	/**
	 * Returns the value of property {@link #archived}.
	 */
	public boolean isArchived() {
		return archived;
	}
	
	/**
	 * <p>
	 * Sets the value of property {@link #archived}.
	 * </p>
	 * <p>
	 * Setting this property to <code>true</code> logically deletes the entity. The
	 * entity remains in the database physically, but is only returned if explicitly
	 * requested.
	 * </p>
	 */
	public void setArchived(boolean newValue) {
		this.archived = newValue;
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
		if (!(obj instanceof Processo)) {
			return false;
		}
		Processo other = (Processo) obj;
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
		result.append("Processo-");
		result.append(getId());
		result.append(" [");
		result.append("data = ");
		result.append(getData());
		result.append(", ");
		result.append("identification = ");
		result.append(getIdentification());
		result.append(", ");
		result.append("archived = ");
		result.append(isArchived());
		result.append("]");
		return result.toString();
	}
	
}
