package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/8 14:57
 */

public class Problem543_3 {
    //记录最大直径
    static int max_len;
    //记录每个节点的直径，并记录最大直径值
    public static int traverse(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        max_len = Math.max(max_len, left+right);
        return Math.max(left, right)+1;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max_len;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(diameterOfBinaryTree(n1));
    }

}
