package actions;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadInputFile{
    private static String inputFilePath;
    private static Pattern regNumberPattern =
            Pattern.compile("[A-Z]{2}[0-9]{2}[\\s]?[A-Z]{3}");
    private static ArrayList<String> regNumberList = new ArrayList();

    static String getInputFilePath(String filePath) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        inputFilePath = EnvironmentSpecificConfiguration.from(variables)
                .getProperty(filePath);
        System.out.println("inputFilePath " + inputFilePath);
        return inputFilePath;
    }

    public static ArrayList read(String inputFilePathProperty) {
        File file = new File(getInputFilePath(inputFilePathProperty));

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()) {
                String wholeLine = sc.nextLine();
                Matcher matcher = regNumberPattern.matcher(wholeLine);
                System.out.println("Whole line " + wholeLine);
                System.out.println("matcher " + matcher);
                while (matcher.find()) {
                    int start = matcher.start();
                    String regNumber = matcher.group();
                    int stop = matcher.end();
                    System.out.println(regNumber.replaceAll("\\s",""));
                    regNumberList.add(regNumber.replaceAll("\\s",""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regNumberList;
    }
}
