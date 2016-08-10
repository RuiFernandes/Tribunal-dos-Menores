package tribunal.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagina")
/*
 * This class is generated from the entity 'Pagina' defined in the HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class Pagina implements IIntIdentifiable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "pag", nullable = false)
	private int pag;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "livro", nullable = false)
	private Livro livro;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public Pagina() {
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
	public Pagina(int pag, Livro livro) {
		super();
		if (livro == null) {
			throw new java.lang.IllegalArgumentException("'livro' must not be null.");
		}
		this.pag = pag;
		this.livro = livro;
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
	 * Returns the value of property {@link #pag}.
	 */
	public int getPag() {
		return pag;
	}
	
	/**
	 * Sets the value of property {@link #pag}.
	 */
	public void setPag(int newValue) {
		this.pag = newValue;
	}
	
	/**
	 * Returns the value of property {@link #livro}.
	 */
	public Livro getLivro() {
		return livro;
	}
	
	/**
	 * Sets the value of property {@link #livro}.
	 */
	public void setLivro(Livro newValue) {
		if (newValue == null) {
			throw new java.lang.IllegalArgumentException("'livro' must not be null.");
		}
		this.livro = newValue;
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
		if (!(obj instanceof Pagina)) {
			return false;
		}
		Pagina other = (Pagina) obj;
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
		result.append("Pagina-");
		result.append(getId());
		result.append(" [");
		result.append("pag = ");
		result.append(getPag());
		result.append("]");
		return result.toString();
	}
	
}
