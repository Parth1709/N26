package Utility_Module;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class YamlFileReader {

    static Yaml yaml = null;
    static Yaml userData = null;

    File file;
    YamlFileReader(){
    }

    YamlFileReader(File file){
        this.file=file;
    }

    public String getValueFromYaml(){
        return null;
    }

    public Map<Object,Object> getValuesFromYaml(){
        Map<Object,Object> yamlData = new HashMap<Object,Object>();
        return yamlData;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> loadDefaultYaml() {
        yaml = new Yaml();
        InputStream inputStream = null;
        PropertyFileReader prop = new PropertyFileReader();
        String[] locatorsPath = prop.getValueFromDefaultPropertyFile("locatorspath").split("/");
        String basepath = System.getProperty("user.dir");
        for (String path : locatorsPath) {
            basepath += File.separator + path;
        }
        try {
            inputStream = new FileInputStream(basepath);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return yaml.load(inputStream);
    }

    public static Map<String, Object> getMap() {
        return loadDefaultYaml();
    }

    public static String getValues(String key) {
        return getMap().get(key).toString();
    }

    public static String getValue(String key) {
        return null;
    }

    public static CommonLocatorPojo mapYamlPojo(String file) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(new File(file), CommonLocatorPojo.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CommonLocatorPojo mapYamlPojo(InputStream file) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(file, CommonLocatorPojo.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    public static Map<String, Object> loadUserDataYaml(InputStream userDataStream) {
        yaml = new Yaml();
        return yaml.load(userDataStream);
    }
}
