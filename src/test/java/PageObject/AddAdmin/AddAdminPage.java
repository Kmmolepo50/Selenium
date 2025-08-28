package PageObject.AddAdmin;

import PageObject.BasePage.BasePage;
import Utilities.LoggerUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static StepDefinition.Hooks.*;

public class AddAdminPage extends BasePage {
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement clickAdminMenu;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement AdminAddButton;

    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    public WebElement validateAddUserScreen;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    public WebElement adminUserName;


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
    public void captureUserDetails(String username,String password){
        sendKeys(adminUserName,username);
        sendKeys(adminUserName,username);
    }

    public boolean addUserScreenDisplayed(){

        return validateAddUserScreen.isDisplayed();
    }

}
