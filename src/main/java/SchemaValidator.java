import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public enum SchemaValidator {
    NON_NULL{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("NON_NULL_VALIDATION");
            for (Map.Entry<Integer, String> entry : fileData.entrySet()
                 ) {
                if (!(entry.getValue() != null && !(entry.getValue()).isEmpty())) {
                    System.out.println("Row " + entry.getKey()  + " is null or empty.");
                }
            }
            }

    },
    LENGTH{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("LENGTH_VALIDATION");
            for (Map.Entry<Integer, String> entry : fileData.entrySet()
            ) {
                if (entry.getValue().length() != 5) {
                  System.out.println("Row " + entry.getKey()  + "has invalid data. Length doesn't match");
                }
            }

        }
    },
    NULL{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("NULL_Validation");
        }
    },
    UNIQUE{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("Unique_Validation");

                Set<String> valueSet = new HashSet<>(fileData.values());

                if( valueSet.size() != fileData.size()){
                    System.out.println("values aren't unique");
                }



        }

    },
    BOOLEAN{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("Allowed_Validation");
            for (Map.Entry<Integer, String> entry : fileData.entrySet()
            ) {
                if (!("true".equalsIgnoreCase(entry.getValue()) || "false".equalsIgnoreCase(entry.getValue()))) {
                    System.out.println("Row " + entry.getKey()  + "Has value other than true or false");
                }
            }

        }
    };

public abstract void validate(Map<Integer,String> columnData);
}
