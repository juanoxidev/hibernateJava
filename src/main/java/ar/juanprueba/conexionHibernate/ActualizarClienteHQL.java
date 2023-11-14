package ar.juanprueba.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizarClienteHQL {

	public static void main(String[] args) {
		// COMO ACTUALIZAR UN OBJETO MAPEADO EN LA BBDD CON HQL

		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();

		try {

			miSession.beginTransaction();
			// consulta: cambiar a Dominguez el apellido de los clientes que empiecen con D 
			miSession.createQuery("update Cliente set apellido='Dominguez where apellido LIKE 'D%'").executeUpdate();

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

