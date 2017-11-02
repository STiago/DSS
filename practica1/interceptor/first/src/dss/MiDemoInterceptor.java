package dss;

public class MiDemoInterceptor {
	public static void main(String[] args){
		 GestorFiltros gestorFiltros = new GestorFiltros(new Interfaz());
		 System.out.println("Gestor de filtros.");
		 gestorFiltros.setFiltro(new Calcular());
		 System.out.println("Calculando.");
		 Cliente cliente = new Cliente();
		 cliente.setGestorFiltros(gestorFiltros);
		 System.out.println("Envindo peticion.");
		 cliente.enviarPeticion(500); //numero inicial de vueltas del eje
		 }
}
