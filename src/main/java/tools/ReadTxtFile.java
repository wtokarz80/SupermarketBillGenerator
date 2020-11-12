package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTxtFile {

    private final String filePathTxt;

    public ReadTxtFile(String filePathTxt) {
        this.filePathTxt = filePathTxt;
    }

    public List<String> readTxtFile() {
        List<String> records = new ArrayList<>();

        try (
                var fileReader = new FileReader(filePathTxt);
                var reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
                records.add(nextLine);
                lines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}
