package round1;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @package: round1
 * @Description:给定一棵二叉树 root，返回所有重复的子树。
 * @author: jilai_huang
 * @date: 2022/5/8 14:14
 */

public class Problem652 {
    public static HashMap<String, Integer> memo = new HashMap<>();//备忘录记录子树结构

    public static List<TreeNode> res = new ArrayList<>();//记录重复的子树

    //1.记录每个节点的子树信息（序列化）
    //2.使用数据结构记录其他子树信息并进行比较
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    //序列化
    public static String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subtree = left + "," + right + "," + root.val;
        //获取subtree的值，若没有返回0
        int freq = memo.getOrDefault(subtree, 0);
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subtree, freq + 1);
        return subtree;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n5.left = n7;
        n3.right = n6;
        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(n1);
        for (TreeNode duplicateSubtree : duplicateSubtrees) {
            System.out.println(duplicateSubtree.val);
        }
        for (String s : memo.keySet()) {
            System.out.println("key:" + s + " " + "value:" + memo.get(s));
        }

    }
}
