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

/*Si estuvieramos en el fetch Lazy y quisieramos hacer una consulta a la base de datos 
 * depues de haber cerrado la sesion, debemos usar HQL 
 
try {
	
	// comenzamos la transaccion
	miSession.beginTransaction();
	
	// creamos la consulta en lenguaje HQL
	JOIN FETCH = IGUAL A INNERJOIN, indicamos un parametro con : 
	 Query<Cliente> consulta = miSession.createQuery("SELECT C FROM cliente C JOIN FETCH C.pedidos WHERE C.id =:elClienteId", Cliente.class);
	 // le pasamos a la Query el parametro con setParameter, indicando primero el alias que es el parametro(lo que esta despues del : en la consulta) y el valor de ese parametro. 
	 consulta.setParameter("elClienteId",7)
	 // cargamos en memoria toda la informacion del cliente que proviene de la consulta
	 Cliente elCliente = consulta.getSingleResult();

	System.out.printf("Cliente: %s", elCliente);

	
	// se ejecuta el commit de la transaccion
	miSession.getTransaction().commit();
	// cerramos la sesion 
	miSession.close();
	
	System.out.printf("Pedidos: %s", elCliente.getPedidos());
}catch (Exception e) {
	e.printStackTrace();
	
} finally {
	
	// cerramos la sessionFactory
	miFactory.close();
}

*/
