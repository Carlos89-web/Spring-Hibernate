package conexionHibernate;

// --- VIDEO 55 ---

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateUnoVarios.Pedido;

public class InsertaCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			Cliente cliente1 = new Cliente("Lucia", "Prieto", "Huelva");
			DetallesCliente detallescliente1 = new DetallesCliente("www.luciaCompany.com", "456789", "La m�s mejon");

			// VIDEO 55: Asociamos los objetos
			
			cliente1.setDetallesCliente(detallescliente1);
			
			miSession.beginTransaction();
			
			// Video 55: Este save guarda la informaci�n en las dos tablas relacionadas

			miSession.save(cliente1);

			miSession.getTransaction().commit();

			System.out.println("Registro correcto");

			miSession.close();

		} finally {

			miFactory.close();
		}

	}

}