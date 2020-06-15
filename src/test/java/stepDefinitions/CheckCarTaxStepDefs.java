package stepDefinitions;

import actions.ReadInputFile;
import actions.ReadOutputFile;
import com.google.common.collect.Multimap;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import questions.CarDetails;
import questions.ConfirmationList;
import userInterfaces.CarTaxHomePage;
import userInterfaces.CheckValidCarRegistrationNumber;
import userInterfaces.NavigateTo;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class CheckCarTaxStepDefs {
    ArrayList<String> inputRegNumbers;
    Multimap outputCarDetails;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) decides to check the tax details of the cars with registration numbers present in a file under the path (.*)")
    public void euanDecidesToCheckTheCarTaxDetailsOfRegistrationNumbersPresentInAFile(String actor, String inputFilePath) {
        inputRegNumbers = new ArrayList(ReadInputFile.read(inputFilePath));
        theActorCalled(actor).attemptsTo(NavigateTo.theCarTaxCheckPage());
    }

    @Then("^s?he should see the car tax details matches the expected details from the output file under the path (.*)")
    public void heShouldSeeTheCarTaxDetailsMatchesTheExpectedDetailsFromTheOutputFile(String outputFilePath) {
        readOutputFile(outputFilePath);
        for (String regNumber : inputRegNumbers) {
            theActorInTheSpotlight().attemptsTo(CarTaxHomePage.enterRegistrationNumber(regNumber));
            Object[] carDetails = outputCarDetails.get(regNumber).toArray();
            if (carDetails.length == 0) {
                highLightIfRegNumberIsInvalid();
                continue;
            }

            String make = carDetails[0].toString();
            String model = carDetails[1].toString();
            String colour = carDetails[2].toString();
            String year = carDetails[3].toString();
            theActorInTheSpotlight().should(
                    seeThat("car registration number", CarDetails.carRegNumber(),
                            equalToIgnoringCase(regNumber)),
                    seeThat("car make", CarDetails.carMake(),
                            equalToIgnoringCase(make)),
                    seeThat("car model", CarDetails.carModel(),
                            equalToIgnoringCase(model)),
                    seeThat("car colour", CarDetails.carColour(),
                            equalToIgnoringCase(colour)),
                    seeThat("car made year", CarDetails.carYear(),
                            equalToIgnoringCase(year))
            );
            theActorInTheSpotlight().attemptsTo(NavigateTo.theCarTaxCheckPage());
        }
    }

    private void readOutputFile(String outputFilePath) {
        outputCarDetails = ReadOutputFile.read(outputFilePath);
    }

    private void highLightIfRegNumberIsInvalid() {
        theActorInTheSpotlight().should(
                seeThat("the invalid registration number dialog is displayed",
                        CheckValidCarRegistrationNumber.invalidRegistrationNumber()));
        theActorInTheSpotlight().attemptsTo(NavigateTo.theCarTaxCheckPage());
    }
}
