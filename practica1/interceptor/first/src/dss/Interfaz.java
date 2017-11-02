package dss;

import java.io.IOException;
import java.net.URISyntaxException;
/*
public class Interfaz {
	public void ejecutar(Object peticion){
		System.out.println("Ejecutando: " + peticion); //Se puede descomenta y solo funcion el interceptor
		System.out.println("Fin: ");
	}

}*/


//Esta es la clase objetivo

public class Interfaz {
	private String URL = "http://localhost:8080/first/faces/index.jsp";
	
	public void ejecutar(Object obj) { //El objeto peticion
		System.out.println ("Empezamos la ejecución de la interfaz");
	
		if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
 
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                java.net.URI uri = null;
				try {
					uri = new java.net.URI(URL);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				try {
					desktop.browse(uri);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
		System.out.println ("Terminmos la ejecución de la interfaz");
		System.out.println("Ejecutando: " + obj);
	}
}
