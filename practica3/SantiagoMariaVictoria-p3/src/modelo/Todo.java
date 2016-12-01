package modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo {
        private String id;
        private String autor;
        private String description;

        public Todo(){

        }
        public Todo (String id, String autor){
                this.id = id;
                this.autor = autor;
        }
        public String getId() {
                return id;
        }
        public void setId(String id) {
                this.id = id;
        }
        public String getautor() {
                return autor;
        }
        public void setautor(String autor) {
                this.autor = autor;
        }
        public String getDescription() {
                return description;
        }
        public void setDescription(String description) {
                this.description = description;
        }
}
