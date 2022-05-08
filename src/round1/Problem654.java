package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/21 19:27
 */

public class Problem654 {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public static TreeNode build(int[] nums, int low, int high){
        if(low > high){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = low; i <= high; i++){
            if(max <= nums[i]){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums,low, index-1);
        root.right = build(nums, index+1, high);
        return root;
    }

    //前序遍历
    public static void traverse(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);
        traverse(root);
    }
}
