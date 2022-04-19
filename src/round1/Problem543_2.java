package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/11 22:31
 */

public class Problem543_2 {
    static int max_diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max_diameter;
    }

    public static int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int my_diameter = left + right;
        max_diameter = Math.max(my_diameter, max_diameter);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(9);
//        TreeNode n2 = new TreeNode(1);
//        TreeNode n3 = new TreeNode(2);
//        TreeNode n4 = new TreeNode(3);
//        TreeNode n5 = new TreeNode(4);
//        TreeNode n6 = new TreeNode(5);
//        n1.right = n2;
//        n2.left = n3;
//        n2.right = n4;
//        n3.left = n5;
//        n3.right = n6;
        System.out.println(diameterOfBinaryTree(n1));
    }

}
