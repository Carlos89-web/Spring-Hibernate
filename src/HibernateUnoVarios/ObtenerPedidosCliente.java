package HibernateUnoVarios;

import java.util.GregorianCalendar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import conexionHibernate.Cliente;
import conexionHibernate.DetallesCliente;

public class ObtenerPedidosCliente {

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
			
//			Cliente elCliente = miSession.get(Cliente.class, 10);
		
//			System.out.println("CLiente: "+ elCliente);
//			System.out.println("Pedidos: "+ elCliente.getPedido());
			
			// Usamos HQL para evitar el error fetch lazy. Paquete a importar de 
			// query -> org.hibernate.query.Query;
			
			Query<Cliente> consulta = miSession.createQuery("SELECT CL FROM Cliente CL JOIN FETCH CL.pedido WHERE CL.id=:elClienteId", Cliente.class);
			
			// Especificamos al programa el id del cliente con el set Parameter
			
			consulta.setParameter("elClienteId", 10);
			
			// Ahora cargamos en memoria los resultados de la consulta
			
			Cliente elCliente = consulta.getSingleResult();
			
			
			
			System.out.println("CLiente: "+ elCliente);
			
			miSession.getTransaction().commit();
			
			miSession.close();
			
			System.out.println("Pedidos: "+ elCliente.getPedido());

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
