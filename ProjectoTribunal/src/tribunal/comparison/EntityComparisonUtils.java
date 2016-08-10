package tribunal.comparison;

import tribunal.entities.Auto;
import tribunal.entities.Categoria;
import tribunal.entities.IIntIdentifiable;
import tribunal.entities.InqueritoSocial;
import tribunal.entities.Livro;
import tribunal.entities.Log;
import tribunal.entities.Pagina;
import tribunal.entities.Peticao;
import tribunal.entities.PeticaoApenso;
import tribunal.entities.PeticaoDistribuida;
import tribunal.entities.Processo;
import tribunal.entities.ProcessoAutuado;
import tribunal.entities.Registro;
import tribunal.entities.Seccao;
import tribunal.entities.Usuario;

/**
 * <p>
 * This class should be used for comparing entity objects because some JPA
 * providers can cause problems.
 * </p>
 * <p>
 * Normal equals() compares the classes of both objects which might differ when
 * proxies are not resolved.
 * </p>
 * <p>
 * Therefore, utility methods for equality checks of entity objects are provided
 * here which use certain unique identifying properties for comparison.
 * </p>
 */
public class EntityComparisonUtils {
	
	public final static EntityComparisonUtils INSTANCE = new EntityComparisonUtils();
	
	private EntityComparisonUtils() {
	}
	
	private boolean areEqual(IIntIdentifiable intIdentifiable1, IIntIdentifiable intIdentifiable2) {
		if (intIdentifiable1 == null) {
			if (intIdentifiable2 == null) {
				// Both intIdentifiable1 and intIdentifiable2 are null
				return true;
			} else {
				return false;
			}
		} else {
			if (intIdentifiable2 == null) {
				return false;
			} else {
				int id1 = intIdentifiable1.getId();
				int id2 = intIdentifiable2.getId();
				// this can happen if both intIdentifiables are created in the current database
				// transaction
				if (id1 == 0 && id2 == 0) {
					return intIdentifiable1 == intIdentifiable2;
				}
				return id1 == id2;
			}
		}
	}
	
	private boolean areNotEqual(IIntIdentifiable intIdentifiable1, IIntIdentifiable intIdentifiable2) {
		return !areEqual(intIdentifiable1, intIdentifiable2);
	}
	
	public boolean areEqual(Usuario usuario1, Usuario usuario2) {
		return areEqual((IIntIdentifiable) usuario1, (IIntIdentifiable) usuario2);
	}
	
	public boolean areNotEqual(Usuario usuario1, Usuario usuario2) {
		return areNotEqual((IIntIdentifiable) usuario1, (IIntIdentifiable) usuario2);
	}
	
	public boolean areEqual(Categoria categoria1, Categoria categoria2) {
		return areEqual((IIntIdentifiable) categoria1, (IIntIdentifiable) categoria2);
	}
	
	public boolean areNotEqual(Categoria categoria1, Categoria categoria2) {
		return areNotEqual((IIntIdentifiable) categoria1, (IIntIdentifiable) categoria2);
	}
	
	public boolean areEqual(Seccao seccao1, Seccao seccao2) {
		return areEqual((IIntIdentifiable) seccao1, (IIntIdentifiable) seccao2);
	}
	
	public boolean areNotEqual(Seccao seccao1, Seccao seccao2) {
		return areNotEqual((IIntIdentifiable) seccao1, (IIntIdentifiable) seccao2);
	}
	
	public boolean areEqual(Livro livro1, Livro livro2) {
		return areEqual((IIntIdentifiable) livro1, (IIntIdentifiable) livro2);
	}
	
	public boolean areNotEqual(Livro livro1, Livro livro2) {
		return areNotEqual((IIntIdentifiable) livro1, (IIntIdentifiable) livro2);
	}
	
	public boolean areEqual(Pagina pagina1, Pagina pagina2) {
		return areEqual((IIntIdentifiable) pagina1, (IIntIdentifiable) pagina2);
	}
	
	public boolean areNotEqual(Pagina pagina1, Pagina pagina2) {
		return areNotEqual((IIntIdentifiable) pagina1, (IIntIdentifiable) pagina2);
	}
	
	public boolean areEqual(Processo processo1, Processo processo2) {
		return areEqual((IIntIdentifiable) processo1, (IIntIdentifiable) processo2);
	}
	
	public boolean areNotEqual(Processo processo1, Processo processo2) {
		return areNotEqual((IIntIdentifiable) processo1, (IIntIdentifiable) processo2);
	}
	
	public boolean areEqual(ProcessoAutuado processoAutuado1, ProcessoAutuado processoAutuado2) {
		return areEqual((IIntIdentifiable) processoAutuado1, (IIntIdentifiable) processoAutuado2);
	}
	
	public boolean areNotEqual(ProcessoAutuado processoAutuado1, ProcessoAutuado processoAutuado2) {
		return areNotEqual((IIntIdentifiable) processoAutuado1, (IIntIdentifiable) processoAutuado2);
	}
	
	public boolean areEqual(Registro registro1, Registro registro2) {
		return areEqual((IIntIdentifiable) registro1, (IIntIdentifiable) registro2);
	}
	
	public boolean areNotEqual(Registro registro1, Registro registro2) {
		return areNotEqual((IIntIdentifiable) registro1, (IIntIdentifiable) registro2);
	}
	
	public boolean areEqual(Peticao peticao1, Peticao peticao2) {
		return areEqual((IIntIdentifiable) peticao1, (IIntIdentifiable) peticao2);
	}
	
	public boolean areNotEqual(Peticao peticao1, Peticao peticao2) {
		return areNotEqual((IIntIdentifiable) peticao1, (IIntIdentifiable) peticao2);
	}
	
	public boolean areEqual(PeticaoDistribuida peticaoDistribuida1, PeticaoDistribuida peticaoDistribuida2) {
		return areEqual((IIntIdentifiable) peticaoDistribuida1, (IIntIdentifiable) peticaoDistribuida2);
	}
	
	public boolean areNotEqual(PeticaoDistribuida peticaoDistribuida1, PeticaoDistribuida peticaoDistribuida2) {
		return areNotEqual((IIntIdentifiable) peticaoDistribuida1, (IIntIdentifiable) peticaoDistribuida2);
	}
	
	public boolean areEqual(PeticaoApenso peticaoApenso1, PeticaoApenso peticaoApenso2) {
		return areEqual((IIntIdentifiable) peticaoApenso1, (IIntIdentifiable) peticaoApenso2);
	}
	
	public boolean areNotEqual(PeticaoApenso peticaoApenso1, PeticaoApenso peticaoApenso2) {
		return areNotEqual((IIntIdentifiable) peticaoApenso1, (IIntIdentifiable) peticaoApenso2);
	}
	
	public boolean areEqual(Auto auto1, Auto auto2) {
		return areEqual((IIntIdentifiable) auto1, (IIntIdentifiable) auto2);
	}
	
	public boolean areNotEqual(Auto auto1, Auto auto2) {
		return areNotEqual((IIntIdentifiable) auto1, (IIntIdentifiable) auto2);
	}
	
	public boolean areEqual(InqueritoSocial inqueritoSocial1, InqueritoSocial inqueritoSocial2) {
		return areEqual((IIntIdentifiable) inqueritoSocial1, (IIntIdentifiable) inqueritoSocial2);
	}
	
	public boolean areNotEqual(InqueritoSocial inqueritoSocial1, InqueritoSocial inqueritoSocial2) {
		return areNotEqual((IIntIdentifiable) inqueritoSocial1, (IIntIdentifiable) inqueritoSocial2);
	}
	
	public boolean areEqual(Log log1, Log log2) {
		return areEqual((IIntIdentifiable) log1, (IIntIdentifiable) log2);
	}
	
	public boolean areNotEqual(Log log1, Log log2) {
		return areNotEqual((IIntIdentifiable) log1, (IIntIdentifiable) log2);
	}
	
}
