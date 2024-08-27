import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class ValidationWrapper {
    public void validateCSVData(Map<Integer,String> columnData, String column,String jsonFilePath){
        JSONObject jsonObject = new JSONObject(jsonFilePath);
        Object value = null;
        try {
             value = jsonObject.get(column);
            }catch (JSONException e)
           {
                System.out.println("No validations required for the column");
                return;
            }
            JSONObject newJsonObject = (JSONObject) value;


            for (String newKey: newJsonObject.keySet()
            ) {
                if(newKey.equalsIgnoreCase(SchemaValidator.LENGTH.name())){
                    SchemaValidator.LENGTH.setLength(newJsonObject.getInt(newKey));
                    SchemaValidator validator = SchemaValidator.LENGTH;
                        validator.validate(columnData);

                }
                else if(newKey.equalsIgnoreCase(SchemaValidator.UNIQUE.name())){
                    SchemaValidator validator = SchemaValidator.UNIQUE;
                    validator.validate(columnData);

                }
                else if(newKey.equalsIgnoreCase(SchemaValidator.NON_NULL.name())){
                    SchemaValidator validator = SchemaValidator.NON_NULL;
                    validator.validate(columnData);

                }
                else if(newKey.equalsIgnoreCase(SchemaValidator.BOOLEAN.name())){
                    SchemaValidator validator = SchemaValidator.BOOLEAN;
                    validator.validate(columnData);

                }

                else{
                    System.out.println("Validation not implemented for " + newKey);
                }
            }

    }
}
