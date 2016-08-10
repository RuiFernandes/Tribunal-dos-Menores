package tribunal.controler.livEntrada;

import java.util.List;
import org.zkoss.bind.annotation.Init;

import tribunal.custom.TribunalDAO;
import tribunal.entities.Peticao;

public class livroEntradalista {
	
TribunalDAO dao= new TribunalDAO(TribunalDAO.class);
private	List<Peticao> peticoes;
private	String pesquisa;

public List<Peticao> getPeticoes() {
	return peticoes;
}
public void setPeticoes(List<Peticao> peticoes) {
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
	peticoes=dao.getAllPeticaos(true);
}

}
