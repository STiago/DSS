package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Usuario;

public class BDUsuario {
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private static EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factoria.createEntityManager();
	
	//Insertar un usuario pero si ya existe no hace nada
	public static void insertar(Usuario usuario) {
		factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factoria.createEntityManager();
		
		if (!existeEmail(usuario.getEmail())) {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
		}else{
			System.out.println ("");
		}
	}

	//Actualizar los datos de un usuario en la base de datos
	public static void actualizar(Usuario usuario) {
	/*	if (existeEmail(usuario.getEmail())) {
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
			q.setParameter("email", usuario.getEmail());
			
			Usuario resultado = (Usuario) q.getSingleResult();
			resultado.setNombre(usuario.getNombre());
			resultado.setApellido(usuario.getApellido());
			
			em.getTransaction().begin();
			em.merge(resultado);
			em.getTransaction().commit();
			em.close();
		}*/
	}

	//Eliminar un usuario de la base de datos
	public static void eliminar(Usuario usuario) {
		/*if (existeEmail(usuario.getEmail())) {
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
			q.setParameter("email", usuario.getEmail());

			Usuario resultado = (Usuario) q.getSingleResult();
			
			em.getTransaction().begin();
			em.remove(resultado);
			em.getTransaction().commit();			
			em.close();
		}*/
	}

	//Recuperar un usuario desde la base de datos
	public static Usuario seleccionarUsuario(String email) {
		EntityManager em = factoria.createEntityManager();
		
		Usuario miresult = null;
		/*
		if (existeEmail(email)) {
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
			q.setParameter("email", email);
			resultado = (Usuario) q.getSingleResult();
			em.close();
		}
		*/
		return miresult;
	}

	//Comprobar que existe el usuario cuyo email pasamos como argumento
	public static boolean existeEmail(String email) {
		factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factoria.createEntityManager();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", email);
		
		if(q!=null){
			q.getResultList();
			q.getSingleResult();
			em.close();
			return true;
		}else{
			em.close();
			return false;
		}
		
	}
	
	//Listar los usuarios de la base de datos
	public static List<Usuario> listarUsuarios() {
		
		EntityManager em = factoria.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u");
		
		@SuppressWarnings("unchecked")
		List<Usuario> miresult = q.getResultList();
		
		if(q!=null){
			System.out.println ("no vacio");
		}
		em.close();
		
		return miresult;
	}
}