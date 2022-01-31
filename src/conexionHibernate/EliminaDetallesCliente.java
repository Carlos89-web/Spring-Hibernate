package conexionHibernate;

// --- VIDEO 59 ---

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();

			DetallesCliente borrarCliente = miSession.get(DetallesCliente.class, 7);
			
			// El objeto de detalleCliente que vamos a borrar, no tiene un cliente asociado
			
			borrarCliente.getElCliente().setDetallesCliente(null);

			if (borrarCliente != null) {

				miSession.delete(borrarCliente);

			}

			miSession.getTransaction().commit();

			if (borrarCliente != null)
				System.out.println("Registro eliminado");
			else
				System.out.println("El cliente no existe");
			
			miSession.close();

		}  finally {

			miFactory.close();
		}

	}

}