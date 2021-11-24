package io.pivotal.sporing.todos.todolist;

    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.springframework.stereotype.Component;

    import java.util.function.Function;

@Component("SerializedTodoImport")
    public class SerializedTodoImport implements Function<String, SerializedTodoImportResponse> {

        @Override
        public SerializedTodoImportResponse apply(String input) {
            ObjectMapper om = new ObjectMapper();

            try {
                ImportTodo i = om.readValue(input, ImportTodo.class);
            } catch (Exception e) {
                System.out.println("Exception was");
                e.printStackTrace(System.out);
            }

            return new SerializedTodoImportResponse();
        }
    }

    class ImportTodo {

    private Object obj;
        ImportTodo() {
    }

    public ImportTodo(Object obj) {

        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object ob) {
        this.obj = obj;
    }

}
