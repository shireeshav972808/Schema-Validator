import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidationsDataProvider {
    @DataProvider
    public Object[][] filePaths() throws IOException {
        return new Object[][]{{"C:\\Users\\ShireeshaV\\automation\\SchemaValidator\\src\\test\\resources\\input.json","C:\\Users\\ShireeshaV\\automation\\SchemaValidator\\src\\test\\resources\\Transaction_File.csv"}};
    }
}
