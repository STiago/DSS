package dss;

public class DemoInterceptor {
	 public static void main(String[] args){
		 GestorFiltros gestorFiltros = new GestorFiltros(new Interfaz());
		 gestorFiltros.setFiltro(new Calcular());
		 Cliente cliente = new Cliente();
		 cliente.setGestorFiltros(gestorFiltros);
		 cliente.enviarPeticion(500);  //numero inicial de vueltas del eje
		 }
}
