package cliente;

import java.util.HashMap;
import java.util.Map;

import modelo.Todo;

public enum TodoDao {
        instance;

        private Map<String, Todo> contentProvider = new HashMap<>();

        private TodoDao() {

                Todo todo = new Todo("1", "Learn REST");
                todo.setDescription("Read tutoriall");
                contentProvider.put("1", todo);
                todo = new Todo("2", "Do something");
                todo.setDescription("Read STiago GitHub");
                contentProvider.put("2", todo);

        }
        public Map<String, Todo> getModel(){
                return contentProvider;
        }

}
