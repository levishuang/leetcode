package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/11 11:56
 */

public class Problem538_2 {
    static int sum;
    public static TreeNode convertBST(TreeNode root) {
        inOrder(root);
        return root;
    }
    //中序遍历，先右后左，直接相加就行
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.right);
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        TreeNode treeNode = convertBST(n1);
        preOrder(treeNode);
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

}
