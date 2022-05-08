package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/26 9:40
 */

public class Problem105_2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        int num = preorder[prestart];
        //获取根节点
        TreeNode root = new TreeNode(num);
        //获取根节点所在位置并进行切分
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (num == inorder[i]) {
                index = i;
                break;
            }
        }
        //统计左子树的长度
        int len = index - instart;
        root.left = build(preorder, inorder, prestart + 1, prestart + len, instart, index - 1);
        root.right = build(preorder, inorder, prestart + len + 1, preend, index + 1, inend);
        return root;
    }
}
