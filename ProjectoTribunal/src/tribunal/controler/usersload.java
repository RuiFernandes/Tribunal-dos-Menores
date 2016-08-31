package tribunal.controler;

import java.util.HashMap;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Map;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;

import tribunal.custom.TribunalDAO;
import tribunal.entities.Usuario;

public class usersload {
private int index;	
private Usuario selected;
private List<Usuario> userList=new TribunalDAO(TribunalDAO.class).getAllUsuarios(false);;

private String pass;
//public String password=selected.getPassword();
public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}


@Init
public void init(){
	
}

@Command
public void autenticar(){

	if (selected.getPassword().equals(pass)) {
		Clients.showNotification("worked");
		//HashMap<String, Object> map= new HashMap<>();
		//map.put("user", selected);
		Sessions.getCurrent().setAttribute("user", selected);
		Executions.getCurrent().sendRedirect("../index.zul");
		
		System.out.println(Executions.getCurrent().getContextPath());
	} else{
		Clients.showNotification("failed");
		
	}
}


@Command
public void autenticar2(){

	if (selected.getPassword().equals(pass)) {
		Clients.showNotification("worked");
		//HashMap<String, Object> map= new HashMap<>();
		//map.put("user", selected);
		Sessions.getCurrent().setAttribute("user", selected);
		Executions.getCurrent().sendRedirect("./index.zul");
		
		System.out.println(Executions.getCurrent().getContextPath());
	} else{
		Clients.showNotification("failed");
		
	}
}

public Usuario getSelected() {
	return selected;
}

public void setSelected(Usuario selected) {
	this.selected = selected;
}

public List<Usuario> getUserList() {
	return userList;
}

public void setUserList(List<Usuario> userList) {
	this.userList = userList;
}
}
