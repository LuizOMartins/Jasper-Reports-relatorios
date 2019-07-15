package relatorio;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.br.gastos.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class TesteRelatorio {
	
	public static void main(String [] args ) throws SQLException, JRException, FileNotFoundException {
		Connection connection  = new ConnectionFactory().getConnection();
		
		//JasperCompileManager.compileReportToFile("gastor_por_mes.jrxml");
		//JasperCompileManager.compileReportToFile("gastor_por_mes_subreport1.jrxml");//gera arquivo jasper
		//precisa esta com jdk configurado no projeto
		
		Map<String, Object> params = new HashMap<String , Object>();
		
		JasperPrint jasperPrint =  JasperFillManager.fillReport("gastor_por_mes.jasper", params, connection);
		
		JRExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("gastos_por_mes.pdf"));
	
		exporter.exportReport();
		connection.close();
	}

}
