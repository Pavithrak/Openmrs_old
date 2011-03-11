package org.openmrs.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openmrs.Steps;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.openqa.selenium.lift.Finders.button;
import static org.openqa.selenium.lift.Finders.div;
import static org.openqa.selenium.lift.Matchers.attribute;
import static org.openqa.selenium.lift.Matchers.text;

public class InstallationWizardSteps extends Steps {
    public InstallationWizardSteps(WebDriver driver) {
        super(driver);
    }

    @Given("I am on the installation page of OpenMRS with url $url")
    public void beginInstallation(String url) {
        goTo(url);
        assertPresenceOf(finderByXpath("/html/body/form/div/table/tbody/tr[2]/td[1]/input"));
        assertPresenceOf(finderByXpath("/html/body/form/div/table/tbody/tr[3]/td[1]/input"));
    }

    @When("I select the Advanced option")
    public void selectAdvancedOption() {

        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[3]/td[1]/input"));

    }

    @When("I click on Continue button")
    public void clickOnContinueButton() {

        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[4]/td/input"));
    }

    @Then("take me to installation step 1 with heading Step $current of $total  and Database Connection element with name $name")
    public void verifyPage1(int current, int total, String name) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
        assertPresenceOf(finderByXpath("/html/body/form/div/table/tbody/tr[3]/td/input"));
    }


    @Given("I am on installation step 1 with heading Step $current of $total and Database Connection element with name database_connection")
    public void onInstallationStep1(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
        assertPresenceOf(finderByXpath("/html/body/form/div/table/tbody/tr[3]/td/input"));
    }

    @When("I type $url as Database connection url")
    public void enterConnectionUrl(String url) {

        type(url, finderByXpath("/html/body/form/div/table/tbody/tr[3]/td/input"));

    }

    @When("I type $dbName as new database name")
    public void enterDbName(String dbName) {
        String xpath = "/html/body/form/div/table/tbody/tr[9]/td/input";
        clear(xpath);
        type(dbName, finderByXpath(xpath));

    }

    @When("I type $userName as database username")
    public void enterDatabaseUserName(String userName) {
        String xpath = "/html/body/form/div/table/tbody/tr[11]/td/input";
        clear(xpath);
        type(userName, finderByXpath(xpath));

    }

    @When("I type $password as database password")
    public void enterDatabasePassword(String password) {
        type(password, finderByXpath("/html/body/form/div/table/tbody/tr[12]/td/input"));

    }

    @When("I click on Continue button on step 1")
    public void clickOnStep1ContinueButton() {

        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[13]/td/input[3]"));

    }

    @Then("take me to installation step 2 with heading Step $current of $total")
    public void verifyPage2(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }


    @Given("I am on installation step 2 with heading Step $current of $total")
    public void onInstallationStep2(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }

    @When("I select yes to add demo data")
    public void selectDemoData() {
        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[5]/td[1]/input"));

    }

    @When("I type $userName as database username in step 2")
    public void enterUserName(String userName) {
        type(userName, finderByXpath("/html/body/form/div/table/tbody/tr[8]/td/input"));

    }

    @When("I type $password as database password in step 2")
    public void enterPassword(String password) {
        type(password, finderByXpath("/html/body/form/div/table/tbody/tr[9]/td/input"));

    }

    @When("I click on Continue button on step 2")
    public void clickOnStep2ContinueButton() {

        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[13]/td/input[3]"));

    }

    @Then("take me to installation step 3 with heading Step $current of $total")
    public void verifyPage3(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }

    @Given("I am on installation step 3 with heading Step $current of $total")
    public void onInstallationStep3(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }

    @When("I click on Continue button on step 3")
    public void clickOnStep3ContinueButton() {

        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[6]/td/input[3]"));

    }

    @Then("take me to installation step 4 with heading Step $current of $total")
    public void verifyPage4(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }

    @Given("I am on installation step 4 with heading Step $current of $total")
    public void onInstallationStep4(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }

    @When("I type $password as openmrs password in step 4")
    public void enterOpenmrsPassword(String password) {

        type(password, finderByXpath("/html/body/form/div/table/tbody/tr[4]/td[2]/input"));
    }

    @When("I type $password as confirm openmrs password in step 4")
    public void confirmOpenmrsPassword(String password) {

        type(password, finderByXpath("/html/body/form/div/table/tbody/tr[5]/td[2]/input"));
    }

    @When("I click on Continue button on step 4")
    public void clickOnStep4ContinueButton() {

        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[6]/td/input[3]"));

    }

    @Then("take me to installation step 5 with heading Step $current of $total")
    public void verifyPage5(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }

    @Given("I am on installation step 5 with heading Step $current of $total")
    public void onInstallationStep5(int current, int total) {
        assertPresenceOf(div().with(
                text(containsString("Step " + current + " of " + total))));
    }

    @When("I click on Continue button on step 5")
    public void clickOnStep5ContinueButton() {

        clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[7]/td/input[3]"));

    }

    @Then("take me to $title Page")
    public void verifyReviewPage(String title) {
        assertPresenceOf(div().with(
                text(containsString(title))));
    }


    @Given("I am on $title page")
    public void onReviewPage(String title) {
        assertPresenceOf(div().with(
                text(containsString(title))));
    }

    @When("I click on Finish button on review page")
    public void clickOnFinishButton() {

       clickOn(finderByXpath("/html/body/form/div/table/tbody/tr[19]/td/input[@id=\'start\']"));
       waitFor(button().with(attribute("value", equalTo("Log In"))));
    }

    @Then("take me to login Page")
    public void verifyLoginPage(String title) {

        assertPresenceOf(button().with(attribute("value", equalTo("Log In"))));
    }
}
