package mx.edu.uacm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mx.edu.uacm.dominio.Usuario;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PrimerProyectoJPA");
		EntityManager em = factory.createEntityManager();
		
		//iniciar una transaccion
		em.getTransaction().begin();
		
		//Construir un objeto
		Usuario usr1 = new Usuario();
		//usr1.setId(1L);
		usr1.setNombreUsuario("Usr1");
		usr1.setMensajeUsuario("Hola");
		
		em.persist(usr1);
		
		//Commit de la transaccion
		em.getTransaction().commit();
		
		//Cerrar el entitymanager
		em.close();
		
		
	}
}
