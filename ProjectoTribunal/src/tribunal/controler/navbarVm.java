package tribunal.controler;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.Clients;

import tribunal.entities.Usuario;

public class navbarVm {
private String src;
private Usuario user;

public Usuario getUser() {
	return user;
}

public void setUser(Usuario user) {
	this.user = user;
}

public String getSrc() {
	return src;
}

public void setSrc(String src) {
	this.src = src;
}
@Init
public void init(@ContextParam(ContextType.VIEW) Component view){
	Selectors.wireComponents(view, this, false);
	this.user=(Usuario) Sessions.getCurrent().getAttribute("user");
	src="chapter1/main.zul";
	Clients.showNotification(user.getNome());
}
@Command
@NotifyChange({"*"})
public void distribuicao(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="/tribunal/distribuicaodeProcesso.zul";
}

@Command
@NotifyChange({"*"})
public void relatorioPeticao(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="/tribunal/relatorioPeticao.zul";
}


@GlobalCommand
@NotifyChange({"*"})
public void site(@ContextParam(ContextType.VIEW) Component view){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	Sessions.getCurrent().setAttribute("main", "/chapter1/main.zul");
	src=(String) Sessions.getCurrent().getAttribute("main");

}

@Command
@NotifyChange({"*"})
public void receberDocumento(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/entradaCorresp.zul";
}

@Command
@NotifyChange({"*"})
public void distribuirPeticoes(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/menu.zul";

}

@Command
@NotifyChange({"*"})
public void autuarProcesso(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/autuarProcesso.zul";

}

@Command
@NotifyChange({"*"})
public void listaDeProcessos(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/livroporta.zul";
}

@Command
@NotifyChange({"*"})
public void listaDeEntradas(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/livroEntrada.zul";
}

@Command
@NotifyChange({"*"})
public void despacho(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/despachoProcesso.zul";
}

@Command
@NotifyChange({"*"})
public void listaDespacho(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/livroConclusao.zul";
}

@Command
@NotifyChange({"*"})
public void registarVista(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/registarVista.zul";
}

@Command
@NotifyChange({"*"})
public void users(){
	//System.out.println(Executions.getCurrent().getSession().getAttributes());
	
	src="tribunal/users.zul";

}


}
