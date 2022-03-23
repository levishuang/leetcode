package round1;

import sun.reflect.generics.tree.Tree;

import java.util.TreeMap;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/17 16:15
 */

public class Demo {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(((o1, o2) -> Integer.compare(o1, o2)));
        map.put(1, "huang");
        map.put(3, "li");
        TreeMap<Integer, String> map1 = new TreeMap<>(((o1, o2) -> Integer.compare(o2, o1)));
        map1.put(1, "huang");
        map1.put(3, "li");
        System.out.println(map);
        System.out.println(map1);
    }
}
