package actions;

import utils.GetFilePath;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadInputFile {
    private static Pattern regNumberPattern = Pattern.compile("[A-Z]{2}[0-9]{2}[\\s]?[A-Z]{3}");

    public static ArrayList read(String inputFilePathProperty) {
        ArrayList<String> regNumberList = new ArrayList();
        File file = new File(GetFilePath.get(inputFilePathProperty));

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()) {
                String wholeLine = sc.nextLine();
                Matcher matcher = regNumberPattern.matcher(wholeLine);
                while (matcher.find()) {
                    String regNumber = matcher.group();
                    regNumberList.add(regNumber.replaceAll("\\s", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regNumberList;
    }
}
