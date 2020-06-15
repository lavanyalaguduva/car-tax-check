package questions;

import net.serenitybdd.screenplay.Question;

public class CarDetails {
    public static Question<String> carRegNumber() {
        return actor -> ConfirmationList.CAR_REGISTRATION_NUMBER.resolveFor(actor).getText();
    }

    public static Question<String> carColour() {
        return actor -> ConfirmationList.CAR_COLOUR.resolveFor(actor).getText();
    }

    public static Question<String> carModel() {
        return actor -> ConfirmationList.CAR_MODEL.resolveFor(actor).getText();
    }

    public static Question<String> carMake() {
        return actor -> ConfirmationList.CAR_MAKE.resolveFor(actor).getText();
    }

    public static Question<String> carYear() {
        return actor -> ConfirmationList.CAR_YEAR.resolveFor(actor).getText();
    }

}
