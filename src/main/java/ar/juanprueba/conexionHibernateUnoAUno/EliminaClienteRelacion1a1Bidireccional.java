package ar.juanprueba.conexionHibernateUnoAUno;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminaClienteRelacion1a1Bidireccional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// iniciamos la session Factory
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(DetallesCliente.class).buildSessionFactory();

		// inciamos una session
		Session miSession = miFactory.openSession();
		
		try {

			// comenzamos la transaccion
			miSession.beginTransaction();
			
			//obtener el cliente a eliminar: usamos get. pasamos como parametro la clase .class y el numero de id  
			Cliente clienteAEliminar = miSession.get(Cliente.class, 1);
			
			// si existe un cliente con el id que pase, que lo elimine .delete (deprecado) = a 
			if(clienteAEliminar != null) {
				miSession.delete(args);
				System.out.println("Registro eliminado correctamente en BBDD");
			}
			
			System.out.printf("No se encontro el cliente con ese ID en la BBDD");
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
