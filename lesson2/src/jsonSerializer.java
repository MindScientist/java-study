import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jsonSerializer {

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("cardId", "6726fe23");
        map.put("count", "2");
        map.put("cardId", "6722fe23");
        map.put("count", "3");

        List<Map> arr = new ArrayList<>();
        arr.add(map);

        Map<String, List<Map>> dupl = new TreeMap<>();
        dupl.put("duplicates", arr);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, dupl);
        System.out.println(writer.toString());
    }
}
