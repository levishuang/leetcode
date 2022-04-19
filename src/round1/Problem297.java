package round1;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/12 11:18
 */

public class Problem297 {

    // Encodes a tree to a single string.
    //使用层序遍历序列化和反序列化
    public static String serialize(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            for(int i = 0; i< size; i++){
                TreeNode poll = deque.poll();
                stringBuffer.append(poll.val);
                if(poll.left != null){
                    deque.add(poll.left);
                }
                if(poll.right != null){
                    deque.add(poll.right);
                }
            }
        }
        return stringBuffer.toString();

    }

    static StringBuffer stringBuffer = new StringBuffer();
    //使用前序遍历
    public static String serializePre(TreeNode root){
        traverse(root);
        return stringBuffer.toString();
    }
    public static void traverse(TreeNode root){
        if(root == null){
            stringBuffer.append(-1);
            stringBuffer.append(",");
            return;
        }
        stringBuffer.append(root.val);
        stringBuffer.append(",");
        traverse(root.left);
        traverse(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        List<String> ans = stringArr(data);
        TreeNode root = generateTree(ans);
        return root;
    }

    public static TreeNode generateTree(List<String> list){
        String first = list.remove(0);
        if(-1 == Integer.parseInt(first)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = generateTree(list);
        root.right = generateTree(list);

        return root;
    }
    public static List<String> stringArr(String data){
        List<String> ans = new LinkedList<>();
        String[] split = data.split(",");
        for (String s : split) {
            ans.add(s);
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.left = n5;
        n3.right = n6;
//        System.out.println(serializePre(n1));
        String s = serializePre(n1);
        System.out.println(s);
        TreeNode root = deserialize(s);
        String s1 = serializePre(root);
        System.out.println(s1);




    }
}
