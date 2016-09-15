package tribunal.report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Sessions;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tribunal.custom.TribunalDAO;
import tribunal.entities.Auto;
import tribunal.entities.ProcessoAutuado;
//import util.HibernateConfig;

public class Report {
	private static final String REPORT_PATH=Sessions.getCurrent().getWebApp().getRealPath("/Report/Auto");
			//Sessions.getCurrent().getWebApp().getRealPath("/Report/Auto");
			//"Report/Auto";
	private static final String REPORT_EXT_JRXML=".jrxml";
	private static final String REPORT_EXT_PDF=".pdf";
	
	public static void main(String[] args) throws JRException, SQLException, IOException {
		//startHibernate();
//		addCliente();
//		ArrayList<Cliente> lista =new ArrayList<>();
//		getClientes(lista);
		TribunalDAO dao = new TribunalDAO(TribunalDAO.class);
		ProcessoAutuado p=dao.getProcessoAutuado(20);
		ArrayList<ProcessoAutuado> lista= new ArrayList<>();
		ArrayList<Auto> lista2= new ArrayList<>();
		lista.add(p);
		lista2.add(p.getAuto());
		printReport(lista);
		openReport();
	}
	
//	private static void startHibernate()
//	{
//		new  HibernateConfig();
//	}

	
//	private static void addCliente()
//	{
//		Cliente cliente = new Cliente();
//		cliente.setNome("Rui F.");
//		cliente.setEmail("rui@gmail.com");
//		cliente.setTelefone("some number");
//		HibernateConfig.addCliente(cliente);
//		
//	}
//	
//	private static void getClientes(ArrayList <Cliente> lista)
//	{
//		lista.addAll(HibernateConfig.listClientes());
//	}
//	
	private static void printReport(ArrayList<ProcessoAutuado> lista) throws JRException, SQLException, IOException 
	{
		JasperReport report = 
				JasperCompileManager.compileReport(REPORT_PATH+REPORT_EXT_JRXML);
		JasperPrint print = JasperFillManager.
				fillReport(report, null, new JRBeanCollectionDataSource(lista));
		//fillReport(report, null, new JRBeanCollectionDataSource(lista));
		System.out.println(REPORT_PATH);
		JasperExportManager.exportReportToPdfFile(print,REPORT_PATH+REPORT_EXT_PDF);
	}
	
	
	public static void printProcesso(ProcessoAutuado processo) throws JRException, SQLException, IOException {
		ArrayList<ProcessoAutuado> lista= new ArrayList<>();
		lista.add(processo);
		printReport(lista);
		openReport();
	}
	
	private static void openReport() throws IOException
	{
		Desktop.getDesktop().open(new File(REPORT_PATH+REPORT_EXT_PDF));
	}

}
