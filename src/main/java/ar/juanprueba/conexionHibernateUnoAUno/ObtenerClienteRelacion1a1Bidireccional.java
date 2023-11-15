package ar.juanprueba.conexionHibernateUnoAUno;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerClienteRelacion1a1Bidireccional {

	public static void main(String[] args) {
		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();
		
		try {

			// comenzamos la transaccion
			miSession.beginTransaction();
			
			//obtener DetallesCliente
			DetallesCliente detallesDeCliente = miSession.get(DetallesCliente.class, 1);
			System.out.println(detallesDeCliente);
			System.out.println(detallesDeCliente.getCliente());
			System.out.println("Ahora vamos a eliminar en cascada");
			// eliminamos en cascada boora los detalles y al cliente
			miSession.delete(detallesDeCliente);
			
			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			
		} finally {
			// tenemos que cerrar la sesion sea que hay un error o no para evitar un leak de memoria
			miSession.close();
			// cerramos la sessionFactory
			miFactory.close();
		}
	}

}
