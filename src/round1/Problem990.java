package round1;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/26 21:11
 */

public class Problem990 {
    static private int[] parent;
    static private int count;
    static class UF{

        public UF(int n){
//            this.count = n;
            //a-z有26个数，然后再减去a,所以index的范围是0-25
//            parent = new int[26];
//            for(int i = 0; i < n; i++){
//                parent[i] = i;
//            }
        }
        //查找x的根节点，并进行路径优化
        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean connected(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
        public int count(){
            return count;
        }
    }
    public static boolean equationsPossible(String[] equations) {
        parent = new int[26];
        //统计有多少个不同的字母
        HashSet<Character> alph = new HashSet<>();
        for (String equation : equations) {
            alph.add(equation.charAt(0));
            alph.add(equation.charAt(3));
        }

        int n  = alph.size();
        count = n;
        //对parent进行初始化
        Iterator<Character> iterator = alph.iterator();
        while (iterator.hasNext()){
            int index = iterator.next()-'a';
            parent[index] = index;
        }
        UF uf = new UF(n);
        //将字符转化为数字,并对==进行连接
        for (String equation : equations) {
            int first  = equation.charAt(0)-'a';
            int last = equation.charAt(3) - 'a';
            if(equation.charAt(1) == '=' && equation.charAt(2) == '='){
                uf.union(first, last);
            }
        }
        //对！=进行判断是否连接
        for (String equation : equations) {
            int first  = equation.charAt(0)-'a';
            int last = equation.charAt(3) - 'a';
            if(equation.charAt(1) == '!' && equation.charAt(2) == '='){
                if(uf.connected(first, last)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"a==b", "c!=b", "a==c"};
        System.out.println(equationsPossible(strs));
    }
}
