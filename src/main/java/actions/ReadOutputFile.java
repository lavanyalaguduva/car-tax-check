package actions;

import utils.GetFilePath;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadOutputFile {

    private static Map<String, HashMap<String, String>> outputMap = new HashMap<String, HashMap<String, String>>();

    public static Map<String, HashMap<String, String>> read(String outputFilePath) {
        File file = new File(GetFilePath.get(outputFilePath));
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            String[] headers = new String[10];
            if (sc.hasNextLine()) {
                headers = sc.nextLine().split(",");
            }
            while (sc.hasNextLine()) {
                String[] values = sc.nextLine().split(",");
                String key = values[0];
                HashMap<String, String> innerMap = new HashMap<String, String>();
                for (int i = 1; i < values.length; i++) {
                    innerMap.put(headers[i].toLowerCase(), values[i]);
                }
                outputMap.put(key, innerMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputMap;

    }

}
