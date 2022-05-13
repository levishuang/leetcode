package round1;

import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/8 16:37
 */

public class Problem297_2 {
    //使用前序遍历进行序列化为字符串
    static StringBuffer stringBuffer = new StringBuffer();
    public static String serialize(TreeNode root){
        traverse(root);
        return stringBuffer.toString();
    }
    public static void traverse(TreeNode root){
        //当为空节点时赋值-1，并用，隔开
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

    public static TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        return string2Node(strArr, 0, strArr.length);
    }
    //进行先序遍历创建树用List<Integer>
    public static TreeNode string2Node(String[] strArr, int index, int end){
        if(index < end && Integer.parseInt(strArr[index]) == -1){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strArr[index]));
        root.left = string2Node(strArr, index+1, end);
        root.right = string2Node(strArr, index+1, end);
        return root;

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
//        System.out.println(serialize(n1));
        String serialize = serialize(n1);
        System.out.println("序列化的结果：");
        System.out.println(serialize);
        TreeNode treeNode = deserialize(serialize);
        System.out.println("返序列化后的结果：");
        preTraverse(treeNode);
    }

    public static void preTraverse(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preTraverse(root.left);
        preTraverse(root.right);
    }
}
