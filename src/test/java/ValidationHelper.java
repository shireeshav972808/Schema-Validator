import FileUtil.ReadCSVFile;

import java.io.IOException;
import java.util.Map;

public class ValidationHelper {
    private ReadCSVFile readCSVFile = new ReadCSVFile();
    private Map<Integer,String> columnData;
    private ValidationWrapper validationWrapper = new ValidationWrapper();
    public void validate(String jsonContentPath,String inputFilePath) throws IOException {
        String[] fileHeaders = ReadCSVFile.getHeaders(inputFilePath);
        for (String columnName: fileHeaders
             ) {
                columnData = readCSVFile.readRowsOfColumn(inputFilePath,columnName);
                validationWrapper.validateCSVData(columnData,columnName,jsonContentPath);
        }
    }
}
