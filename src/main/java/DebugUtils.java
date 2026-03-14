import com.fasterxml.jackson.databind.ObjectMapper;

public class DebugUtils {
    public static void dump(Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(json);
        } catch (Exception e) {
            System.err.println("Impossible de sérialiser l'objet : " + e.getMessage());
        }
    }
}