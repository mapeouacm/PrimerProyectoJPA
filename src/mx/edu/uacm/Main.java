package mx.edu.uacm;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mx.edu.uacm.dominio.Usuario;
import mx.edu.uacm.dominio.enumeraciones.EstadoUsuario;

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
		usr1.setFechaNacimiento(LocalDate.now());
		usr1.setStatus(EstadoUsuario.ACTIVO);
		
		em.persist(usr1);
		
		//Commit de la transaccion
		em.getTransaction().commit();
		
		//abrio
		em.getTransaction().begin();
		
		Usuario usuarioRecuperado = em.find(Usuario.class, 1L);
		usuarioRecuperado.setMensajeUsuario("Otro mensaje");
		Usuario usr2 = new Usuario();
		//usr1.setId(1L);
		usr2.setNombreUsuario("Usr2");
		usr2.setMensajeUsuario("Otro mensaje");
		usr2.setFechaNacimiento(LocalDate.now());
		usr2.setStatus(EstadoUsuario.INACTIVO);
		em.persist(usr2);
		
		em.getTransaction().commit();
		
		
		//Cerrar el entitymanager
		em.close();
		
		
	}
}
