import ObjectInitiator_Module.ConfigObject_Initiator;
import ObjectInitiator_Module.PageObjectSession_Initiator;
import ObjectInitiator_Module.WebDriverSession_Initiator;
import org.testng.annotations.*;

public class BaseTest {

    PageObjectSession_Initiator pageObjects ;

    @BeforeSuite
    public void beforeSuite(){

    }

    @BeforeTest
    public void beforeTest(){
        pageObjects = new PageObjectSession_Initiator();
        PageObjectSession_Initiator.thread_driver.set(WebDriverSession_Initiator.getDriver(ConfigObject_Initiator.config));
        pageObjects.init_pageObjects();
    }

    @BeforeClass
    public void beforeClass(){

    }

    @BeforeMethod
    public void beforeMethod(){

    }

    @AfterMethod
    public void AfterMethod(){

    }

    @AfterClass
    public void AfterClass(){

    }

    @AfterTest
    public void AfterTest(){
        PageObjectSession_Initiator.thread_driver.get().quit();
    }

    @AfterSuite
    public void AfterSuite(){

    }

}
