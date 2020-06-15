package userInterfaces;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theCarTaxCheckPage() {
        return Task.where("{0} opens the home page",
                Open.browserOn().the(CarTaxHomePage.class));
    }
}
