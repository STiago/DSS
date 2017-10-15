package dss;

public class Calcular implements Filtro{
	//Mas contenido
	private double INTERVALO;
	public double revolAnt;
	
	public void Calcular(){
		INTERVALO = 11.1;
		revolAnt = 0.0;
	}
	
	public void setIntervalo(intervalo){
		INTERVALO = intervalo;
	}
	
	public void setRevol(revol){
		revolAnt = revol;
	}
	
	public double ejecutar(Object o){
		double distancia = (double) o;
		double velocidad = distancia*3600/INTERVALO;
		//revolAnt = revoluciones;
		return velocidad;
	}
}
