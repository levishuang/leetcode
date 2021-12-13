package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/11/16 21:06
 */

public class Practise {
    int a;
    int b;
//    交换指
    public Practise(int a, int b){
        this.a = b;
        this.b = a;
    }
//    public static void swap(int[] a, int b, int c){
////        int temp = b;
//
//        a[b] = c;
//        a[c] = b;
//    }


    public static void main(String[] args) {
        int a =10;
        int b = 5;
        Practise p = new Practise(a, b);
        System.out.println(p.a);
        System.out.println(p.b);
    }
}
