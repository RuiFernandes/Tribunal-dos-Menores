package tribunal.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "peticao")
@DiscriminatorColumn(length = 255)
/*
 * This class is generated from the entity 'Peticao' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Peticao implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "numeroid", nullable = false)
	private String numeroId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Date data;
	
	@Column(name = "requerente", nullable = false)
	private String requerente;
	
	@Column(name = "requerido", nullable = false)
	private String requerido;
	
	@Column(name = "resumo", nullable = false)
	private String resumo;
	
	@Column(name = "remetente", nullable = false)
	private String remetente;
	
	@Column(name = "dist", nullable = false)
	private boolean dist;
	
	@Column(name = "apenso", nullable = false)
	private String apenso;
	
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
	public Peticao() {
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
	public Peticao(String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean dist, String apenso, boolean archived) {
		super();
		if (numeroId == null) {
			throw new java.lang.IllegalArgumentException("'numeroId' must not be null.");
		}
		if (data == null) {
			throw new java.lang.IllegalArgumentException("'data' must not be null.");
		}
		if (requerente == null) {
			throw new java.lang.IllegalArgumentException("'requerente' must not be null.");
		}
		if (requerido == null) {
			throw new java.lang.IllegalArgumentException("'requerido' must not be null.");
		}
		if (resumo == null) {
			throw new java.lang.IllegalArgumentException("'resumo' must not be null.");
		}
		if (remetente == null) {
			throw new java.lang.IllegalArgumentException("'remetente' must not be null.");
		}
		if (apenso == null) {
			throw new java.lang.IllegalArgumentException("'apenso' must not be null.");
		}
		this.numeroId = numeroId;
		this.data = data;
		this.requerente = requerente;
		this.requerido = requerido;
		this.resumo = resumo;
		this.remetente = remetente;
		this.dist = dist;
		this.apenso = apenso;
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
	 * Returns the value of property {@link #numeroId}.
	 */
	public String getNumeroId() {
		return numeroId;
	}
	
	/**
	 * Sets the value of property {@link #numeroId}.
	 */
	public void setNumeroId(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'numeroId' must not be null.");
		}
		this.numeroId = newValue;
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
	 * Returns the value of property {@link #requerente}.
	 */
	public String getRequerente() {
		return requerente;
	}
	
	/**
	 * Sets the value of property {@link #requerente}.
	 */
	public void setRequerente(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'requerente' must not be null.");
		}
		this.requerente = newValue;
	}
	
	/**
	 * Returns the value of property {@link #requerido}.
	 */
	public String getRequerido() {
		return requerido;
	}
	
	/**
	 * Sets the value of property {@link #requerido}.
	 */
	public void setRequerido(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'requerido' must not be null.");
		}
		this.requerido = newValue;
	}
	
	/**
	 * Returns the value of property {@link #resumo}.
	 */
	public String getResumo() {
		return resumo;
	}
	
	/**
	 * Sets the value of property {@link #resumo}.
	 */
	public void setResumo(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'resumo' must not be null.");
		}
		this.resumo = newValue;
	}
	
	/**
	 * Returns the value of property {@link #remetente}.
	 */
	public String getRemetente() {
		return remetente;
	}
	
	/**
	 * Sets the value of property {@link #remetente}.
	 */
	public void setRemetente(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'remetente' must not be null.");
		}
		this.remetente = newValue;
	}
	
	/**
	 * Returns the value of property {@link #dist}. Use {@link #isDist()} instead.
	 */
	@java.lang.Deprecated
	public boolean getDist() {
		return dist;
	}
	
	/**
	 * Returns the value of property {@link #dist}.
	 */
	public boolean isDist() {
		return dist;
	}
	
	/**
	 * Sets the value of property {@link #dist}.
	 */
	public void setDist(boolean newValue) {
		this.dist = newValue;
	}
	
	/**
	 * Returns the value of property {@link #apenso}.
	 */
	public String getApenso() {
		return apenso;
	}
	
	/**
	 * Sets the value of property {@link #apenso}.
	 */
	public void setApenso(String newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'apenso' must not be null.");
		}
		this.apenso = newValue;
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
		if (!(obj instanceof Peticao)) {
			return false;
		}
		Peticao other = (Peticao) obj;
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
		result.append("Peticao-");
		result.append(getId());
		result.append(" [");
		result.append("numeroId = ");
		result.append(getNumeroId());
		result.append(", ");
		result.append("data = ");
		result.append(getData());
		result.append(", ");
		result.append("requerente = ");
		result.append(getRequerente());
		result.append(", ");
		result.append("requerido = ");
		result.append(getRequerido());
		result.append(", ");
		result.append("resumo = ");
		result.append(getResumo());
		result.append(", ");
		result.append("remetente = ");
		result.append(getRemetente());
		result.append(", ");
		result.append("dist = ");
		result.append(isDist());
		result.append(", ");
		result.append("apenso = ");
		result.append(getApenso());
		result.append(", ");
		result.append("archived = ");
		result.append(isArchived());
		result.append("]");
		return result.toString();
	}
	
}
