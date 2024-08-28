
import org.testng.Reporter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public enum SchemaValidator {
    NON_NULL{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("NON_NULL_VALIDATION_STARTED");
            for (Map.Entry<Integer, String> entry : fileData.entrySet()
                 ) {
                if (!(entry.getValue() != null && !(entry.getValue()).isEmpty())) {
                    System.out.println("Row " + entry.getKey()  + " is null or empty.");
                }
            }
            System.out.println("NON_NULL_VALIDATION_ENDED");
            }

    },
    LENGTH{
        private int length;

        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("LENGTH_VALIDATION_STARTED");
            for (Map.Entry<Integer, String> entry : fileData.entrySet()
            ) {
                if (entry.getValue().length() != length) {
                  System.out.println("Row " + entry.getKey()  + "has invalid data. Length doesn't match");
                }
            }
            System.out.println("LENGTH_VALIDATION_ENDED");

        }

        public void setLength(int length) {
            this.length = length;
        }
    },
    NULL{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("NULL_Validation_STARTED");
            System.out.println("NULL_Validation_ENDED");
        }
    },
    UNIQUE{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("Unique_Validation_Started");

                Set<String> valueSet = new HashSet<>(fileData.values());

                if( valueSet.size() != fileData.size()){
                    System.out.println("values aren't unique");
                    Reporter.log("values aren't unique");
                }

            System.out.println("Unique_Validation_Ended");

        }

    },
    BOOLEAN{
        @Override
        public void validate(Map<Integer,String> fileData) {
            System.out.println("Boolean_Validation_Started");
            for (Map.Entry<Integer, String> entry : fileData.entrySet()
            ) {
                if (!("true".equalsIgnoreCase(entry.getValue()) || "false".equalsIgnoreCase(entry.getValue()))) {
                    System.out.println("Row " + entry.getKey()  + "Has value other than true or false");
                }
            }
            System.out.println("Boolean_Validation_Ended");

        }
    };

public abstract void validate(Map<Integer,String> columnData);

    public void setLength(int i) {
    }
}
