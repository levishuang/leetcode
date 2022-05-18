package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/7 22:04
 */

public class MergeSort {
//    public static int[] sort(int[] a, int low, int high) {
//        int mid = (low + high) / 2;
//        if (low < high) {
//            sort(a, low, mid);
//            sort(a, mid + 1, high);
//            //左右归并
//            merge(a, low, mid, high);
//        }
//        return a;
//    }
//
//    public static void merge(int[] a, int low, int mid, int high) {
//        int[] temp = new int[high - low + 1];
//        int i = low;
//        int j = mid + 1;
//        int k = 0;
//        // 把较小的数先移到新数组中
//        while (i <= mid && j <= high) {
//            if (a[i] < a[j]) {
//                temp[k++] = a[i++];
//            } else {
//                temp[k++] = a[j++];
//            }
//        }
//        // 把左边剩余的数移入数组
//        while (i <= mid) {
//            temp[k++] = a[i++];
//        }
//        // 把右边边剩余的数移入数组
//        while (j <= high) {
//            temp[k++] = a[j++];
//        }
//        // 把新数组中的数覆盖nums数组
//        for (int x = 0; x < temp.length; x++) {
//            a[x + low] = temp[x];
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {5, 3, 7, 2, 8, 1};
//        int[] res = sort(nums, 0, nums.length - 1);
//        for (int re : res) {
//            System.out.println(re);
//        }
//    }
    public static int[] sort(int[] nums){
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length-1, temp);
        return nums;
    }
    public static void sort(int[] nums, int low, int high, int[] temp){
        if(low == high){
            return ;
        }
        int mid = low + (high-low)/2;
        sort(nums, low, mid, temp);
        sort(nums, mid+1, high, temp);
        merge(nums, low, mid, high, temp);
    }

    private static void merge(int[] nums, int low, int mid, int high, int[] temp) {
        int left = low;
        int right = mid+1;
        int  t = 0;
        while (left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[t++] = nums[left++];
            }else {
                temp[t++] = nums[right++];
            }
        }
        while (right <= high){
            temp[t++] = nums[right++];
        }
        while (left <= mid){
            temp[t++] = nums[left++];
        }
        t = 0;
//        while (low <= high){
//            nums[low++] = temp[t++];
//        }
        for(int i = low; i <= high; i++){
            nums[i] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,6,3,8};
        for (int i : sort(nums)) {
            System.out.println(i);
        }

    }

}
