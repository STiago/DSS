package modelo;

import modelo.Instrumento;

import java.util.HashMap;
import java.util.Map;

public enum InstrumentoDao {
	    //Implementamos el patron singleton
        instance;

        private Map<String, Instrumento> contentProvider = new HashMap<>();

        private InstrumentoDao() {

                Instrumento instrumento = new Instrumento(" 1 ", " Oboe ", " Madera ");
                instrumento.setDescription("Viento");
                contentProvider.put("1", instrumento);
                instrumento = new Instrumento(" 2 ", " Sistro ", " Metal ");
                instrumento.setDescription("Percusion");
                contentProvider.put("2", instrumento);
                instrumento = new Instrumento(" 3 ", " Piano ", " Golpeado ");
                instrumento.setDescription("Percusion");
                contentProvider.put("3", instrumento);

        }
        public Map<String, Instrumento> getModel(){
                return contentProvider;
        }

}


