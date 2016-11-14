package jpa.eclipselink.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleo {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private double salario;
	private String descripcionTrabajo;
	
	...
}
