package ar.juanprueba.conexionHibernateUnoAVarios;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearPedidosCliente {

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
			//crear pedido del cliente
			// la fecha Date se considera deprecada, hayq ue usar gregorianCalendar
			Pedido pedido = new Pedido(new Date(120,7,2));
			Pedido pedido2 = new Pedido(new Date(120,4,2));
			Pedido pedido3 = new Pedido(new Date(120,9,2));
			
			//agregarPedidos creados al cliente
			elCliente.agregarPedido(pedido);
			elCliente.agregarPedido(pedido2);
			elCliente.agregarPedido(pedido3);
			
			//guardar los pedidos en la bbd en la tabla pedidos
			miSession.save(pedido);
			miSession.save(pedido2);
			miSession.save(pedido3);
			
			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en BBDD");

			
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
