package dss;

public class CalcularDistancia implements Filtro{
	//Calcular distancia
	private double RADIO;
	private double revolAnt;
	private double PI = 3.1416;
	
	public CalcularDistancia(){
		RADIO = 2.7;
		revolAnt = 0.0;	
	}
	
	public void setRevol(double revol){
		revolAnt = revol;
	}
	
	public double ejecutar(Object o){
		double revol= (double) o;
		double distancia = (revol- revolAnt)*2*RADIO*PI;
		return distancia;
	}
	
}
