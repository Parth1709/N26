package ObjectInitiator_Module;

import java.util.HashMap;

public class ConfigObject_Initiator {

    public static HashMap<String,String> config= new HashMap<String,String>();

    public void updateConfigMap(){

        for(String key:config.keySet()){
            config.replace(key,System.getProperty(key,config.get(key)));
        }
        System.out.println(config.entrySet());
    }

    public void updateConfigMap(String key , String value){
        config.replace(key,value);
    }

}
