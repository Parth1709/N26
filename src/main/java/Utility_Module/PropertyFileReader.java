package Utility_Module;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/** to read from property file**
 *
 */
public class PropertyFileReader {

    FileInputStream file;
    public PropertyFileReader(){
        try {
            file = new FileInputStream(System.getProperty("user.dir")+File.separator+"gradle.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    PropertyFileReader(FileInputStream file){
        this.file=file;
    }

    public String getValueFromDefaultPropertyFile(String key) {
        try {
            Properties p=new Properties();
            p.load(file);
            return p.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, String> getValuesFromPropertyFile() {
        HashMap<String,String> propMap = new HashMap<String,String>();
        try {
            Properties p=new Properties();
            p.load(file);
            for(Object key:p.keySet()) {
                propMap.put(key.toString(), p.get(key).toString());
            }
            return propMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setProperty(FileOutputStream file, Map<String, String> conf) {
        try {

            Properties prop = new Properties();
            // set the properties value
            prop.putAll(conf);
            // save properties to project root folder
            prop.store(file, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
