package Fuctionality.PageObject.OrderPage;

import StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProcessOrderPage extends Hooks {
    WebDriver driver;

    //ul[@data-ref ='department-categories']/li
    @FindBy(xpath = "//*[@data-ref ='department-categories']/li/a/span")
    public List<WebElement> shopDepartment;


    public ProcessOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectDepartment() throws Exception {
        try {
            for (WebElement dep : shopDepartment) {

                if (dep.getText().equalsIgnoreCase("Appliances")) {
                    dep.click();

                }


            }

        } catch (Exception e) {
            System.out.println("Categories does not exist");


        }

    }
}