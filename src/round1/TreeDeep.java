package round1;

/**
 * @package: round1
 * @Description:返回树的最大高度
 * @author: jilai_huang
 * @date: 2022/4/12 9:17
 */

public class TreeDeep {
    public static int deep1(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = deep1(root.left);
        int right = deep1(root.right);
        int my_deep = Math.max(left, right)+1;
        return my_deep;
    }


    static int deep = 0;
    static int res = 0;
    public static void deep2(TreeNode root){
        if(root == null){
            res = Math.max(res, deep);
            return ;
        }
        deep++;
        deep2(root.left);
        deep2(root.right);
        deep--;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        System.out.println(deep1(n1));

    }
}
