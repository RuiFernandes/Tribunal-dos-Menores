package tribunal.controler.livroPorta;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Radiogroup;

import tribunal.custom.TribunalDAO;
import tribunal.entities.Peticao;
import tribunal.entities.Processo; 
public class listaProcessos {

	TribunalDAO dao= new TribunalDAO(TribunalDAO.class);
private List<Peticao> peticoes;
private	List<Processo> processos ;
private String search;	
private Processo processo;	
public List<Peticao> getPeticoes() {
	return peticoes;
}



public void setPeticoes(List<Peticao> peticoes) {
	this.peticoes = peticoes;
}



public Processo getProcesso() {
	return processo;
}



public void setProcesso(Processo processo) {
	this.processo = processo;
}



public Radiogroup getPesquisa() {
	return pesquisa;
}



public void setPesquisa(Radiogroup pesquisa) {
	this.pesquisa = pesquisa;
}

@Wire("#pesquisa")
Radiogroup pesquisa;



	
public List<Processo> getProcessos() {
	return processos;
}



public void setProcessos(List<Processo> processos) {
	this.processos = processos;
}



public String getSearch() {
	return search;
}



public void setSearch(String search) {
	this.search = search;
}

@AfterCompose	
public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
	Selectors.wireComponents(view, this, false);
}
	

@Init
public void init(){
	
processos=dao.getAllProcessos(true);	

	
}

@NotifyChange("*")
@Command
public void search(){
	if (search==null|| search==" "|| search=="") {
		init();
	} else  {
		processos= dao.searchProcessos(search, 0);
		if (processos.isEmpty()) {
			Clients.showNotification("Nao existem processos '"+search+"'");
			
		}
		}
}
	
@NotifyChange
@Command
public void detailProcess(){
	if (processo==null) {
		
	} else {

	
	Sessions.getCurrent().setAttribute("processo", processo);
	Executions.createComponents("/tribunal/processoDetail.zul", null, null);
	
	
	}
}
	
}
