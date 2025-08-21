package Fuctionality.PageObject.Homepage;

import StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends Hooks {

    @FindBy(xpath = "//*[contains(text(), 'Dashboard')]")
    public WebElement homePageText;

    public Home (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String getHomeText(){
        return homePageText.getText();
    }


}
