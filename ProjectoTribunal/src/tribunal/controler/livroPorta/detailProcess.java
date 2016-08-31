package tribunal.controler.livroPorta;

import java.util.List;

import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.Clients;

import tribunal.custom.TribunalDAO;
import tribunal.entities.ProcessoAutuado;
import tribunal.entities.Registro;;

public class detailProcess {

private ProcessoAutuado processo;
private List<Registro> registros;
TribunalDAO dao= new TribunalDAO(TribunalDAO.class);
	public List<Registro> getRegistros() {
	return registros;
}

public void setRegistros(List<Registro> registros) {
	this.registros = registros;
}

	public ProcessoAutuado getProcesso() {
	return processo;
}

public void setProcesso(ProcessoAutuado processo) {
	this.processo = processo;
}

	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view){
		Selectors.wireComponents(view, this, false);
		this.processo=(ProcessoAutuado) Sessions.getCurrent().getAttribute("processo");
	registros=dao.getRegistrosByProcessoAutuado(processo);
	}
}
