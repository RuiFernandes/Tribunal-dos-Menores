package tribunal.controler;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.Peticao;
import tribunal.entities.PeticaoDistribuida;
import tribunal.entities.Seccao;

public class distribuirPeticao {
	TribunalDAO dao= new TribunalDAO(TribunalDAO.class);
	
private Peticao peticao;
private int index;
private List<Peticao> listpet;
private List<Peticao> peticoes;
private List<Peticao> seccao1= new ArrayList<Peticao>();
private List<Peticao> seccao2= new ArrayList<Peticao>();
private List<Peticao> seccao3= new ArrayList<Peticao>();

@Init
public void init(){
	peticoes=new ArrayList<Peticao>();
	listpet=dao.getAllPeticaos(false);
	for (Peticao peticao : listpet) {
		
			if (peticao.isDist()) {
				peticoes.add(peticao);	
				}
		
		
	}
	
}


public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}

public List<Peticao> getSeccao2() {
	return seccao2;
}

public void setSeccao2(List<Peticao> seccao2) {
	this.seccao2 = seccao2;
}

public List<Peticao> getSeccao3() {
	return seccao3;
}

public void setSeccao3(List<Peticao> seccao3) {
	this.seccao3 = seccao3;
}



@NotifyChange("*")
@Command
public void automatic(){
	if(peticoes==null){}else{
	int one;
	int two;
	int three;
	if(dao.getAllPeticaoDistribuidas(false)==null){
		one=0;
		two=0;
		three=0;
	}
	if (peticoes.isEmpty()==false) {
	int key=0;
	one=dao.getPeticaoDistribuidasBySeccao(dao.searchSeccaos("Seccao 1", 1).get(0), true).size();
	two=dao.getPeticaoDistribuidasBySeccao(dao.searchSeccaos("Seccao 2", 1).get(0), true).size();
	three=dao.getPeticaoDistribuidasBySeccao(dao.searchSeccaos("Seccao 3", 1).get(0), true).size();
	for (int i = 0; i < peticoes.size(); i++) {
		
	
		if (one<=two) {
			if (one<=three) {
				key=1;
				one++;
			}else{key=3;three++;}
		}else if(two<=three){key=2;two++;}
		else{key=3;three++;}
	System.out.println(key);
	System.out.println(one);
	System.out.println(two);
	System.out.println(three);
	switch (key) {
	case 1:seccao1.add(peticoes.get(i));break;
	case 2:seccao2.add(peticoes.get(i));break;
	case 3:seccao3.add(peticoes.get(i));break;
		

	default:System.out.println("something wrong");
		break;
	}
	}
	peticoes=null;
	}}
}


@NotifyChange("*")
@Command
public void retorno(){
	if (peticoes==null) {
		peticoes=new ArrayList<Peticao>();
	}
	
	
if (seccao1.isEmpty()==false)  {
	
			for (Peticao sec1 : seccao1) {
				peticoes.add(sec1);
				
	}
}	

if (seccao2.isEmpty()==false) {
	
			for (Peticao sec2 : seccao2) {
				peticoes.add(sec2);
				
	}
}

if (seccao3.isEmpty()==false) {
	
			for (Peticao sec3 : seccao3) {
				peticoes.add(sec3);
				
	}
		
		
}
seccao1=new ArrayList<Peticao>();
seccao2=new ArrayList<Peticao>();
seccao3=new ArrayList<Peticao>();
}

@NotifyChange("*")
@Command
public void ditribuir(){
if (seccao1.isEmpty()==false) {
	Seccao sec=dao.searchSeccaos("Seccao 1", 1).get(0);
			for (Peticao peticao : seccao1) {
				dao.createPeticaoDistribuida(peticao.getNumeroId(), peticao.getData(), peticao.getRequerente(), peticao.getRequerido(), peticao.getResumo(), peticao.getRemetente(),true, peticao.getApenso(), true,sec);
				peticao.setArchived(true);
				peticao.setDist(false);
				dao.executeInTransaction(new ICommand() {
					
					@Override
					public void execute(IDBOperations operations) {
						operations.merge(peticao);
						
					}
				});
	}seccao1=null;
}	

if (seccao2.isEmpty()==false) {
	Seccao sec=dao.searchSeccaos("Seccao 2", 1).get(0);
			for (Peticao peticao : seccao2) {
				
				dao.createPeticaoDistribuida(peticao.getNumeroId(), peticao.getData(), peticao.getRequerente(), peticao.getRequerido(), peticao.getResumo(), peticao.getRemetente(),true,  peticao.getApenso(), true,sec);
				peticao.setArchived(true);
				peticao.setDist(false);
				dao.executeInTransaction(new ICommand() {
					
					@Override
					public void execute(IDBOperations operations) {
						operations.merge(peticao);
						
					}
				});
	}seccao2=null;
}

if (seccao3.isEmpty()==false) {
	Seccao sec=dao.searchSeccaos("Seccao 3", 1).get(0);
			for (Peticao peticao : seccao3) {
				dao.createPeticaoDistribuida(peticao.getNumeroId(), peticao.getData(), peticao.getRequerente(), peticao.getRequerido(), peticao.getResumo(), peticao.getRemetente(), true,peticao.getApenso(), true,sec);
				peticao.setArchived(true);
				peticao.setDist(false);	
				dao.executeInTransaction(new ICommand() {
					
					@Override
					public void execute(IDBOperations operations) {
						operations.merge(peticao);
						
					}
				});
	}seccao3=null;
}




}

@NotifyChange({"*"})
@Command
public void move1(){
	if(peticao==null){}else{
		seccao1.add(peticao);	
		peticoes.remove(peticao);	
	}
	
}

@NotifyChange({"*"})
@Command
public void move2(){
	if(peticao==null){}else{
		seccao2.add(peticao);	
		peticoes.remove(peticao);	
	}

}
@NotifyChange({"*"})
@Command
public void move3(){
	if(peticao==null){}else{
		seccao3.add(peticao);	
	peticoes.remove(peticao);}
	
}
public Peticao getPeticao() {
	return peticao;
}
public void setPeticao(Peticao peticao) {
	this.peticao = peticao;
}
public List<Peticao> getPeticoes() {
	return peticoes;
}
public void setPeticoes(List<Peticao> peticoes) {
	this.peticoes = peticoes;
}
public List<Peticao> getSeccao1() {
	return seccao1;
}
public void setSeccao1(List<Peticao> seccao1) {
	this.seccao1 = seccao1;
}
	

}
