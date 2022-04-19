package round1;

import sun.reflect.generics.tree.Tree;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/11 21:09
 */

public class Problem543 {
    static int maxDiameter  = 0;
    public static int traverse(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = maxDeep(root.left);
        int rightMax = maxDeep(root.right);
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(myDiameter, maxDiameter);
        traverse(root.left);
        traverse(root.right);
        return maxDiameter;
    }

    //二叉树的最大深度
    public static int maxDeep(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDeep(root.left);
        int right = maxDeep(root.right);
        int res = Math.max(left, right)+1;
        return res;
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        return traverse(root);
    }



    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(5);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
        System.out.println(diameterOfBinaryTree(n1));


    }
}
