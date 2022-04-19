package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/7 22:24
 */

public class Problem95 {
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return count(1, n);


    }
    public static List<TreeNode> count(int low, int high){
        List<TreeNode> res = new ArrayList<>();
        if(low > high){
            res.add(null);
            return res;
        }
        for(int i = low; i <= high; i++){
            List<TreeNode> left = count(low, i-1);
            List<TreeNode> right = count(i+1, high);
            for (TreeNode treeNode : left) {
                for (TreeNode node : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = treeNode;
                    root.right = node;
                    res.add(root);
                }
            }
        }
        return res;
    }
    public static void traversePre(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        traversePre(root.left);
        traversePre(root.right);
    }

    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
        for (TreeNode treeNode : list) {
            traversePre(treeNode);
        }


    }

}
