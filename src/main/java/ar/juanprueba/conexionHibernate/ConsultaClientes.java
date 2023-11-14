package ar.juanprueba.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {
	// iniciamos la session Factory
	SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();

	// inciamos una session
	Session miSession = miFactory.openSession();

	try{

		// comenzar sesion
		miSession.beginTransaction();

		// consulta de clientes

		// consulta: traeme todos los clientes de la bbdd
		List<Cliente> losClientes = miSession.createQuery("from cliente", Cliente.class).list();

		// mostramos los clientes
		for (Cliente c : losClientes) {
			System.out.println(c);
		}
		
		// consulta: dame los clientes de apellido gomez, usamos como filtro la propiedad de la clase NO DE LA TABLA.
		List<Cliente> losClientes2 = miSession.createQuery("from cliente c where c.apellido='gomez'", Cliente.class).list();
		// mostrar los gomez 
		for (Cliente c : losClientes2) {
			System.out.println(c);
		}
		
		// consulta: muestra lo que viven en Gran Via o que se apellidan Delgado
		List<Cliente> losClientes3 = miSession.createQuery("from cliente c where c.apellido='delgado' or c.direccion='Gran Via'", Cliente.class).list();
		// mostrar los gomez 
		for (Cliente c : losClientes3) {
			System.out.println(c);
		}
		// commit 
		miSession.getTransaction().commit();
		
		// cerramos session
		miSession.close();
		
	
	}finally{
		// cerramos la sessionFactory
		miFactory.close();
	}
}
}


