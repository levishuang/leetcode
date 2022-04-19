package round1;

import java.util.*;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/12 10:07
 */

public class Problem515 {

    public static List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            //计算每一层的最大值
            //注意复制是浅拷贝还是深拷贝
            Queue<TreeNode> tempQueue = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                tempQueue.add(temp);
                max = Math.max(max, temp.val);
            }
            res.add(max);
            int size2 = tempQueue.size();
            for(int i = 0; i < size2; i++){
                TreeNode temp2 = tempQueue.poll();
                if(temp2.left != null){
                    queue.add(temp2.left);
                }
                if(temp2.right != null){
                    queue.add(temp2.right);
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        List<Integer> res = largestValues(n1);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
