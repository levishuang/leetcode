package round1;

import java.util.Map;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/8 14:52
 */

public class Problem104 {
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left , right)+1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n5.left = n7;
        n3.right = n6;
        int deep = maxDepth(n1);
        System.out.println(deep);
    }
}
