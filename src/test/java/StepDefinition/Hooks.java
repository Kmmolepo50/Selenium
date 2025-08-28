package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;


public class Hooks {

    public static WebDriver driver;
    public static Properties props;


  @Before(order = 1)
  public void initiateBrowser() throws IOException, InterruptedException {


      try {
          props = new Properties();

          FileReader ip = new FileReader(".\\src\\main\\resources\\Config.properties");
          props.load(ip);

          System.out.println(ip);

      } catch (IOException e){
          e.printStackTrace();
      }
      String browserName =props.getProperty("browser");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("disable-blink-features=AutomationControlled");
      switch (browserName) {

          case "Chrome" -> driver = new ChromeDriver(options);
          case "FireFox", "IE" -> driver = new FirefoxDriver();

      }

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get(props.getProperty("url2"));
      driver.manage().window().maximize();

  }


//Wait Method
public static WebElement waitForVisibility(WebDriver driver, By locator) {
    return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));

}

//Click Method
    public static void click(WebElement element) {
        element.click();
    }

    // Display Method
    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
    // SendKeys Method
    public static void sendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Unable to send keys to element: " + e.getMessage());
        }
    }

//@After
//public void terminate(){
//driver.close();
//System.out.println("Closed");
 //}

}
