package StepDefinition.AdminStep;

import PageObject.AddAdmin.AddAdminPage;
import StepDefinition.Hooks;
import Utilities.LoggerUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AdminStep {
    WebDriver driver = Hooks.driver;
    private static final Logger logger = LoggerUtils.getLogger(AddAdminPage.class);



    @Given("^The user add new admin$")
    public void addNewAdmin(DataTable dataTable){
        AddAdminPage addAdminPage=new AddAdminPage(driver);

       Map<String, String> adminDetails = dataTable.asMap();
        addAdminPage.setClickAdminMenu();
       // addAdminPage.addAminUser();
        logger.info("admin screen");
        addAdminPage.captureUserDetails(adminDetails.get("Username"));
        addAdminPage.captureUserDetails(adminDetails.get("Password"));
        logger.info("admin iput");
        System.out.println(adminDetails.get("Username"));


    }

}
