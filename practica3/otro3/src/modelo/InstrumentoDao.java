package modelo;

import java.util.HashMap;
import java.util.Map;

public enum InstrumentoDao {
        instance;

        private Map<String, Instrumento> contentProvider = new HashMap<>();

        private InstrumentoDao() {

                Instrumento instrumento = new Instrumento("1", "Learn REST");
                instrumento.setDescription("Lectura");
                contentProvider.put("1", instrumento);
                instrumento = new Instrumento("2", "Do something");
                instrumento.setDescription("Hace algo");
                contentProvider.put("2", instrumento);

        }
        public Map<String, Instrumento> getModel(){
                return contentProvider;
        }

}


