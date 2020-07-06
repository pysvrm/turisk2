package mx.com.vrm.turisk.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionJavaOracleSicop {

	public void conexionOracle(String query) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			String url = "jdbc:oracle:thin:" +"@10.1.4.130:1529/SICOPMF"; 
			String usuario = "nct";
			String password = "f3rr0m3x";
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate(query);
			sentencia.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection conexionOracle() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			String url = "jdbc:oracle:thin:" +"@10.1.4.130:1529/SICOPMF"; 
			String usuario = "nct";
			String password = "f3rr0m3x";
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			return conexion;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Statement conexionOracleQE() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			String url = "jdbc:oracle:thin:" +"@10.1.4.130:1529/SICOPMF"; 
			String usuario = "nct";
			String password = "f3rr0m3x";
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			Statement sentencia = conexion.createStatement();
			return sentencia;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
