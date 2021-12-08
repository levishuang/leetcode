package round1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Package: round1
 * @Description:
 * @Date: 2021/12/8 14:33
 * @Author: Jilai Huang
 */
public class Problem20 {
    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<Character>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{'){
                deque.addFirst(temp);
            }
            switch(temp){
                case ')':
                    if(deque.isEmpty() || deque.getFirst() != '('){
                        return false;
                    }else{
                        deque.removeFirst();
                    }
                    break;
                case ']':
                    if(deque.isEmpty() || deque.getFirst() != '['){
                        return false;
                    }else{
                        deque.removeFirst();
                    }
                    break;
                case '}':
                    if(deque.isEmpty() || deque.getFirst() != '{'){
                        return false;
                    }else {
                        deque.removeFirst();
                    }
                    break;
                default:
                    continue;
            }
        }
        if(deque.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "{()[]}";
        System.out.println(isValid(s));

    }
}
