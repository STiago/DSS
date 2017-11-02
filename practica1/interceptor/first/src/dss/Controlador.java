package dss;

import java.io.Serializable;

public class Controlador implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private double INTERVALO = 15.6;
	private double distancia;
    private double velocidad;
    private boolean initial= true;
    private boolean encendido = false;
    private String texto = "Encender";
    private String opcion;
    private String textoAcelerar;
    private String textoEstado = "Apagado";
    private String color;

    
    public Controlador() {
    	initial= true;
    	encendido = false;
    	texto = "Encender";
    	textoEstado="Apagado";
    	textoAcelerar = "Acelerar";
    	color = "color:blue";
    }
    
    public void setColor(String col){
    	color = col;
    }
    
    public String getColor(){
    	return color;
    }
    
    public boolean getEncendido(){
    	return encendido;
    }
    public void setEncendido(boolean encend){
    	this.encendido = encend;
    }
    public String getTexto(){
    	return texto;
    }
    public void setTexto(String txt){
    	this.texto = txt;
    }
    public double getdistancia() {
        return distancia;
    }
    public void setdistancia(double distancia) {
        this.distancia = distancia;
    }
    public double getvelocidad() {
        return velocidad;
    }

    public boolean getInitial(){
        return initial;
    }

    public String reset (){
    	encendido = false;
        initial = true;
        velocidad = 0;
        distancia = 0;
        texto = "Encender";
        textoEstado = "Apagado";
        textoAcelerar = "Acelerar";
        color = "color:red";
        return "reset";
    }
    public String distanciaTovelocidad(){
    	if(distancia == 0){
    		distancia = 0;
		}
        initial = false;
        velocidad = distancia * 3600 / INTERVALO;
        return "calculated";
    }
    
    public String Encender(){
    	String veloc;
    	initial = false;
    	encendido = true;
    	texto = "Apagar";
    	textoEstado = "Encendido";
    	color="color:blue";
    	veloc = distanciaTovelocidad();
    	System.out.println(texto);
    	System.out.println(textoEstado);
    	return veloc;// "Encendido!";
    }
    public String Apagar(){
    	initial = true;
    	encendido = false;
    	texto = "Encender";
    	textoEstado = "Apagado";
    	textoAcelerar = "Acelerar";
    	color = "color:red";
    	System.out.println(texto);
    	System.out.println(textoEstado);
    	return "Apagado!";
    }
    
    public String Acelerar(){
    	if(encendido==true){
    		textoAcelerar = "Acelerando";
    		textoEstado = "Acelerando";
    		System.out.println(textoAcelerar);
    	}
    	return textoAcelerar;
    }
    
    public String getTextoAcelerar() {
		return textoAcelerar;
	}

	public void setTextoAcelerar(String textoAcelerar) {
		this.textoAcelerar = textoAcelerar;
	}

	public String getTextoEstado() {
		return textoEstado;
	}

	public void setTextoEstado(String textoEstado) {
		this.textoEstado = textoEstado;
	}

	public String Opciones(){
    	if(encendido == false){
    		opcion = Encender();
    		
    	}else{
    		opcion = Apagar();
    	}
    	return opcion;
    }
}
