package questions;

import net.serenitybdd.screenplay.Question;

public class CarDetails {
    public static Question<String> carColour() {
        return actor -> CarDetailsCheckList.CAR_COLOUR.resolveFor(actor).getText();
    }

    public static Question<String> carModel() {
        return actor -> CarDetailsCheckList.CAR_MODEL.resolveFor(actor).getText();
    }

    public static Question<String> carMake() {
        return actor -> CarDetailsCheckList.CAR_MAKE.resolveFor(actor).getText();
    }

    public static Question<String> carYear() {
        return actor -> CarDetailsCheckList.CAR_YEAR.resolveFor(actor).getText();
    }

    public static Question<String> carRegistrationNumber() {
        return actor -> CarDetailsCheckList.CAR_REGISTRATION_NUMBER.resolveFor(actor).getText();
    }
}
