package HibernateUnoVarios;

import java.util.GregorianCalendar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import conexionHibernate.Cliente;
import conexionHibernate.DetallesCliente;

public class CrearPedidosCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Recordar siempre cambiar las clases con annotations a la que sea necesario

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetallesCliente.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();

		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();
			
			// Obtenemos el cliente de la tabla clientes de la BD
			
			Cliente elCliente = miSession.get(Cliente.class, 10);
		
			// Crear pedidos del cliente. Debemos usar la clase gregorianCalendar. Usamos el constructor de fecha.
			
			Pedido pedido1 = new Pedido(new GregorianCalendar (2020, 7, 5));
			Pedido pedido2 = new Pedido(new GregorianCalendar (2020, 6, 15));
			Pedido pedido3 = new Pedido(new GregorianCalendar (2020, 3, 25));
			
			// Agregar pedidos creados al cliente creado
			
			elCliente.agregarPedidos(pedido1);
			elCliente.agregarPedidos(pedido2);
			elCliente.agregarPedidos(pedido3);
			
			// Guardamos los pedidos en la base de datos
			
			miSession.save(pedido1);
			miSession.save(pedido2);
			miSession.save(pedido3);
			
			miSession.getTransaction().commit();

			System.out.println("Registros correctos");
			
			}
			
			catch (Exception e) {

				e.printStackTrace();

			} finally {
				
				miSession.close();

				miFactory.close();
		}

	}

}
