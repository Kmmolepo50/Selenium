package Fuctionality.PageObject.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text ()='Login']")
    public WebElement loginLink;

    @FindBy(xpath = "//button[text ()='NOT NOW']")
    public WebElement DontMissOutLink;
    //button[text ()='NOT NOW']

    //take alot
    //@FindBy(xpath = "//input[@name='email']")
    //public WebElement userNameTxt;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userNameTxt;

    //take alot
    //@FindBy(xpath = "//input[@name='password']")
    //public WebElement passWordTxt;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passWordTxt;

   // takealot
    //@FindBy(xpath = "//button[contains(text(),'Login')]")
    //public WebElement loginButton;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    public WebElement loginVerification;

    @FindBy(xpath = "//a[@id='login2']")
    public WebElement clickLogin;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(clickLogin));

        clickLogin.click();
        DontMissOutLink.click();
    }

    public void setLogintxt(String username){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(userNameTxt));
        userNameTxt.clear();
        userNameTxt.sendKeys(username);
    }
public void clickLoginLInk(){
    loginLink.click();
    }
    public void setPassWordTxt(String password){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(passWordTxt));
        passWordTxt.clear();
        passWordTxt.sendKeys(password);
    }

    public void clickSignIn(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public boolean loggedSuccessfully(){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(loginVerification))
                .isDisplayed();
    }
}
