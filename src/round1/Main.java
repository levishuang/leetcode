package round1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Package: round1
 * @Description:
 * @Date: 2021/11/10 11:59
 * @Author: Jilai Huang
 */
public class Main {
    public static void main(String[] args) {
//        Problem17 p = new Problem17();
//        String digits = "23";
//        List<String> list = new ArrayList<>();
//        list = p.letterCombinations(digits);
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        test t = new test();
        String digits = "23";
        List<String> list = new ArrayList<>();
        list = t.letterCombinations(digits);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }

    }
}
