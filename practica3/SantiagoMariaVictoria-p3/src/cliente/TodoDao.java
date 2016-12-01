/*Este es el de tests*/
package cliente;

import java.util.HashMap;
import java.util.Map;

import modelo.Todo;

public enum TodoDao {
        instance;

        private Map<String, Todo> contentProvider = new HashMap<>();

        private TodoDao() {

                Todo todo = new Todo("1", "Learn REST");
                todo.setDescription("Leer tutorial");
                contentProvider.put("1", todo);
                todo = new Todo("2", "Do something");
                todo.setDescription("Leer informacion de STiago GitHub");
                contentProvider.put("2", todo);

        }
        public Map<String, Todo> getModel(){
                return contentProvider;
        }

}
