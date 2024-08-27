import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidateInputTest {
    @Test(dataProvider = "filePaths",dataProviderClass = ValidationsDataProvider.class)
    public void validateInputFile(String jsonSchemaFilePath,String csvFilePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(jsonSchemaFilePath)));
        String filePath = csvFilePath;
        ValidationHelper validateHelper = new ValidationHelper();
        validateHelper.validate(content,filePath);

    }
}
