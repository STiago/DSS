package modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Instrumento {
        private String id;
        private String nombre;
        private String clasificacion;
        private String description;

        public Instrumento(){

        }
        public Instrumento (String id, String nombre, String clasificacion){
                this.id = id;
                this.nombre = nombre;
                this.clasificacion = clasificacion;
        }
        public String getId() {
                return id;
        }
        public void setId(String id) {
                this.id = id;
        }
        public String getnombre() {
                return nombre;
        }
        public void setnombre(String nombre) {
                this.nombre = nombre;
        }
        public String getClasificacion(){
        		return clasificacion;
        }
        public void setClasificacion(){
        	   this.clasificacion = clasificacion;
        }
        public String getDescription() {
                return description;
        }
        public void setDescription(String description) {
                this.description = description;
        }
}
