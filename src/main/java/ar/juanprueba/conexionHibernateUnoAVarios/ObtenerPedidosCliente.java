package ar.juanprueba.conexionHibernateUnoAVarios;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerPedidosCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).addAnnotatedClass(Pedido.class).buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();
		
		try {
			
			// comenzamos la transaccion
			miSession.beginTransaction();
			// obtener el cliente de la base de datos
			Cliente elCliente = miSession.get(Cliente.class, 7);
			
			System.out.printf("Cliente: %s", elCliente);
			System.out.printf("Pedidos: %s", elCliente.getPedidos());
			
			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			// cerramos la sesion 
			miSession.close();
			// cerramos la sessionFactory
			miFactory.close();
		}
	}

}
