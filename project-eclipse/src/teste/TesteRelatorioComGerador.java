package teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
//import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.br.gastos.ConnectionFactory;
import relatorio.GeradorRelatorio;

import net.sf.jasperreports.engine.JRException;

public class TesteRelatorioComGerador {

	public static void main(String[] args) throws SQLException, JRException, FileNotFoundException {
		String nome = "gastor_por_mes";
		Map <String, Object> parametros = new HashMap<String, Object>();
		
		//Connection connection  = new ConnectionFactory.getConnection();
		Connection connection  = new ConnectionFactory().getConnection();
		
		GeradorRelatorio geradorRelatorio = new GeradorRelatorio(nome+".jasper",parametros,connection);
		geradorRelatorio.geraPDFOutputStream(new FileOutputStream(nome+"2"+".pdf"));
		
		connection.close();

	}

}
