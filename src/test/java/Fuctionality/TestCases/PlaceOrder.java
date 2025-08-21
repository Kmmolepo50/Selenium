package Fuctionality.TestCases;

import StepDefinition.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class PlaceOrder extends Hooks {
    WebDriver driver;
    public Properties props;

    @FindBy(xpath="//a[@class='list-group-item']")
    public List<WebElement> categories;

    @FindBy(xpath="//h4[@class ='card-title']")
    public List<WebElement> productSelection;


    public PlaceOrder (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setCategories(String category){
        try {
            for(WebElement cat: categories){
                boolean checkCat=false;
                if(cat.getText().equalsIgnoreCase(category)){
                    checkCat=true;
                    cat.click();
                    break;
                }

                Assert.assertFalse(false);
            }
        }catch (Exception e){
            System.out.println("Categories does not exist");
        }

    }

      public void selectProduct()throws Exception{

        try{
            for(WebElement ment: productSelection){

                boolean isproductFound=false;
                if(ment.getText().equalsIgnoreCase("Apple monitor 24")){
                    System.out.println(ment.getSize());

                    System.out.println(ment.getText());
                    ment.click();
                    isproductFound= true;
                    break;
                }
            }
               }catch (Exception e){
            e.getMessage();
        }

      }


}
