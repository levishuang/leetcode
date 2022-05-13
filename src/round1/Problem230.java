package round1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/11 11:01
 */

public class Problem230 {
    static List<Integer> list = new ArrayList<>();
    public static int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k-1);
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.println(kthSmallest(n1, 3));
    }
}
