package recursos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import modelo.Instrumento;
import modelo.InstrumentoDao;

// URL instrumentos
@Path("/instrumentos")
public class InstrumentosResource {
	
        @Context
        UriInfo uriInfo;
        @Context
        Request request;

        // Devuelve la lista d instrumentos en el browser
        @GET
        @Produces(MediaType.TEXT_XML)
        public List<Instrumento> getInstrumentosBrowser() {
                List<Instrumento> instrumentos = new ArrayList<Instrumento>();
                instrumentos.addAll(InstrumentoDao.instance.getModel().values());
                return instrumentos;
        }

        // Devuelve la lista de instrumentos para aplicaciones
        @GET
        @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
        public List<Instrumento> getInstrumentos() {
                List<Instrumento> instrumentos = new ArrayList<Instrumento>();
                instrumentos.addAll(InstrumentoDao.instance.getModel().values());
                return instrumentos;
        }

        /* Devuelve el numero de instrumentos
           Para el uso http://localhost:8080/SantiagoMariaVictoria-P3/rest/instrumentos/count
           devuelve el numero total de instrumentos guardados */
        @GET
        @Path("count")
        @Produces(MediaType.TEXT_PLAIN)
        public String getCount() {
                int count = InstrumentoDao.instance.getModel().size();
                return String.valueOf(count);
        }

        @POST
        @Produces(MediaType.TEXT_HTML)
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public void newInstrumento(@FormParam("id") String id,
                        @FormParam("nombre") String nombre,
                        @FormParam("clasificacion") String clasificacion,
                        @FormParam("description") String description,
                        @Context HttpServletResponse servletResponse) throws IOException {
                Instrumento instrumento = new Instrumento(id, nombre, clasificacion);
                if (description != null) {
                        instrumento.setDescription(description);
                }
                InstrumentoDao.instance.getModel().put(id, instrumento);

                servletResponse.sendRedirect("../create_instrumento.html");
        }

        // Ejemplo para ver el primero http://localhost:8080/SantiagoMariaVictoria-P3/rest/instrumentos/1
        @Path("{instrumento}")
        public InstrumentoResource getInstrumento(@PathParam("instrumento") String id) {
                return new InstrumentoResource(uriInfo, request, id);
        }

}
