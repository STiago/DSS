package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Usuario;

public class BDUsuario {
	private static final String PERSISTENCE_UNIT_NAME = "usuario";
	private static EntityManagerFactory factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factoria.createEntityManager();
	
	//Insertar un usuario pero si ya existe no hace nada
	public static void insertar(Usuario usuario) {
		
		EntityManager em = factoria.createEntityManager();
		
		//if (!existeEmail(usuario.getEmail())) {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
		/*}else{
			System.out.println ("");
		}*/
	}

	//Actualizar el usuaario
	public static void actualizar(Usuario usuario) {
		
		EntityManager em = factoria.createEntityManager();
		
	    //if (existeEmail(usuario.getEmail())) {
	    em.getTransaction().begin();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", usuario.getEmail());
			
		Usuario miresult = (Usuario) q.getSingleResult();
		miresult.setNombre(usuario.getNombre());
		miresult.setApellido(usuario.getApellido());
	
		//em.merge(miresult);
		em.getTransaction().commit();
		em.close();	
	}

	//Eliminar uno de los usuarios
	public static void eliminar(Usuario usuario) {
		
		EntityManager em = factoria.createEntityManager();
		
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", usuario.getEmail());
		
		Usuario miresult = (Usuario) q.getSingleResult();
			
		em.remove(miresult);
		em.getTransaction().commit();			
		em.close();	
	}

	//Recupera usuario
	public static Usuario seleccionarUsuario(String email) {
		
		EntityManager em = factoria.createEntityManager();
		
		Usuario miresult = null;
	
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		q.setParameter("email", email);
		miresult = (Usuario) q.getSingleResult();
		em.close();
		
		return miresult;
	}

	//Comprobar por medio del email que un usuario está
	public static boolean existeEmail(String email) {
		
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
	
	//Mostrar la lista de todos los usuarios que hay
	@SuppressWarnings("unchecked")
	public static List<Usuario> listarUsuarios() {
		
		EntityManager em = factoria.createEntityManager();
		
		Query q = em.createQuery("SELECT u FROM Usuario u");
		
		List<Usuario> miresult = q.getResultList();
		
		if(q!=null){
			System.out.println ("no vacio");
		}
		em.close();
		
		return miresult;
	}
}