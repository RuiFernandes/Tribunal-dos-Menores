package tribunal.controler.livEntrada;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import tribunal.custom.TribunalDAO;
import tribunal.entities.Peticao;
import tribunal.entities.PeticaoDistribuida;

public class livroEntradalista {
	
TribunalDAO dao= new TribunalDAO(TribunalDAO.class);
private	List<PeticaoDistribuida> peticoes;
private	String pesquisa;

public List<PeticaoDistribuida> getPeticoes() {
	return peticoes;
}
public void setPeticoes(List<PeticaoDistribuida> peticoes) {
	this.peticoes = peticoes;
}
public String getPesquisa() {
	return pesquisa;
}
public void setPesquisa(String pesquisa) {
	this.pesquisa = pesquisa;
}
	
@Init
public void init(){
	peticoes=dao.getAllPeticaoDistribuidas(true);
}

@NotifyChange("*")
@Command
public void search(){
	
	peticoes=dao.searchPeticaoDistribuidas(pesquisa, dao.countPeticaos(true));
}


}
