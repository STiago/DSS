package dss;

public class CalcularDistancia implements Filtro {
	//Mas contenido
	private double RADIO;
	private double PI = 3.1416;
	public double revolAnt;
	
	public void CalcularDistancia(){
		RADIO = 12.1;
		revolAnt = 0.0;
	}
	
	public void setRadio(nuevo_radio){
		RADIO = nuevo_radio;
	}
	
	public void setRevol(nuevo_revol){
		revolAnt = nuevo_revol;
	}
	
	public double ejecutar(Objet o){
		double revoluciones = (double) o;
		double distancia = (revoluciones-revolAnt)*2∗RADIO∗PI;
		return distancia;
	}

}

