package userInterfaces;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.ConfirmationList;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CheckValidCarRegistrationNumber {
    public static final Target INVALID_REG_NUMBER_MODAL = Target.the("invalid registration number")
            .locatedBy("//*[@id=\"m\"]/div/div[1]/div/div/dl");

    public static Question<Boolean> invalidRegistrationNumber() {
        return actor -> INVALID_REG_NUMBER_MODAL.resolveFor(actor).isVisible();
    }

    public static Performable checkRegNumber() {
        try {
            return Task.where("{0} checks whether the entered registration number is valid",
                    WaitUntil.the(INVALID_REG_NUMBER_MODAL, isVisible()));
        } catch (Exception e) {
            return null;
        }
    }
}
