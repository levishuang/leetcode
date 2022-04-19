package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/13 21:50
 */

public class Problem226 {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return root;
    }

    public static void traverse(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        traverse(n1);
        System.out.println("----------");
        TreeNode temp = invertTree(n1);
        traverse(temp);
    }
}
