package org.openmrs.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openmrs.Steps;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.lift.Finders.*;
import static org.openqa.selenium.lift.Matchers.text;
import static org.openqa.selenium.lift.match.AttributeMatcher.attribute;

public class CreateObservationSteps extends Steps {
    public CreateObservationSteps(WebDriver driver) {
        super(driver);
    }

    @Given("I am on Admin page")
    public void iAmOnAdminPage() {
        assertPresenceOf(title().with(text(equalTo("OpenMRS - " + "Administration"))));
    }

    @When("I click on the Manage Observations link")
    public void clickManageObsLink() {
        clickOn(link().with(text(equalTo("Manage Observation"))));
    }
    @Then("take me to Observation Management Page with Observation Management as heading")
    public void verifyManagementPage(){
        assertPresenceOf(finderByXpath("/html/body/div[@id=\'pageBody\']/div[@id=\'content\']/h2").with(text(equalTo("Observation Management"))));
    }


    @Given("I am on the Observation Management Page")
    public void onFindObservationManagementPage() {
        assertPresenceOf(finderByXpath("/html/body/div[@id=\'pageBody\']/div[@id=\'content\']/h2").with(text(equalTo("Observation Management"))));
    }

    @When("I click on $addObsLink  link")
    public void clickOnAddObservation(String addObsLink) {
        clickOn(link().with(text(equalTo("Add Observation"))));
    }

    @Then("take me to Add Observation page with $heading as heading and has a button with label $buttonText")
    public void verifyAddObservationPage(String heading, String buttonText) {
        assertPresenceOf(finderByXpath("/html/body/div[@id=\'pageBody\']/div[@id=\'content\']/h2").with(text(equalTo(heading))));
        assertPresenceOf(button("Save Observation"));

    }

    @Given("I am on the Add Observation page")
    public void givenIamOnAddObservationPage() {
        System.out.println("hi there");
        assertPresenceOf(finderByXpath("/html/body/div[@id=\'pageBody\']/div[@id=\'content\']/h2").with(text(equalTo("Observation"))));
        //  assertPresenceOf(button("Save Observation"));

    }


    @When("I type $name as person")
    public void enterPersonName(String name) {
        type(name, into(textbox().with(attribute("id", equalTo("person_id_selection")))));
        waitFor(finderByXpath("/html/body/ul[1]/li[2]/a/span/span[2]"));
        clickOn(finderByXpath("/html/body/ul[1]/li[2]/a/span/span[2]"));

    }

    @When("I select Unknown Location as Location with index $index")
    public void selectLocation(int index) {
        selectAValueInDropDownByXpath("/html/body/div[@id=\'pageBody\']/div[@id=\'content\']/form/fieldset/table[@id=\'obsTable\']/tbody/tr[4]/td/select[@id=\'location\']").selectByIndex(index);
    }

    @When("I type $date as Observation Date")
    public void enterObservationDate(String date) {
        type(date, into(textbox().with(attribute("id", equalTo("obsDatetime")))));
    }

    @When("I type $conceptQuestion as Concept Question")
    public void enterConceptQuestion(String conceptQuestion) {
        type(conceptQuestion, into(textbox().with(attribute("id", equalTo("conceptId_selection")))));
        waitFor(finderByXpath("/html/body/ul[3]/li/a"));
        clickOn(finderByXpath("/html/body/ul[3]/li/a"));
    }

    @When("I type $conceptAnswer as Concept Answer")
    public void enterConceptAnswer(String conceptAnswer) {
        type(conceptAnswer, into(textbox().with(attribute("name", equalTo("valueNumeric")))));
    }

    @When("I click the Save Observation button")
    public void clickSaveObservationButton() {
        clickOn(button("Save Observation"));
    }

    @Then("display message Observation saved")
    public void verifySuccessMessage() {
        assertPresenceOf(finderByXpath("/html/body/div[@id=\'pageBody\']/div[@id=\'content\']/div[@id=\'openmrs_msg\']").with(text(equalTo("Observation saved"))));
    }

}
