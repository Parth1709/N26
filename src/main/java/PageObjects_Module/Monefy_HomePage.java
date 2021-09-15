package PageObjects_Module;

import Utility_Module.BaseActions;
import Utility_Module.PageObjects_ActionHelper;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Monefy_HomePage extends PageObjects_ActionHelper {

    public Monefy_HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyMonefyLogo(){
        Assert.assertTrue(getElement("text_monefyLogo").isDisplayed(),"monefyLogo not verified");
        Reporter.log("MonefyLogo verified",true);
    }

    public void verifyhamburgerIcon(){
        Assert.assertTrue(getElement("icon_hamburger").isDisplayed(),"hamburger icon not verified");
        Reporter.log("hamburger icon verified",true);
    }

    public void verifyOptionIcon(){
        Assert.assertTrue(getElement("icon_settings").isDisplayed(),"settings option not verified");
        Reporter.log("settings option verified",true);
    }

    public void verifySearchIcon(){
        Assert.assertTrue(getElement("icon_Search").isDisplayed(),"search icon not verified");
        Reporter.log("search icon verified",true);
    }

    public void verifyButtonExpenseAndIncom(){
        Assert.assertTrue(getElement("button_expense").isDisplayed(),"expense button not verified");
        Reporter.log("expense button verified",true);
        Assert.assertTrue(getElement("button_income").isDisplayed(),"income button not verified");
        Reporter.log("income button  verified",true);
    }

    public void verifyTodaysbalanceIcon(){
        Assert.assertTrue(getElement("icon_balanceOverview").isDisplayed(),"todays balance icon not verified");
        Reporter.log("todays balance icon verified",true);
    }

    public void verifyTransferIcon(){
        Assert.assertTrue(getElement("icon_transfer").isDisplayed(),"transfer icon not verified");
        Reporter.log("transfer icon verified",true);

    }
}
