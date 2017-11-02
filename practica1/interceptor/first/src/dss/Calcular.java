package dss;

public class Calcular implements Filtro{
	//Calcular velocidad 
	private double INTERVALO;
	
	public Calcular(){
		INTERVALO = 11.1;
	}
	
	public void setIntervalo(double intervalo){
		INTERVALO = intervalo;
	}
	
	public double ejecutar(Object o){
		double revol= (double) o;
		double velocidad = revol*3600/INTERVALO;		
		return velocidad;
	}
	
}
