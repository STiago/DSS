package jpa.simple.main;

import
import
import
import
import
import
java.util.List;
javax.persistence.EntityManager;
javax.persistence.EntityManagerFactory;
javax.persistence.Persistence;
javax.persistence.Query;
jpa.simple.modelo.Completo;

public class Principal {
	private static final String PERSISTENCE_UNIT_NAME = "tutorialJPA";
	private static EntityManagerFactory factoria;
	public static void main(String[] args) {
		factoria = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factoria.createEntityManager();
		// leer las entradas existentes y escribir en la consola
		Query q = em.createQuery("select t from Completo t");
		//Crearse una lista con template: "Completo" a la que asignameros el resultado de la consulta
		//en la base de datos ("q.getResultList()"
		//Iterar en la lista e imprimir las instancias "completo"
		//Ahora imprimimos el numero de registros que tiene ya la base de datos
		System.out.println("Tamano: " + listaCompleto.size());
		//Ahora vamos a trabajar con una transaccion en la base de datos
		em.getTransaction().begin();
		//Crearse una instancia de completo y utilizar los metodos "setResumen()" y "setDescripcion()"
		//Posteriormente hay que decir al gestor de entidad (em) que la instancia va a ser persistente;
		//conseguir la transaccion ("em.getTransaction()") y hacerla definitiva ("commit()")
		//Por ultimo, hay que cerrar al gestor de entidad
		em.close();
	}
}
