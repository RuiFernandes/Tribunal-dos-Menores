package tribunal.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "peticaodistribuida")
/*
 * This class is generated from the entity 'PeticaoDistribuida' defined in the
 * HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class PeticaoDistribuida implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "peticao", nullable = false)
	private Peticao peticao;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "seccao", nullable = false)
	private Seccao seccao;
	
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
	public PeticaoDistribuida() {
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
	public PeticaoDistribuida(Peticao peticao, Seccao seccao, boolean archived) {
		super();
		if (peticao == null) {
			throw new java.lang.IllegalArgumentException("'peticao' must not be null.");
		}
		if (seccao == null) {
			throw new java.lang.IllegalArgumentException("'seccao' must not be null.");
		}
		this.peticao = peticao;
		this.seccao = seccao;
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
	 * Returns the value of property {@link #seccao}.
	 */
	public Seccao getSeccao() {
		return seccao;
	}
	
	/**
	 * Sets the value of property {@link #seccao}.
	 */
	public void setSeccao(Seccao newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'seccao' must not be null.");
		}
		this.seccao = newValue;
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
		if (!(obj instanceof PeticaoDistribuida)) {
			return false;
		}
		PeticaoDistribuida other = (PeticaoDistribuida) obj;
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
		result.append("PeticaoDistribuida-");
		result.append(getId());
		result.append(" [");
		result.append("archived = ");
		result.append(isArchived());
		result.append("]");
		return result.toString();
	}
	
}
