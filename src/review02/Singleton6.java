package review02;

import java.util.HashMap;
import java.util.Map;
/**
 * 容器类实现单例模式
 */
public class Singleton6 {
    private static Map<String, Object> objMap = new HashMap<String, Object>();

    public static void regsiterService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}
