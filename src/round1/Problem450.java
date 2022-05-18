package round1;

import static round1.Problem700.preOrder;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/13 11:30
 */

public class Problem450 {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            //删除
            //删除左子树为空或右子树一个为空的情况
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //删除左右子树均不为空的情况
            //1.找到左子树最大的节点或右子树最小的节点
            TreeNode rightMin = getMin(root.right);
            //删除最小的节点
            root.right = deleteNode(root.right, rightMin.val);
            rightMin.left = root.left;
            rightMin.right = root.right;
            root = rightMin;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    private static TreeNode getMin(TreeNode root) {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        TreeNode node = deleteNode(n1, 3);
        preOrder(node);

    }

}
