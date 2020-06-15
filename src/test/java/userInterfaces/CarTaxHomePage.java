package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CarTaxHomePage extends PageObject {

    private static final Target REGISTRATION_NUMBER_FIELD_ENTRY = Target.the("registration number field")
            .locatedBy("#vrm-input");
    private static final Target FREE_CHECK_BUTTON = Target.the("free check")
            .locatedBy("#vehicle-search > button");

    public static Performable enterRegistrationNumber(String regNumber) {
        return Task.where("{0} enters the registartion number "+regNumber,
                WaitUntil.the(REGISTRATION_NUMBER_FIELD_ENTRY, isVisible()),
                Enter.theValue(regNumber).into(REGISTRATION_NUMBER_FIELD_ENTRY),
                Click.on(FREE_CHECK_BUTTON));
    }


}
