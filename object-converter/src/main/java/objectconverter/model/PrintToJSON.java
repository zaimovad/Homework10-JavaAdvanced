package objectconverter.model;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class PrintToJSON {

    ObjectMapper mapper = new ObjectMapper();


    public void printJSON(Object obj) {
        try {

            mapper.writeValue(System.out, obj);

            String jsonInString = mapper.writeValueAsString(obj);
            System.out.println(jsonInString);

            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(jsonInString);


        } catch (JsonGenerationException e1) {
            e1.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

}

