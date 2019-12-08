package exercitii2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EliminareDupHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("A", "4");
        map.put("B", "1");
        map.put("C", "2");
        map.put("D", "3");
        map.put("E", "3");
        map.put("F", "21");

        System.out.println(map);

        for (String s : new ConcurrentHashMap<>(map).keySet()) {
            String value = map.get(s);
            for (Map.Entry<String, String> ss : new ConcurrentHashMap<>(map).entrySet()) {
                if (s != ss.getKey() && value == ss.getValue()) {
                    map.remove(ss.getKey());
                }
            }
        }
        System.out.println(map);
    }
}
