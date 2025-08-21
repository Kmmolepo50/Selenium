package StepDefinition.ProcessOrderStep;

import Fuctionality.PageObject.OrderPage.ProcessOrderPage;
import StepDefinition.Hooks;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class ProcessOrder {
    WebDriver driver = Hooks.driver;
    ProcessOrderPage processOrderPage = new ProcessOrderPage(driver);

    @Given("^User Navigate to departments$")
    public void navigateToDepartment()throws Exception {

        processOrderPage.selectDepartment();
    }
}
