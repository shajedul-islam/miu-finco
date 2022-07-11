package ioc;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class IOCContainer {
    public static Map<String, IComponent> componentMap;

    public static void buildApplicationContext() {
        Properties properties = new Properties();
        try {
            properties.load(IOCContainer.class.getResourceAsStream("finco-dependencies.properties"));
            componentMap = new HashMap<String, IComponent>();

            // Sort the properties in order they were written in the file
            Map<String, String> treeMap = new TreeMap<>();
            for (Object key : properties.keySet()) {
                String keyName = key.toString();
                String val = properties.getProperty(keyName);
                treeMap.put(keyName, val);
            }

            for (Object key : treeMap.keySet()) {
                String keyName = key.toString();
                String val = properties.getProperty(keyName);
                if (keyName.contains("component.")) {
                    String[] keys = keyName.split("\\.");
                    String componentName = keys[1];

                    Class clz = Class.forName(val);
                    componentMap.put(componentName, (IComponent) clz.getDeclaredConstructor().newInstance());
                } else {
                    String[] keys = keyName.split("\\.");
                    IComponent obj = componentMap.get(keys[0].split("\\-")[1]);
                    PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(keys[1], obj.getClass());
                    objPropertyDescriptor.getWriteMethod().invoke(obj, componentMap.get(val));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
