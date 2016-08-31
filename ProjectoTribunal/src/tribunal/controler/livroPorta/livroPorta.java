package tribunal.controler.livroPorta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;

import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.Auto;
import tribunal.entities.Livro;
import tribunal.entities.Pagina;
import tribunal.entities.Peticao;
import tribunal.entities.PeticaoDistribuida;
import tribunal.entities.Processo;
import tribunal.entities.ProcessoAutuado;
import tribunal.entities.Seccao;
import tribunal.entities.Usuario;

public class livroPorta {
	TribunalDAO dao= new TribunalDAO(TribunalDAO.class);
	List<PeticaoDistribuida> distribuicao;
	private List<Auto> autos=dao.getAllAutos();
	private Seccao seccao;
	private List<PeticaoDistribuida> peticoes ;
	private Peticao peticao;
	private List<Livro> livros=dao.getAllLivros();
	private Livro livro;
	private List<Pagina> paginas;
	private Pagina pagina;
	private String numeroProcesso;
	private String outro;
	private Auto auto;
	private Usuario user;
	private Date data= new Date();
	private Processo apenso;
	private ProcessoAutuado processoAutuado;
	
	
	
	public Processo getApenso() {
		return apenso;
	}
	public void setApenso(Processo apenso) {
		this.apenso = apenso;
	}
	public String getOutro() {
		return outro;
	}
	public void setOutro(String outro) {
		this.outro = outro;
	}
	public Auto getAuto() {
		return auto;
	}
	public void setAuto(Auto auto) {
		this.auto = auto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	@Wire("#outros")
	Textbox outros;
	
	

	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public List<Auto> getAutos() {
		return autos;
	}
	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
	public List<PeticaoDistribuida> getPeticoes() {
		return peticoes;
	}
	public void setPeticoes(List<PeticaoDistribuida> peticoes) {
		this.peticoes = peticoes;
	}
	public Peticao getPeticao() {
		return peticao;
	}
	public void setPeticao(Peticao peticao) {
		this.peticao = peticao;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public List<Pagina> getPaginas() {
		return paginas;
	}
	public void setPaginas(List<Pagina> paginas) {
		this.paginas = paginas;
	}
	public Pagina getPagina() {
		return pagina;
	}
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	public String getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

@Init
	public void init(){
	user=(Usuario) Sessions.getCurrent().getAttribute("user");
	seccao=user.getSeccao();
	data=new Date();
	peticoes = new ArrayList<PeticaoDistribuida>() ;
	if (user.getSeccao().getNome().equals("Gestao do sistema") ) {
		distribuicao=dao.getAllPeticaoDistribuidas(true);
		for (PeticaoDistribuida pet : distribuicao) {
			if (pet.getDist()) {
				peticoes.add(pet);
			}
		}
	} else {
		distribuicao=dao.getPeticaoDistribuidasBySeccao(seccao, false);
		for (PeticaoDistribuida pet : distribuicao) {
			if (pet.getDist()) {
				peticoes.add(pet);
			}
		}
	}
	
	
	if (livros.isEmpty()) {
		dao.createLivro("Livro Porta", 1);
		livros=dao.getAllLivros();
		livro=livros.get(0);
		dao.createPagina(1, livro);
		paginas=dao.getPaginasByLivro(livro);
		pagina=paginas.get(dao.getPaginasByLivro(livro).size()-1);
		numeroProcesso=livro.getNumero()+"-"+pagina.getPag()+"-"+(data.getYear()+1900)+"-"+user.getNome().charAt(0);
		
		
	} else{
		livros=dao.getAllLivros();
		livro=livros.get(livros.size()-1);
		
		paginas=dao.getPaginasByLivro(livro);
		pagina=paginas.get(paginas.size()-1);
		
		if(paginas.size()<2){
			numeroProcesso=livro.getNumero()+"-"+pagina.getPag()+"-"+(data.getYear()+1900)+"-"+user.getNome().charAt(0);
		}else{
			
		
		numeroProcesso=livro.getNumero()+"-"+(pagina.getPag())+"-"+(data.getYear()+1900)+"-"+user.getNome().charAt(0);
		}
	}
		
	}

@AfterCompose	
public void afterCompose(@ContextParam(ContextType.VIEW) Component view){
	Selectors.wireComponents(view, this, false);
	
}


@NotifyChange("*")
@Command
public void adicionarAuto(){
	
if (auto==null ) {
		
	}else{
	if(auto.getAuto().equals("outro")){
		System.out.println("this worked");
		outros.setDisabled(false);
	}
	else{
		outros.setDisabled(true);	
	}}
}

@Command
@NotifyChange
public void limpar(){
	peticao=null;
	auto=null;
	outro=null;
	
}



@NotifyChange("*")
@Command
public void actuar(){
	if (auto==null ) {
		Clients.showNotification("Complete todos os campos obrigatorios");
	}else if( peticao==null){
		Clients.showNotification("Complete todos os campos obrigatorios");
	}else{
	if(auto.getAuto().equals("outro")){
		
		if (outro==null) {
			Clients.showNotification("Campo Auto tem que ser completo"); 
		}else{
			
			peticao.setDist(false);
			//refreshList();
			peticao.setArchived(false);
			dao.executeInTransaction(new ICommand() {
				
				@Override
				public void execute(IDBOperations operations) {
					// TODO Auto-generated method stub
					operations.merge(peticao);
					operations.flush();
				}
			});
			processoAutuado=dao.createProcessoAutuado(data,numeroProcesso, peticao, dao.createAuto(outro), pagina, false,true);

			dao.createPagina(pagina.getPag()+1, livro);
			dao.createRegistro(data, "Processo Autuado: "+outro, processoAutuado,user);
			limpar();
			init();
			
		}
		
	}
	else{
	
		peticao.setDist(false);
		peticao.setArchived(false);
		dao.executeInTransaction(new ICommand() {
			
			@Override
			public void execute(IDBOperations operations) {
				operations.merge(peticao);}
		});
		processoAutuado=dao.createProcessoAutuado(data,numeroProcesso, peticao, auto, pagina, false,true);
		//peticoes=dao.getAllPeticaoDistribuidas(false);
		dao.createPagina((pagina.getPag()+1), livro);
		dao.createRegistro(data, "Processo Autuado: "+auto.getAuto(), processoAutuado,user);
		limpar();
		init();
	}}
	
}
	


public void refreshList(){
	List<PeticaoDistribuida> lista= dao.getArchivedPeticaoDistribuidas();
	for (PeticaoDistribuida peticaoDistribuida : lista) {
		
peticaoDistribuida.setArchived(false);
	
	dao.executeInTransaction(new ICommand() {
		
		@Override
		public void execute(IDBOperations operations) {
			operations.merge(peticaoDistribuida);
			
		}
	});
}
}
}
