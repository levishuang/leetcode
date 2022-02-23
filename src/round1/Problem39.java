package round1;

import sun.security.krb5.internal.PAData;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @package: round1
 * @Description:回溯加递归的方法
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * @author: jilai_huang
 * @date: 2021/12/19 14:52
 */

public class Problem39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, target, 0, len, path, ans);
        return ans;

    }

    /**
     * 回溯法计算可能出现的组合
     * @param candidates 数组元素
     * @param target 目标数的大小
     * @param begin     起始下标
     * @param len   结束下标
     * @param path  满足条件的路径
     * @param ans
     */
    private static void dfs(int[] candidates, int target, int begin, int len, Deque<Integer> path, List<List<Integer>> ans) {
        if(target < 0){
            return;
        }
        //当target为0时表明找到了一条路径
        if(target == 0){
            ans.add((new ArrayList<>(path)));
            return;
        }
        //当target>0时添加节点到path中
        for(int i = begin; i < len; i++){
            path.addLast(candidates[i]);
            //进行深度遍历找路径
            dfs(candidates, target-candidates[i], i, len, path, ans);
            //如果不符合条件把最后一个删除
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int nums[] = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(nums, target);
        for (List<Integer> l:ans ) {
            for (int temp:l) {
                System.out.print(temp);
            }
            System.out.println();
        }

    }
}
