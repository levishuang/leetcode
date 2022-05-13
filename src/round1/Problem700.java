package round1;

import sun.reflect.generics.tree.Tree;

import javax.security.auth.login.CredentialException;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/13 11:06
 */

public class Problem700 {
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        return root.val > val?searchBST(root.left, val):searchBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left= n4;
        n2.right = n5;
        TreeNode treeNode = searchBST(n1, 2);
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
