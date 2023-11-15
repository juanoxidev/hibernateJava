package ar.juanprueba.conexionHibernateUnoAUno;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertarClienteRelacion1a1Unidireccional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();
		
		try {
			// creamos el objeto mapeado
			Cliente cliente1 = new Cliente("Juan","Oxinalde","Ramos Mejia 1023");
			DetallesCliente detallesCliente1 = new DetallesCliente("wwww.google.com.ar","555-555","ClienteDePrueba");
			//asociar los objetos
			cliente1.setDetallesCLlientes(detallesCliente1);
			
			// comenzamos la transaccion
			miSession.beginTransaction();
			
			// guarda la informacion en las dos tablas relacionadas persist = save
			miSession.save(cliente1);
			
			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en BBDD");
	
			// cerramos la sesion 
			miSession.close();
		
			
			System.out.println("terminado!");
			
		} finally {
			// cerramos la sessionFactory
			miFactory.close();
		}
	}

}
