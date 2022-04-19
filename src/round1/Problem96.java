package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/10 22:06
 */

public class Problem96 {
    static int[][] memo;

    /* 主函数 */
    public static int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        // 计算闭区间 [1, n] 组成的 BST 个数
        return count(1, n);
    }

    /* 计算闭区间 [lo, hi] 组成的 BST 个数 */
    static int count(int lo, int hi) {
        // base case
        if (lo > hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i 的值作为根节点 root
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;
        return res;
    }


    public static int numTrees1(int n){
        return count1(1, n);
    }

    public static int count1(int low, int high){
        if(low > high){
            return 1;
        }
        if(memo[low][high] != 0){
            return memo[low][high];
        }
        int res = 0;
        for(int i = low; i <= high; i++){
            int left = count1(low, i-1);
            int right = count1(i+1, high);
            res += left*right;
        }
        memo[low][high] = res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numTrees(2));
    }
}
