
import org.testng.annotations.Test;

public class SampleTest extends BaseTest{

    @Test
    public void Test01_UserVerifyMonefyLogo(){
       pageObjects.monefy_homePage.verifyMonefyLogo();
    }
    @Test
    public void Test01_UserVerifyHamburgerIcon(){
        pageObjects.monefy_homePage.verifyhamburgerIcon();
    }
    @Test
    public void Test01_UserVerifySettingsOption(){
        pageObjects.monefy_homePage.verifyOptionIcon();
    }
    @Test
    public void Test01_UserVerifySearchIcon(){
        pageObjects.monefy_homePage.verifySearchIcon();
    }
    @Test
    public void Test01_UserVerifyTranserIcon(){
        pageObjects.monefy_homePage.verifyTransferIcon();

    }
    @Test
    public void Test01_UserVerifyTodaysBalanceOpton(){
        pageObjects.monefy_homePage.verifyTodaysbalanceIcon();

    }
    @Test
    public void Test01_UserVerifyExpenseIncomeButton(){
        pageObjects.monefy_homePage.verifyButtonExpenseAndIncom();

    }
}
