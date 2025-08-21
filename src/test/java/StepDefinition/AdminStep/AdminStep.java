package StepDefinition.AdminStep;

import Fuctionality.PageObject.AddAdmin.AddAdminPage;
import StepDefinition.Hooks;
import Utilities.DataTableUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AdminStep {
    WebDriver driver = Hooks.driver;
    AddAdminPage addAdminPage=new AddAdminPage(driver);

    @Given("^The user add new admin$")
    public void addNewAdmin(DataTable dataTable){
        Map<String, String> adminDetails = DataTableUtils.toSingleRowMap(dataTable);
        addAdminPage.setClickAdminMenu();
        addAdminPage.addAminUser();

    }

}
