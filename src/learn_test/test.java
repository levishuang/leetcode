package learn_test;

import java.util.HashMap;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/24 14:53
 */

public class test {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,3);
        map.put(1,4);
        System.out.println(map.size());
    }
}
