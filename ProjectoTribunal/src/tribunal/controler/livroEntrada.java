package tribunal.controler;

import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;

import tribunal.custom.TribunalDAO;
import tribunal.entities.Peticao;
import tribunal.entities.Processo;
import tribunal.entities.ProcessoAutuado;

public class livroEntrada {
	TribunalDAO dao = new TribunalDAO(TribunalDAO.class);
private String numero;
private  Date data= new Date();
private String nomeDoRemetente;
private String requerente;
private String requerido;
private String Resumo;
//private boolean apenso;
private List<Peticao> peticoes= dao.getAllPeticaos(false);
private ProcessoAutuado processo;
private List<ProcessoAutuado> processos=dao.getAllProcessoAutuados(true);
private String processoSearch;
private Peticao peticao;


@AfterCompose	
public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
	Selectors.wireComponents(view, this, false);
}
	
@Wire("#apenso")
Checkbox apenso;


@Command
@NotifyChange("*")
public void limpar(){
	
	peticao=null;
	numero=null;
	data= new Date();
	nomeDoRemetente=null;
	requerente=null;
	requerido=null;
	Resumo=null;
}

@Command
@NotifyChange({"*"})
public void registarEntrada(){
	if( numero==null || nomeDoRemetente==null|| requerente==null || requerido==null || Resumo==null){
		Clients.showNotification("Complete os campos vazios");
	}else{
	if (apenso.isChecked()) {
		peticoes.add(dao.createPeticao(numero, data, requerente, requerido, Resumo, nomeDoRemetente, false));
		//Clients.showNotification(""+apenso.isChecked());
		//peticoes= dao.getAllPeticaos();
		limpar();		
	}else{
		peticoes.add(dao.createPeticaoApenso(numero, data, requerente, requerido, Resumo, nomeDoRemetente, false, processo));
		//Clients.showNotification(""+apenso.isChecked());
		limpar();
		apenso.setChecked(true);
	}
	}
}

@Command
@NotifyChange("*")
public void search(){
	if(processoSearch==null){}else{
		processos=dao.searchProcessoAutuados(processoSearch, dao.countProcessoAutuados(true));
	System.out.println(processoSearch);
	}
	
}

public List<Peticao> getPeticoes() {
	return peticoes;
}



public void setPeticoes(List<Peticao> peticoes) {
	this.peticoes = peticoes;
}



public Peticao getPeticao() {
	return peticao;
}



public void setPeticao(Peticao peticao) {
	this.peticao = peticao;
}



public Processo getProcesso() {
	return processo;
}
public void setProcesso(ProcessoAutuado processo) {
	this.processo = processo;
}
//getters and setters 
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public String getNomeDoRemetente() {
	return nomeDoRemetente;
}
public void setNomeDoRemetente(String nomeDoRemetente) {
	this.nomeDoRemetente = nomeDoRemetente;
}
public String getRequerente() {
	return requerente;
}
public void setRequerente(String requerente) {
	this.requerente = requerente;
}
public String getRequerido() {
	return requerido;
}
public void setRequerido(String requerido) {
	this.requerido = requerido;
}
public String getResumo() {
	return Resumo;
}
public void setResumo(String resumo) {
	Resumo = resumo;
}
//public boolean isApenso() {
//	return apenso;
//}
//public void setApenso(boolean apenso) {
//	this.apenso = apenso;
//}
public List<ProcessoAutuado> getProcessos() {
	return processos;
}
public void setProcessos(List<ProcessoAutuado> processos) {
	this.processos = processos;
}

public String getProcessoSearch() {
	return processoSearch;
}

public void setProcessoSearch(String processoSearch) {
	this.processoSearch = processoSearch;
}

	
}
