package ar.juanprueba.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardaClientePrueba {

	public static void main(String[] args) {
		// COMO INSERTAR UN OBJETO MAPEADO EN LA BBDD
		
		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.buildSessionFactory();
		
		// inciamos una session
		Session miSession = miFactory.openSession();
		
		try {
			// creamos el objeto mapeado
			Cliente cliente1 = new Cliente("Juan","Oxinalde","Ramos Mejia 1023");
			// comenzamos la transaccion
			miSession.beginTransaction();
			
			// se ejecuta la transaccion
			miSession.save(cliente1);
			
			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();
			
			// cerramos la sesion 
			
			miSession.close();
			
			System.out.println("Registro insertado correctamente en BBDD");
			
			// Lectura de registro 
			
			miSession.beginTransaction();
			
			System.err.println("Lectua del registro con ID: " +cliente1.getId());
			
			Cliente clienteInsertado = miSession.get(Cliente.class, cliente1.getId());
			
			System.out.println("Registro: " + clienteInsertado);
			
			miSession.getTransaction().commit();
			
			System.out.println("terminado!");
			
		} finally {
			// cerramos la sessionFactory
			miFactory.close();
		}
	}

}
