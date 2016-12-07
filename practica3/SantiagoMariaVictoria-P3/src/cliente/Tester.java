package cliente;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import modelo.Instrumento;

public class Tester {
  public static void main(String[] args) {
	  
          ClientConfig config = new ClientConfig();
          Client client = ClientBuilder.newClient(config);
          WebTarget service = client.target(getBaseURI());
          
          // Crea un 3º objeto Instrumento (hay otros 2 ya creados)
          Instrumento instrumento = new Instrumento(" 3 ", " Guitarra ", " Punteadas ");
          Response response = service.path("rest").path("instrumentos").path(instrumento.getId()).request(MediaType.APPLICATION_XML).put(Entity.entity(instrumento,MediaType.APPLICATION_XML),Response.class);
          
          System.out.println("Hecho");
          // Al crearlo devuelve  201 == created resource
          System.out.println(response.getStatus());

          // Muestra con el contenido del recource instrumentos en formato XML
          System.out.println(service.path("rest").path("instrumentos").request().accept(MediaType.TEXT_XML).get(String.class));

//          // Devuelve JSON de la aplicacion
//          System.out.println(service.path("rest").path("instrumentos").request().accept(MediaType.APPLICATION_JSON).get(String.class));

          // Devuelve XML de la aplicacion
          System.out.println(service.path("rest").path("instrumentos").request().accept(MediaType.APPLICATION_XML).get(String.class));

          //Devuelve Instrumento con id 1
          Response checkDelete = service.path("rest").path("instrumentos/1").request().accept(MediaType.APPLICATION_XML).get();

          //Elimina Instrumento con id 1
          service.path("rest").path("instrumentos/1").request().delete();

          //Get get all Instrumento id 1 should be deleted
          System.out.println(service.path("rest").path("instrumentos").request().accept(MediaType.APPLICATION_XML).get(String.class));

          //Crear un  Instrumento con formulario
          Form form =new Form();
          form.param("id", " 4 ");
          form.param("nombre"," Violin ");
          form.param("clasificacion", " Frotado ");
          response = service.path("rest").path("instrumentos").request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),Response.class);
          System.out.println("Respuesta " + response.getStatus());

          //Devuelve instrumentos los que hay en Instrumento, el que tiene id 4 deberia de haberse creado
          System.out.println("Contenido del recurso actualizado");
          System.out.println(service.path("rest").path("instrumentos").request().accept(MediaType.APPLICATION_XML).get(String.class));

  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/SantiagoMariaVictoria-P3").build();
  }
}
