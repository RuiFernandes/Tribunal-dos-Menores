package tribunal.controler;

import java.util.Date;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import tribunal.custom.TribunalDAO;
import tribunal.entities.Categoria;
import tribunal.entities.Seccao;
import tribunal.entities.Usuario;

public class user {
 TribunalDAO dao= new TribunalDAO(TribunalDAO.class); 	
private List<Seccao> seccoes=dao.getAllSeccaos();
private List<Categoria> categorias=dao.getAllCategorias();
private Seccao seccao;
private Categoria categoria;
private String nomeCompleto;
private String username;
private String pass;
private String confPass;
private Date data= new Date();
private Long numero=(long)dao.countUsuarios()+1;
private List<Usuario> users=dao.getAllUsuarios();

@Command
public void view(){
	//Window win= (Window)
			Executions.createComponents("/tribunal/test.zul",null,null);

			//win.doModal();
			//win.setClosable(true);
	
}

@Command
@NotifyChange({"users"})
public void save(){
	if (username.isEmpty() && pass.isEmpty()) {
		Clients.showNotification("Complete os campos com erros");
	}
	System.out.println(data);
	//dao.createUsuario(nomeCompleto, data, username, pass, categoria, seccao);
	Clients.showNotification("user "+nomeCompleto+" Gravado com Sucesso");
	users.add(dao.createUsuario(nomeCompleto, data, username, pass, categoria, seccao));
	//Clients.showNotification("user "+nomeCompleto+" Gravado com Sucesso");
}
public List<Usuario> getUsers() {
	return users;
}
public void setUsers(List<Usuario> users) {
	this.users = users;
}
public String getNomeCompleto() {
	return nomeCompleto;
}
public Long getNumero() {
	return numero;
}
public void setNumero(Long numero) {
	this.numero = numero;
}
public void setNomeCompleto(String nomeCompleto) {
	this.nomeCompleto = nomeCompleto;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getConfPass() {
	return confPass;
}
public void setConfPass(String confPass) {
	this.confPass = confPass;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public List<Seccao> getSeccoes() {
	return seccoes;
}
public void setSeccoes(List<Seccao> seccoes) {
	this.seccoes = seccoes;
}
public List<Categoria> getCategorias() {
	return categorias;
}
public void setCategorias(List<Categoria> categorias) {
	this.categorias = categorias;
}
public Seccao getSeccao() {
	return seccao;
}
public void setSeccao(Seccao seccao) {
	this.seccao = seccao;
}
public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

}
