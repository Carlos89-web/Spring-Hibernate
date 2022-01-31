package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//--- VIDEO 57, 58 ---

public class ObtenerCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();
			
			// Obtenemos los detalles del Cliente

			DetallesCliente detallesDeCliente = miSession.get(DetallesCliente.class, 6);
			
			System.out.println(detallesDeCliente);
			
			System.out.println(detallesDeCliente.getElCliente());
			
			// Video 58: Eliminación en cascada
			
			miSession.delete(detallesDeCliente);

			miSession.getTransaction().commit();

		} // Video 58: movemos el cerrado de sesión al finally para evitr la fuga de memoria

		catch (Exception e) {

			e.printStackTrace();

		} finally {

			miSession.close();

			miFactory.close();
		}
	}

}
