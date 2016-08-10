package tribunal.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
/*
 * This class is generated from the entity 'ProcessoAutuado' defined in the HEDL
 * model.
 * 
 * Note: Any change made to this class will be overridden.
 */
public class ProcessoAutuado extends Processo {
	
	@OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "processoAutuado")
	private List<Registro> registro;
	
	/**
	 * <p>
	 * Default constructor. Only used by JPA.
	 * </p>
	 * <p>
	 * This constructor is marked as deprecated because it must never be used directly.
	 * </p>
	 */
	@java.lang.Deprecated
	public ProcessoAutuado() {
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
	public ProcessoAutuado(String identification, PeticaoDistribuida peticao, Auto auto, Pagina pagina, boolean archived) {
		super(identification, peticao, auto, pagina, archived);
	}
	
	/**
	 * Returns the value of property {@link #registro}.
	 */
	public List<Registro> getRegistro() {
		if (registro == null) {
			registro = new ArrayList<Registro>(1);
		}
		return registro;
	}
	
	/**
	 * Sets the value of property {@link #registro}.
	 */
	public void setRegistro(List<Registro> newValue) {
		this.registro = newValue;
		// Set mapped-by reference
		if (this.registro != null) {
			for (Registro _next : this.registro) {
				_next.setProcessoAutuado(this);
			}
		}
	}
	
	@java.lang.Override
	public java.lang.String toString() {
		java.lang.StringBuilder result = new java.lang.StringBuilder();
		result.append("ProcessoAutuado-");
		result.append(getId());
		result.append(" [");
		result.append("identification = ");
		result.append(getIdentification());
		result.append(", ");
		result.append("archived = ");
		result.append(isArchived());
		result.append("]");
		return result.toString();
	}
	
}
