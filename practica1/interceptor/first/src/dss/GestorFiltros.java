package dss;

public class GestorFiltros {
	CadenaFiltros cadenaFiltros;
	
	public GestorFiltros(Interfaz interfaz){
		cadenaFiltros = new CadenaFiltros();
		cadenaFiltros.setInterfaz(interfaz);
	}
	
	public void setFiltro(Filtro filtro){
		cadenaFiltros.addFiltro(filtro);
	}
	
	public void filterRequest(double peticion){
		cadenaFiltros.ejecutar(peticion);
	}
}
