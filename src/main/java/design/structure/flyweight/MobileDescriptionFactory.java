package design.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

public class MobileDescriptionFactory {
    private final static Map<String,String> DESCRIPTION_MAP = new HashMap();
    public static String getDescrition(Mobile mobile){
        String description = DESCRIPTION_MAP.get(mobile.getName());
        if(null == description){
            description = mobile.description();
            DESCRIPTION_MAP.put(mobile.getName(),description);
        }
        return description;
    }
}
