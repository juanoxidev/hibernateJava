package ar.juanprueba.conexionHibernateUnoAUno;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaDetallesCliente {

	public static void main(String[] args) {
		// Tira error si el cliente ya tiene asociado un detallecliente

		
		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();
		
		try {

			// comenzamos la transaccion
			miSession.beginTransaction();
			
			//obtener el detalle del cliente a eliminar: usamos get. pasamos como parametro la clase .class y el numero de id  
			DetallesCliente detalleDelCliente = miSession.get(DetallesCliente.class, 1);
			
			// si existe un cliente con el id que pase, que lo elimine .delete (deprecado) = a 
			if(detalleDelCliente != null) {
				miSession.delete(detalleDelCliente);
				System.out.println("Registro eliminado correctamente en BBDD");
			}
			
			System.out.printf("No se encontro detalle del cliente con ese ID en la BBDD");
			// se ejecuta el commit de la transaccion
			miSession.getTransaction().commit();
			
			// cerramos la sesion 
			miSession.close();
			
		} finally {
			// cerramos la sessionFactory
			miFactory.close();
		}
	}

}
