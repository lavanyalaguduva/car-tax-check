package questions;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationList {
    public static Target CAR_REGISTRATION_NUMBER = Target.the("car registration number")
            .locatedBy("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[1]/dd");
    public static Target CAR_MAKE = Target.the("car make")
            .locatedBy("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[2]/dd");
    public static Target CAR_MODEL = Target.the("car model")
            .locatedBy("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[3]/dd");
    public static Target CAR_COLOUR = Target.the("car colour")
            .locatedBy("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[4]/dd");
    public static Target CAR_YEAR = Target.the("car year")
            .locatedBy("//*[@id=\"m\"]/div/div[3]/div[1]/div/span/div[2]/dl[5]/dd");
}
