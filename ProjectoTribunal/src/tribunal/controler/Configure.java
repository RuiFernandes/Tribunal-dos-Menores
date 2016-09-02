package tribunal.controler;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.tool.schema.extract.spi.ExtractionContext.DatabaseObjectAccess;


import javafx.scene.control.DateCell;
import tribunal.custom.IDBOperations;
import tribunal.custom.OperationProvider;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.dao.PeticaoDAO;
import tribunal.entities.Auto;
import tribunal.entities.Categoria;
import tribunal.entities.Livro;
import tribunal.entities.Pagina;
import tribunal.entities.Peticao;
import tribunal.entities.PeticaoDistribuida;
import tribunal.entities.Processo;
import tribunal.entities.ProcessoAutuado;
import tribunal.entities.Seccao;
import tribunal.entities.Usuario;

public class Configure {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
//	new TribunalDAO(TribunalDAO.class).createUsuario("Rui Fernandes", new Date("07/07/1991"), "admin", "admin", "administrator"); 
//		new TribunalDAO(TribunalDAO.class).getAllUsuarios();
//		List <Usuario>userList= new TribunalDAO(TribunalDAO.class).getAllUsuarios();
//		Usuario selected= userList.get(0);
//		String name=userList.get(0).getNome();
//		System.out.println(name);
		
		TribunalDAO dao= new TribunalDAO(TribunalDAO.class);
//		dao.createCategoria("Administrador");
//		dao.createCategoria("Juiz");
//		dao.createCategoria("Escrivao");
//		dao.createCategoria("Ajudante Escrivao");
//		dao.createCategoria("Oficial de Deligencias");
//		dao.createCategoria("Assistente Social");
//		dao.createCategoria("Secretaria Geral");
//		dao.flush();
////		dao.createSeccao("Seccao 1");
//		dao.createSeccao("Gestao do sistema");
//		dao.createSeccao("Seccao 1");
//		dao.createSeccao("Seccao 2");
//		dao.createSeccao("Seccao 3");
//		dao.flush();
//		Categoria categoria= dao.getAllCategorias().get(0);
//		Seccao seccao=dao.getAllSeccaos().get(0);
//
////		//System.out.println(	categoria.toString());
////		
//		Usuario user= new Usuario("Rui Fernandes", new Date("1991/07/07"), "admin", "admin", categoria, seccao,false);
//		dao.createUsuario("other user", new Date("1991/07/07"), "admin1", "admin1", categoria,seccao,false);
//		dao.createUsuario(user.getNome(),user.getDataDeNascimento(),user.getUsername(),user.getPassword(),user.getCategoria(),user.getSeccao(),false);
		dao.createAuto("Acção De Alimento");
		dao.createAuto("Regulação Exercício Do Poder Parental");
		dao.createAuto("Alteração Da Pensão Alimentar");
		dao.createAuto("Alteração Da Regulação Do Exercício Do Poder Parental");
		dao.createAuto("Autorização De Saída");
		dao.createAuto("Interdição De Saída");
		dao.createAuto("Autorização De Abertura De Conta");
		dao.createAuto("Emancipação");
		dao.createAuto("Averiguação Oficiosa De Paternidade/Maternidades");
		dao.createAuto("Plenitude Do Poder Parental/Movimentação");

//		dao.createAuto("outro");
////		//System.out.println(dao.getAllCategorias().get(0).toString());
//		dao.createAuto("auto1");
//		dao.createAuto("auto2");
//		dao.createAuto("auto3");
//		dao.flush();
////		dao.createPeticao("aaasdf", new Date(), "Rui Guirrugo", "Rui ", "bla bla bla bla bla", "Guirrugo", false );
////	dao.createProcesso(1111, dao.getAllPeticaos().get(0),dao.createAuto("test") );	
//	System.out.println(dao.countLivros()+1);
//
//	//System.out.println(1900+new Date().getYear());
////		String date= new Date().toString();
////		Livro livro= dao.getAllLivros().get(0);
////		dao.createPagina(1,livro );
////		System.out.println(livro.getPagina().size());
//		
//List<Livro> livros= dao.getAllLivros();
//Livro livro = livros.get(0);
////dao.createPagina(1, livro);
//List<Pagina> paginas= dao.getPaginasByLivro(livro);
//Pagina pagina= paginas.get(0);
//System.out.println(pagina.getPag());
//	
//	TribunalDAO dao2= new TribunalDAO(TribunalDAO.class);
//	Auto auto= dao.getAuto(14);;
//	auto.setAuto("test");

//	dao.getEntityManagerFactory();	
//	PeticaoDAO dao2= new PeticaoDAO();
//	dao2.
//	Peticao entity= dao.getPeticao(19);
//	entity.setArchived(false);
	
	//Peticao pet= dao.getPeticao(50);
	//dao.createPeticaoDistribuida(pet.getNumeroId(), pet.getData(), pet.getRequerido(), pet.getRequerente(), pet.getResumo(), pet.getRemetente(), false, dao.getSeccao(11));
	
	//dao.merge(entity);
//	dao.executeInTransaction( new ICommand() {
//		
//		@Override
//		public void execute(IDBOperations operations) {
//			operations.delete(operations.merge(entity));
//			
//		}
//	});
	//Peticao pe=dao.getAllPeticaos(false).get(0);
	//dao2.getPeticao(dao.getEntityManagerFactory(), 19).setArchived(false);
	//dao.flush();
//	Peticao entity= dao.getPeticao(19);
	//dao2.delete(, entity);	
	
//		List<PeticaoDistribuida> dist= dao.getAllPeticaoDistribuidas(false);
//		System.out.println(dist.isEmpty());
//		
//		System.out.println();
	//System.out.println(dao.getAllPeticaoDistribuidas(false).get(0).getPeticao().toString());
//		ProcessoAutuado proc= dao.getProcessoAutuado(27);
//		Peticao pet= proc.getPeticao();
//		System.out.println(pet.toString());
//		List<PeticaoDistribuida> lista= dao.getArchivedPeticaoDistribuidas();
//		for (PeticaoDistribuida peticaoDistribuida : lista) {
//			
//	peticaoDistribuida.setArchived(false);
//		
//		dao.executeInTransaction(new ICommand() {
//			
//			@Override
//			public void execute(IDBOperations operations) {
//				operations.merge(peticaoDistribuida);
//				
//			}
//		});
//	}	
		}

}
