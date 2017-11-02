package dss;

public class Cliente {
	GestorFiltros gestorFiltros;
	
	public void setGestorFiltros(GestorFiltros gestFiltros){
		this.gestorFiltros = gestFiltros;
	}
	
	public void enviarPeticion(double peticion){
		gestorFiltros.filterRequest(peticion);
	}
}
