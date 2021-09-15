package ObjectInitiator_Module;

import Utility_Module.CommonLocatorPojo;
import Utility_Module.YamlFileReader;

import java.io.File;
import java.io.InputStream;

public class LocatorObject_Initiator {

    static InputStream file;

    public static CommonLocatorPojo locatorPojo;

    public LocatorObject_Initiator() {
            file = this.getClass().getClassLoader()
                    .getResourceAsStream("Locators" + File.separator + "CommonLocators.yml");
        locatorPojo = YamlFileReader.mapYamlPojo(file);
    }

    public LocatorObject_Initiator(InputStream locatorFile) {
        locatorPojo = YamlFileReader.mapYamlPojo(locatorFile);
    }

}
