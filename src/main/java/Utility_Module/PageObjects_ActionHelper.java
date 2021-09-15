package Utility_Module;

import ObjectInitiator_Module.ConfigObject_Initiator;
import ObjectInitiator_Module.LocatorObject_Initiator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjects_ActionHelper {

    WebDriver driver;
    public LocatorObject_Initiator locatorObject;
    protected ApplicationWaits waits;
    String device = "";
    String browser = "";
    String appPackage = null;

   public PageObjects_ActionHelper(WebDriver driver){
        this.driver = driver;
        init();
        waits = new ApplicationWaits(driver, 30);
        locatorObject = new LocatorObject_Initiator();

    }

    public void init(){
        this.device= ConfigObject_Initiator.config.get("device");
        this.browser=ConfigObject_Initiator.config.get("browser");
        this.appPackage=ConfigObject_Initiator.config.get("appPackage");
    }

    protected WebElement getElement(String Locator) {
        WebElement elem = driver.findElement(getMappedLocatorAndReplace(Locator,""));
        return elem;
    }

    protected WebElement getElementVisibility(String Locator) {
        WebElement elem = waits.waitForvisibilityOfElementLocated(getMappedLocatorAndReplace(Locator,""));
        return elem;
    }

    protected WebElement getElementVisibility(String Locator, long timeout) {
        waits = new ApplicationWaits(driver, timeout);
        WebElement elem = waits.waitForvisibilityOfElementLocated(getMappedLocatorAndReplace(Locator,""));
        return elem;
    }

    protected WebElement getElementLocatedBy(By Locator) {
        WebElement elem = driver.findElement(Locator);
        return elem;
    }

    protected WebElement getElementLocatedByVisibility(By Locator) {
        WebElement elem = waits.waitForvisibilityOfElementLocated(Locator);
        return elem;
    }

    protected WebElement getElementLocatedByVisibility(By Locator, long timeout) {
        waits = new ApplicationWaits(driver, timeout);
        WebElement elem = waits.waitForvisibilityOfElementLocated(Locator);
        return elem;
    }

    protected List<WebElement> getElements(String Locator) {
        return driver.findElements(getMappedLocatorAndReplace(Locator,""));
    }

    protected List<WebElement> getElementsWithReplace(String Locator, String text) {
        return driver.findElements(getMappedLocatorAndReplace(Locator, text));
    }

    protected List<WebElement> getElementsWithReplace(String Locator, String text, String platform) {
        switch (platform.toLowerCase()) {
            case "ios":
                text = text;
                break;
            case "android":
                text = text.toUpperCase();
                break;
            default:
                text = text.toUpperCase();
        }
        System.out.println("text" + text);
        return driver.findElements(getMappedLocatorAndReplace(Locator, text));
    }

    protected List<WebElement> getElementsLocated(String Locator) {
        return waits.waitForpresenceOfElementLocated(getMappedLocatorAndReplace(Locator,""));
    }

    protected WebElement getElementWithReplace(String Locator, String text) {
        return getElementLocatedBy(getMappedLocatorAndReplace(Locator, text));
    }

    protected WebElement getElementVisibilityAfterReplace(String Locator, String text) {
        return getElementLocatedByVisibility(getMappedLocatorAndReplace(Locator, text));
    }

    protected List<WebElement> getElementsVisibilityAfterReplace(String Locator, String text) {
        return waits.waitForpresenceOfElementLocated(getMappedLocatorAndReplace(Locator, text));
    }

    protected WebElement getElementVisibilityAfterReplace(String Locator, String text, long timeout) {
        return getElementLocatedByVisibility(getMappedLocatorAndReplace(Locator, text), timeout);
    }

    protected WebElement getElementWhenVisible(String Locator) {
        WebElement elem = waits.waitForvisibilityOf(driver.findElement(getMappedLocatorAndReplace(Locator,"")));
        return elem;
    }

    protected WebElement getElementWhenDisplayed(String Locator) {
        try {
            WebElement elem = getElement(Locator);
            if (elem.isDisplayed()) {
                return elem;
            }
        } catch (Exception e) {

        }
        return null;
    }

    protected String replaceLocator(String Locator, String text) {
        return Locator.replaceFirst("dynamic", text);
    }

    protected WebElement getChildElement(WebElement element, String childLocator) {
        if (element.findElement(getMappedLocatorAndReplace(childLocator,"")).isDisplayed()) {
            return element.findElement(getMappedLocatorAndReplace(childLocator,""));
        }
        return null;
    }

    protected WebElement getChildElementWithReplace(WebElement element, String childLocator, String text) {
        WebElement childElement = waits
                .waitForvisibilityOf(element.findElement(this.getMappedLocatorAndReplace(childLocator, text)));
        return childElement;
    }

    public By getMappedLocatorAndReplace(String locator, String replace) {
        String pageName = this.getClass().getSimpleName();
        String value = "";
        for (PageName page : LocatorObject_Initiator.locatorPojo.getPages()) {
            if (page.getName().equals(pageName)) {
                for (Locators loc : page.getLocators()) {
                    if (loc.getName().equals(locator)) {

                        switch (device) {
                            case "android":
                                value = loc.getAndroid();
                                value = replaceAppPackage(value);
                                break;
                            case "ios":
                                value = loc.getIos();
                                value = replaceAppPackage(value);
                                break;
                            case "browser":
                                value = getWebLocatorValue(loc, browser);
                                break;
                        }
                    }
                }
            }
        }
        if(replace.equalsIgnoreCase("")|| replace.isEmpty()){
            return replaceLocatorFromYaml(value);
        }else
        return replaceLocatorFromYaml(value.replace("dynamic", replace));
    }

    public String getWebLocatorValue(Locators loc, String browserType) {
        String value = loc.getWeb();
        if (value == null || value.equals("")) {
        switch (browserType) {
            case "chrome":
                value = loc.getChrome();
                break;
            case "firefox":
                value = loc.getFirefox();
                break;
            case "safari":
                value = loc.getSafari();
                break;
            case "ie":
                value = loc.getIe();
                break;
            case "edge":
                value = loc.getEdge();
                break;
            default:
                value = "";
                break;
        }}
        if (value == null || value.equals("")) {
            value = loc.getChrome();
        }
        return value;
    }

    public By replaceLocatorFromYaml(String text) {
        String type = text.split("=", 2)[0];
        String value = text.split("=", 2)[1];
        switch (type) {
            case "xpath":
                return By.xpath(value);
            case "cssSelector":
                return By.cssSelector(value);
            case "name":
                return By.name(value);
            case "id":
                return By.id(value);
            case "className":
                return By.className(value);
            case "partialLink":
                return By.partialLinkText(value);
            case "tagName":
                return By.tagName(value);
            default:
                System.out.println("[DEBUG] : Invalid locator strategy ::::"+type);
                return null;
        }
    }

    public String replaceAppPackage(String value) {
        value = value.replace("appPackage", appPackage);
        return value;
    }
}
