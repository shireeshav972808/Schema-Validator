package Validator;

import org.testng.annotations.DataProvider;

import java.io.IOException;


public class ValidationsDataProvider {
    @DataProvider
    public Object[][] filePaths() throws IOException {
        return new Object[][]{{"src/test/resources/testData/input.json","src/test/resources/testData/Transaction_File.csv"}};
    }
}
