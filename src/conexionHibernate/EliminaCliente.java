package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();

			// Creamos una instancia. Indicamos la clase del objeto que quiero
			// obtener, y el id dentro de la tabla

			Cliente elCliente = miSession.get(Cliente.class, 5);

			// El objeto "elCliente" es null por defecto

			if (elCliente != null) {

				System.out.println("Voy a eliminar al cliente " + elCliente.getNombre());

				miSession.delete(elCliente);

			}

			miSession.getTransaction().commit();

			if (elCliente != null)
				System.out.println("Registro eliminado");
			else
				System.out.println("El cliente no existe");
			
			miSession.close();

		}  finally {

			miFactory.close();
		}

	}

}
