package tribunal.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
/*
 * This class is generated from the entity 'PeticaoApenso' defined in the HEDL
 * model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class PeticaoApenso extends Peticao {
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "processo", nullable = true)
	private Processo processo;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public PeticaoApenso() {
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
	public PeticaoApenso(String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean archived, Processo processo) {
		super(numeroId, data, requerente, requerido, resumo, remetente, archived);
		this.processo = processo;
	}
	
	/**
	 * Returns the value of property {@link #processo}. This method does not return
	 * archived entities. This method is marked as deprecated, because it does not
	 * return archived entities. Please use {@link #getProcesso(boolean)} instead.
	 */
	@java.lang.Deprecated
	public Processo getProcesso() {
		return getProcesso(false);
	}
	
	/**
	 * Returns the value of property {@link #processo}. This method is marked as
	 * deprecated, because it does not return archived entities. Please use {@link
	 * #getProcesso(boolean)} instead.
	 */
	public Processo getProcesso(boolean includeArchivedEntities) {
		if (includeArchivedEntities) {
			return processo;
		} else {
			if (processo == null) {
				return processo;
			}
			if (!processo.isArchived() || includeArchivedEntities) {
				return processo;
			}
			return null;
		}
	}
	
	/**
	 * Sets the value of property {@link #processo}.
	 */
	public void setProcesso(Processo newValue) {
		this.processo = newValue;
	}
	
	@java.lang.Override
	public java.lang.String toString() {
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		result.append("PeticaoApenso-");
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
		result.append("archived = ");
		result.append(isArchived());
		result.append("]");
		return result.toString();
	}
	
}
