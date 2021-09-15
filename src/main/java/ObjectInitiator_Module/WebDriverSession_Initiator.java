package ObjectInitiator_Module;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class WebDriverSession_Initiator {
    public static WebDriver getDriver(Map<String, String> config) {
        String device = config.get("device").toLowerCase();
        System.out.println("platform:::"+device);
        switch (device) {
            case "android":
                return getApp(config);
            case "ios":
                return getAppiOS(config);
            case "browser":
                System.out.println("in browser switch");
                return getBrowserDriver(config);
            default:
                return null;
        }

    }

    public static WebDriver getApp(Map<String, String> config) {
        // Build the Appium service
        String chromedriverExecutable = System.getProperty("chromedriverExecutable",
                System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
                        + "resources" + File.separator + "Drivers");
        DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("automationName", "UiAutomator1");
            cap.setCapability("deviceName", config.get("deviceName"));
            cap.setCapability("platformVersion", config.get("platformVersion"));
            cap.setCapability("appActivity", config.get("appActivity"));
            cap.setCapability("appWaitDuration", config.get("appWaitDuration"));
            cap.setCapability("uuid", config.get("uuid"));
            if (config.get("appPath").equalsIgnoreCase("true")) {
                File file = new File(config.get("app"));
                cap.setCapability("app", file.getAbsolutePath());
            }else {
                cap.setCapability("appPackage", config.get("appPackage"));
            }
            if (config.get("debug").equalsIgnoreCase("true"))
                cap.setCapability("noReset", "true");
            else
                cap.setCapability("noReset", "false");
            cap.setCapability("fullReset", "false");
            cap.setCapability("autoGrantPermissions", "true");
            cap.setCapability("autoAcceptAlerts", "true");
            cap.setCapability("chromedriverExecutableDir", chromedriverExecutable);
            if (config.get("use_avd").equalsIgnoreCase("true")) {
                cap.setCapability("avd", config.get("avd"));
            }
            if (config.get("deviceType").equalsIgnoreCase("androidtv")) {
                cap.setCapability("autoLaunch", false);
                cap.setCapability("udid", config.get("udid"));
                cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.parseInt(config.get("systemPort")));
            }
            cap.setCapability("mjpegServerPort", config.get("mjpegServerPort"));
        try {
            return new AndroidDriver(
                    new URL("http://" + config.get("remoteIp") + ":" + config.get("port") + "/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static WebDriver getAppiOS(Map<String, String> config) {
        DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platformName", config.get("platformName"));
            cap.setCapability("platformVersion", config.get("platformVersion"));
            cap.setCapability("deviceName", config.get("deviceName"));
            if (config.get("appPath").equalsIgnoreCase("true")) {
                File file = new File(config.get("app"));
                cap.setCapability("app", file.getAbsolutePath());
            } else {
                cap.setCapability("bundleId", config.get("appPackage"));
            }
            cap.setCapability("automationName", "XCUITest");
            cap.setCapability("appWaitDuration", config.get("appWaitDuration"));
            cap.setCapability("appName", "OneTv");
            cap.setCapability("autoGrantPermissions", "true");
            cap.setCapability("autoAcceptAlerts", "true");
            cap.setCapability("udid", config.get("uuid"));
            if (config.get("debug").equalsIgnoreCase("true"))
                cap.setCapability("noReset", "true");
            else
                cap.setCapability("noReset", "false");
            cap.setCapability("fullReset", "false");
            if (config.get("use_avd").equalsIgnoreCase("true")) {
                cap.setCapability("avd", config.get("avd"));
            }
        try {
            return new IOSDriver<>(
                    new URL("http://" + config.get("remoteIp") + ":" + config.get("port") + "/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DesiredCapabilities addDesiredCapabilities(){
//        Map<String,String> mwebMap = new HashMap<>();
//        mwebMap.put("deviceName","GalaxyS5");
//
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        dc.setCapability(ChromeOptions.CAPABILITY, mwebMap);
        return null;
    }

    public static WebDriver getBrowserDriver(Map<String, String> config) {
        String browserType = config.get("browser").toLowerCase();
        WebDriver driver = null;
        System.out.println("-----------::::"+config.entrySet());
        switch(browserType) {
            case "chrome":
                System.out.println("in chrome switch");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver = new EdgeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("Incorrect browser type");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
