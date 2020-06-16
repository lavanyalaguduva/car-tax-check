package utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class GetFilePath {
    public static String get(String filePathProperty) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String filePath = EnvironmentSpecificConfiguration.from(variables).getProperty(filePathProperty);
        return filePath;
    }
}
