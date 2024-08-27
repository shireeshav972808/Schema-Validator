package FileUtil;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSVFile {
    public static String[] getHeaders(String filePath) throws IOException {

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] allRows = reader.peek();
            return allRows;
        }
    }

    public Map<Integer,String> readRowsOfColumn(String inputFilePath,String columnName) {
        String filePath = inputFilePath;
        String targetColumn = columnName;

        Map<Integer, String> columnData = null;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> allRows = reader.readAll();
            columnData = new HashMap<>();

            if (allRows.isEmpty()) {
                System.out.println("The file is empty.");
            }

            String[] header = allRows.get(0);
            int targetColumnIndex = -1;
            for (int i = 0; i < header.length; i++) {
                if (header[i].equalsIgnoreCase(targetColumn)) {
                    targetColumnIndex = i;
                    break;
                }
            }

            if (targetColumnIndex == -1) {
                System.out.println("Column '" + targetColumn + "' not found.");
            }


            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                columnData.put(i, row[targetColumnIndex]);
            }

            System.out.println("Data in column '" + targetColumn + "': " + columnData);

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return columnData;
    }
}
