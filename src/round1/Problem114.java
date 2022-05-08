package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/21 15:50
 */

public class Problem114 {

    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left  = root.left;
        TreeNode right = root.right;
        root.left = null;
        right.right = left;
        TreeNode temp = root;
        while (temp.right != null){
            temp = temp.right;
        }
        temp.right = right;
    }



}
