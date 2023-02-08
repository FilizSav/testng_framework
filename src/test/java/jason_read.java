import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class jason_read {
        public static void main(String[] args) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File("src/Jason/filiz.json"));

            // Iterate over all the fields in the root node
            rootNode.fields().forEachRemaining(field -> {
                System.out.println(field.getKey() + ": " + field.getValue());
            });

        ObjectMapper mapper1 = new ObjectMapper();
        File[] files = new File[]{new File("src/Jason/filiz.json"), new File("src/Jason/volkan.json"), new File("src/Jason/osman.json")};
        ObjectNode rootNode1 = mapper.createObjectNode();

        // Iterate over all the files in the array
            for (File file : files) {
                JsonNode node = mapper1.readTree(file);
                rootNode1.setAll((ObjectNode) node);
            }

        System.out.println(rootNode.toString());
    }
}