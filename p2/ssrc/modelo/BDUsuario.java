package modelo;
//import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Usuario;

public class BDUsuario {
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private static EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entitymanager = factoria.createEntityManager();
	
	//Insertar un usuario; si ya existe, no tiene efecto.
	public static void insertar(Usuario usuario) {
		if (!existeEmail(usuario.getEmail())) {
			entitymanager.getTransaction().begin();
			entitymanager.persist(usuario);
			entitymanager.getTransaction().commit();
			entitymanager.close();
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
		/*
		Usuario resultado = null;

		if (existeEmail(email)) {
			Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
			q.setParameter("email", email);
			resultado = (Usuario) q.getSingleResult();
			em.close();
		}
		
		return resultado;*/
	}

	//Comprobar que existe el usuario cuyo email pasamos como argumento
	public static boolean existeEmail(String email) {
		/*
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", email);
		
		try {
			q.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		} finally {
			em.close();
		}*/
	}
	
	//Listar los usuarios de la base de datos
	public static List<Usuario> listarUsuarios() {
		/*
		Query q = em.createQuery("SELECT u FROM Usuario u");
		
		@SuppressWarnings("unchecked")
		List<Usuario> resultado = q.getResultList();
		em.close();
		
		return resultado;*/
	}
}