package StepDefinition.LoginStep;

import PageObject.LoginPage.LoginPage;
import StepDefinition.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;

public class Login {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);
    public Properties props = Hooks.props;

   // @Given("^The user navigates to login page$")
    //public void userNavigateToLoginPage(){
     //   loginPage.clickLoginLInk();
    //}
    @Given("^The user is login into the system$")
    public void userIslogin() throws Exception {
        loginPage.setLogintxt(props.getProperty("username"));
        loginPage.setPassWordTxt(props.getProperty("password"));
        loginPage.clickSignIn();
    }
    @Then("^The user succesfully logged in$")
    public void loggedInSuccessfully(){

        Assert.assertTrue(loginPage.loggedSuccessfully());
    }
}
