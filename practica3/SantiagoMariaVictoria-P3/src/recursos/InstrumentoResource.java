package recursos;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import modelo.Instrumento;
import modelo.InstrumentoDao;

public class InstrumentoResource {
        @Context
        UriInfo uriInfo;
        @Context
        Request request;
        String id;
        public InstrumentoResource(UriInfo uriInfo, Request request, String id) {
                this.uriInfo = uriInfo;
                this.request = request;
                this.id = id;
        }

        //Integracion
        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Instrumento getInstrumento() {
                Instrumento instrumento = InstrumentoDao.instance.getModel().get(id);
                if(instrumento==null)
                        throw new RuntimeException("Get: Instrumento con " + id +  " no encontrado");
                return instrumento;
        }

        @GET
        @Produces(MediaType.TEXT_XML)
        public Instrumento getInstrumentoHTML() {
                Instrumento instrumento = InstrumentoDao.instance.getModel().get(id);
                if(instrumento==null)
                        throw new RuntimeException("Get: Instrumento con " + id +  " no encontrado");
                return instrumento;
        }

        @PUT
        @Consumes(MediaType.APPLICATION_XML)
        public Response putInstrumento(JAXBElement<Instrumento> instrumento) {
                Instrumento c = instrumento.getValue();
                return putAndGetResponse(c);
        }

        @DELETE
        public void deleteInstrumento() {
                Instrumento c = InstrumentoDao.instance.getModel().remove(id);
                if(c==null)
                        throw new RuntimeException("Delete: Instumento con " + id +  " no encontrado");
        }

        private Response putAndGetResponse(Instrumento instrumento) {
                Response res;
                if(InstrumentoDao.instance.getModel().containsKey(instrumento.getId())) {
                        res = Response.noContent().build();
                } else {
                        res = Response.created(uriInfo.getAbsolutePath()).build();
                }
                InstrumentoDao.instance.getModel().put(instrumento.getId(), instrumento);
                return res;
        }
}
