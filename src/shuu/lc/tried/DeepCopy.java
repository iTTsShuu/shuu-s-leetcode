package tried;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy {

    static int a = 100;
    Map<Integer, String> map = new HashMap<>();

    static void changeA(int a) {
        a++;
    }

    static void addto(Map<Integer, String> map) {
        map.put(1, "my god");
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        addto(map);
        System.out.println(map.get(1));
    }
}
