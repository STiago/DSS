package modelo;

import java.util.HashMap;
import java.util.Map;

public enum TodoDao {
        instance;

        private Map<String, Todo> contentProvider = new HashMap<>();

        private TodoDao() {

                Todo todo = new Todo("1", "Learn REST");
                todo.setDescription("Lectura");
                contentProvider.put("1", todo);
                todo = new Todo("2", "Do something");
                todo.setDescription("Hace algo");
                contentProvider.put("2", todo);

        }
        public Map<String, Todo> getModel(){
                return contentProvider;
        }

}


