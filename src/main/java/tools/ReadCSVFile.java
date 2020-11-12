package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ReadCSVFile {

    private static final String COMMA_DELIMITER = ",";
    private final String filePathCSV;

    public ReadCSVFile(String filePathCVS) {
        this.filePathCSV = filePathCVS;
    }


    public List<List<String>> readCSVFile() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePathCSV))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        records.remove(0);
        return records;
    }

}
