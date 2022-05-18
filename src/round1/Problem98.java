package round1;

import com.sun.deploy.panel.TreeBuilder;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:判断是否为二叉搜索树
 * @author: jilai_huang
 * @date: 2022/5/13 12:07
 */

public class Problem98 {

//    public static boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        for(int i = 1; i < list.size(); i++){
//            if(list.get(i) <= list.get(i-1)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void inOrder(TreeNode root, List<Integer> list){
//        if(root == null){
//            return;
//        }
//        inOrder(root.left, list);
//        list.add(root.val);
//        inOrder(root.right, list);
//    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        //遍历左子树是否为二叉排序树，此时根节点为最大值
        boolean left = isValidBST(root.left, min, root);
        //遍历右子树是否为二叉排序树
        boolean right = isValidBST(root.right, root, max);
        return left && right;
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
        System.out.println(isValidBST(n1));
    }
}
