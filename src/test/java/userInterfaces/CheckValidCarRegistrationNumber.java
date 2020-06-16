package userInterfaces;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.CarDetails;
import questions.CarDetailsCheckList;

import static net.serenitybdd.screenplay.GivenWhenThen.seeIf;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.hasToString;

public class CheckValidCarRegistrationNumber {
    public static final Target INVALID_REG_NUMBER_MODAL = Target.the("invalid registration number")
            .locatedBy("//*[@id=\"m\"]/div/div[1]/div/div/dl");

    public static Question invalidRegistrationNumberDialog() {
        return actor -> INVALID_REG_NUMBER_MODAL.resolveFor(actor).isVisible();
    }

    public static Performable isRegistrationNumberInvalid(String regNumber) {
        try {
            return Task.where("{0} checks whether the entered registration number is valid or output is missing",
                    Check.whether(invalidRegistrationNumberDialog(), isVisible()));
        } catch (Exception e1) {
            try {
                return Task.where("{0} sees that expected output is missing, hence continues",
                        WaitUntil.the(CarDetailsCheckList.CAR_REGISTRATION_NUMBER, hasToString(regNumber)));
            }catch(Exception e2){
                System.out.println("check for other errors");
                return null;
            }
        }
    }

    public static Performable isTheExpectedOutputMissing(String regNumber) {
        return Task.where("{0} sees that expected output is missing, hence continues",
                seeIf(CarDetails.carRegistrationNumber(), hasToString(regNumber)));
    }
}
