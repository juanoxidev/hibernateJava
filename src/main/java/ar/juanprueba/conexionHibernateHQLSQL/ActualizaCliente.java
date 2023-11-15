package ar.juanprueba.conexionHibernateHQLSQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaCliente {

	public static void main(String[] args) {
		// COMO ACTUALIZAR UN OBJETO MAPEADO EN LA BBDD

		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();

		try {

			int ClienteId = 1;

			miSession.beginTransaction();

			// agarro de la bd el cliente con el id que estoy buscando y lo guard en
			// variable cliente.

			Cliente miCliente = miSession.get(Cliente.class, ClienteId);

			// modifico al cliente

			miCliente.setNombre("Pepe");

			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();

			// cerramos la sesion

			miSession.close();

			System.out.println("Registro actualizado correctamente en BBDD");

			miSession.getTransaction().commit();
		} finally {
			// cerramos la sessionFactory
			miFactory.close();
		}

	}

}
