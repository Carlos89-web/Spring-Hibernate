package pruebasHibernate;

import java.sql.DriverManager;
import java.sql.Connection;

public class pruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creamos la conexión a la BD. useSSL = false es un protocolo de seguridad
		
		String jdbcURL = "jdbc:mysql://localhost:3306/relacioneshibernate?useSSL=false";
		String usuario ="root";
		String clave = "96874";
		
		try {
			
			System.out.println("intentando conectar con la BD: "+jdbcURL);
			
			Connection miConexion = DriverManager.getConnection(jdbcURL, usuario, clave);
			
			System.out.println("Conexión correcta");
			
		} catch (Exception e) {
			
			System.out.println("Conexión fallida");
			
		}
		
	}

}
