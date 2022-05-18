package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/15 15:00
 */

public class Problem96_review {
    static int memo[][];

    public static int numTrees(int n) {
        memo = new int[n+1][n+1];
        return build(1, n);

    }

    private static int build(int low, int high) {
        if (low > high) {
            return 1;
        }
        if(memo[low][high] != 0){
            return memo[low][high];
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = build(low, i - 1);
            int right = build(i + 1, high);
            res += left * right;
        }
        memo[low][high] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));

    }
}
