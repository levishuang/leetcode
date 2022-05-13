package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/11 11:39
 */

public class Problem538 {
    static int sum;
    static int subSum;

    public static TreeNode convertBST(TreeNode root) {
        inOrderTotal(root);
        updateEachNode(root);
        return root;
    }

    //使用遍历计算树的总和
    public static void inOrderTotal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTotal(root.left);
        sum += root.val;
        inOrderTotal(root.right);
    }

    public static void updateEachNode(TreeNode root){
        if(root == null){
            return;
        }
        updateEachNode(root.left);
        int temp = root.val;
        subSum += temp;
        root.val = sum - subSum + temp;
        updateEachNode(root.right);
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
