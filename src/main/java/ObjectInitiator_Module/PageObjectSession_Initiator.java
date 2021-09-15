package ObjectInitiator_Module;

import PageObjects_Module.Monefy_HomePage;
import Utility_Module.PropertyFileReader;
import org.openqa.selenium.WebDriver;

public class PageObjectSession_Initiator {

    public ConfigObject_Initiator configObject;
    public PropertyFileReader propertyFileReader;

    public static ThreadLocal<WebDriver> thread_driver = new ThreadLocal<WebDriver>();

    public Monefy_HomePage monefy_homePage;

    public PageObjectSession_Initiator(){
        init();
    }

    public void init(){
        propertyFileReader = new PropertyFileReader();
        ConfigObject_Initiator.config=propertyFileReader.getValuesFromPropertyFile();

        configObject = new ConfigObject_Initiator();
        configObject.updateConfigMap();
    }

    public void init_pageObjects(){
        monefy_homePage = new Monefy_HomePage(thread_driver.get());
    }

    public void launchUrl(String url){
        thread_driver.get().get(url);
    }

}
