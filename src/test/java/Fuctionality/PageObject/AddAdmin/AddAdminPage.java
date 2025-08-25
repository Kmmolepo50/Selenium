package Fuctionality.PageObject.AddAdmin;

import Fuctionality.PageObject.BasePage.BasePage;
import StepDefinition.Hooks;
import Utilities.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static StepDefinition.Hooks.click;
import static StepDefinition.Hooks.isElementDisplayed;

public class AddAdminPage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement clickAdminMenu;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement AdminAddButton;

    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    public WebElement validateAddUserScreen;


    public AddAdminPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger logger = LoggerUtils.getLogger(AddAdminPage.class);
    public void setClickAdminMenu(){

        click(clickAdminMenu);
    }

    public void addAminUser(){
        try {
            click(AdminAddButton);
            Assert.assertTrue(isElementDisplayed(validateAddUserScreen));
            logger.info("user screen is displayed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    public void captureUserDetails(String username){
    }

    public boolean addUserScreenDisplayed(){
        return validateAddUserScreen.isDisplayed();
    }

}
