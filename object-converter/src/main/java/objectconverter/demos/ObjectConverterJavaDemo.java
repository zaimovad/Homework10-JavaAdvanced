package objectconverter.demos;

import objectconverter.model.PrintToJSON;
import objectconverter.model.TestObject;

public class ObjectConverterJavaDemo {

    public static void main(String[] args) {

        PrintToJSON print = new PrintToJSON();

        TestObject obj = createTestObject();
        print.printJSON(obj);

    }

    private static TestObject createTestObject() {
        TestObject obj = new TestObject();
        obj.setFirstName("Larry");
        obj.setFamilyName("King");
        obj.setAge(84);
        obj.setIdNumber(563327865);

        return obj;
    }

}

