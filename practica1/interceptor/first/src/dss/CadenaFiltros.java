package dss;

import java.util.ArrayList;
import java.util.List;

public class CadenaFiltros {
	private List<Filtro> filtros = new ArrayList<Filtro>();
	private Interfaz interfaz;
	
	public void addFiltro(Filtro filtro){
		filtros.add(filtro);
	}
	
	public void ejecutar(double peticion){
		for(Filtro filtro : filtros){
			filtro.ejecutar(peticion);
			System.out.println("Nueva velocidad(m/s)" + filtro.ejecutar(peticion));
        }
		interfaz.ejecutar(peticion);
	}
	
	public void setInterfaz(Interfaz interfaz){
		this.interfaz = interfaz;
	}
	
}
