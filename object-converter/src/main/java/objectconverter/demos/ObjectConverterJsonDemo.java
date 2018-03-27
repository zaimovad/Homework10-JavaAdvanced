package objectconverter.demos;

import objectconverter.model.PrintToJSON;
import objectconverter.model.TestObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectConverterJsonDemo {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        PrintToJSON print = new PrintToJSON();

        String json = "{\"firstName\":\"Ariel\",\"familyName\":\"Martins\",\"age\":34,\"idNumber\":2369841}";

        try
        {
            TestObject obj2 = mapper.readValue(json, TestObject.class);
            print.printJSON(obj2);
        }
        catch (JsonGenerationException e)
        {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
