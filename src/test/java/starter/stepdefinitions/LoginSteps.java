package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.page.HomePage;
import starter.page.LoginPage;

public class LoginSteps {
    @Steps
    LoginPage loginpage;

    @Steps
    HomePage homePage;

    @Given("I am on the login page")
    public void onTheLoginPage(){
        loginpage.openPage();
        loginpage.validateOnLoginPage();
    }
    @When("I input valid username")
    public void inputValidUsername(){
        loginpage.inputUsername("standard_user");
    }
    @And("I input valid password")
    public void inputValidPassword(){
        loginpage.inputPassword("secret_sauce");
    }
    @And("I click login button")
    public void clickLoginButton(){
        loginpage.clickLoginButton();
    }
    @Then("I am on the home page")
    public void onTheHomePage(){
        homePage.validateOnHomePage();
    }

    @When("I input locked username")
    public void inputLockedUsername(){
        loginpage.inputUsername("locked_out_user");
    }

    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String message) {
        loginpage.validateErrorMessageDisplayed();
        loginpage.validateEqualErrorMessage(message);
    }
}
