package jpa.eclipselink.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	private String nombre;
	private String apellidos;
	private Familia familia;
	private List<Empleo> listaEmpleos = new ArrayList<Empleo>();
	...
	@ManyToOne
	public Familia getFamilia() {
	return familia;
	}
	...
	@OneToMany
	public List<Empleo> listaEmpleos() {
	return this.listaEmpleos;
	}
	...
}