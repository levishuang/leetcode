package round1;

/**
 * @package: round1
 * @Description:根据前序和中序序列创建二叉树
 * @author: jilai_huang
 * @date: 2022/4/25 21:41
 */

public class Problem105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public static TreeNode build(int[] preorder, int[] inorder, int preStart,int preEnd, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        //根据前序序列的输入确定中序序列所在位置
        int index = -1;
        //拿到前序序列的第一个数
        int num = preorder[preStart];
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == num){
                index = i;
            }
        }
        int len = index - inStart;
        TreeNode root = new TreeNode(num);
        root.left = build(preorder, inorder, preStart+1, preStart+len, inStart, index-1);
        root.right = build(preorder, inorder, preStart+len+1, preEnd, index+1, inEnd);
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
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = buildTree(preOrder, inOrder);
        preOrder(root);
    }
}
