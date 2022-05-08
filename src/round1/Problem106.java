package round1;

/**
 * @package: round1
 * @Description:通过后序和中序构造二叉树
 * @author: jilai_huang
 * @date: 2022/4/26 9:49
 */

public class Problem106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    public static TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd){
            return null;
        }
        //找到根节点以及在中序序列的位置
        int num = postorder[postEnd];
        int index = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == num){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(num);
        //左子树的长度
        int len = index - inStart;
        root.left = build(inorder,postorder, inStart, index-1, postStart, postStart+len-1);
        root.right = build(inorder, postorder, index+1, inEnd, postStart+len, postEnd-1);
        return root;

    }
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, postorder);
        preOrder(treeNode);
    }
}
