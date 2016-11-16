package modelo;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.TABLE)
	private long id; //Identificador numerico del usuario
	private String nombre;//nombre del usuario
	private String apellido;//appellidos del usuario
	private String email;//su direccion de correo electronico
    //Constructores
	//Para construir un usuario vacio
	public Usuario() {	
		nombre = "";
		apellido = "";
		email = "";
	}
	
	//Constructor de copia
	public Usuario(Usuario us) {
		this.nombre = us.getNombre();
		this.apellido = us.getApellido();
		this.email = us.getEmail();
	}
	
	//Metodos get y set
	//Consultar Id del usuario
	public long getId() {
		return id;
	}
	
	//Insertar Id del usuario
	public void setId(long id) {
		this.id = id;
	}
	
	//Consultar Nombre del usuario
	public String getNombre() {
		return nombre;
	}

	//Insertar el nombre del usuario
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Consultar apellido del usuario
	public String getApellido() {
		return apellido;
	}

	//Insertar el apellido del usuario
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	//Consultar el email del usuario
	public String getEmail() {
		return email;
	}

	//Insertar el email del usuario
	public void setEmail(String email) {
		this.email = email;
	}
	
    //Modificador @override
	@Override
	public String toString() {
		return "Usuario:" + nombre + " " + apellido + " − " + email ; 
	}	
}