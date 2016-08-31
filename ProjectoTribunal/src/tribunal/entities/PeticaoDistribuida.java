package tribunal.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
/*
 * This class is generated from the entity 'PeticaoDistribuida' defined in the
 * HEDL model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class PeticaoDistribuida extends Peticao {
	
	@OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "seccao", nullable = true)
	private Seccao seccao;
	
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
	public PeticaoDistribuida(String numeroId, Date data, String requerente, String requerido, String resumo, String remetente, boolean dist, String apenso, boolean archived, Seccao seccao) {
		super(numeroId, data, requerente, requerido, resumo, remetente, dist, apenso, archived);
		this.seccao = seccao;
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
		this.seccao = newValue;
	}
	
	@java.lang.Override
	public java.lang.String toString() {
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		result.append("PeticaoDistribuida-");
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
