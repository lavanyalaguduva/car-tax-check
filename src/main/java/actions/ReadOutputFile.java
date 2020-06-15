package actions;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadOutputFile {
    private static String outputFilePath;
    private static Multimap<String, String> outputMap = ArrayListMultimap.create();

    public static Multimap  read(String outputFilePath) {
        File file = new File(getOutputFilePath(outputFilePath));
        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()) {
                String[] lineList = sc.nextLine().split(",");
                String key = lineList[0];
                for (int i = 1; i < lineList.length; i++) {
                    outputMap.put(key, lineList[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       return outputMap;
    }

    static String getOutputFilePath(String outputFilePath) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        outputFilePath = EnvironmentSpecificConfiguration.from(variables)
                .getProperty(outputFilePath);
        System.out.println("outputFilePath " + outputFilePath);
        return outputFilePath;
    }
}
