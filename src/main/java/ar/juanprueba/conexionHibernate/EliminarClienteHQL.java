package ar.juanprueba.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminarClienteHQL {

	public static void main(String[] args) {
		// COMO ELIMINAR UN OBJETO MAPEADO EN LA BBDD CON HQL

		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();
			// consulta: Eliminar clientes donde el apellido sea Goya 
			miSession.createQuery("delete Cliente where apellido='Goya'").executeUpdate();

			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();

			// cerramos la sesion

			miSession.close();

			System.out.println("Registro eliminado correctamente en BBDD");

			miSession.getTransaction().commit();
		} finally {
			// cerramos la sessionFactory
			miFactory.close();
		}

	}


}
