package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/20 16:28
 */

public class Problem875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0, max = 0;
        for (int pile : piles) {
            max = max > pile ? max : pile;
        }
        int high = max+1;
//        while (low <= high) {
//            int middle = low + (high - low) / 2;
//            if (f(piles, middle) > h) {
//                low = middle + 1;
//            } else if (f(piles, middle) < h) {
//                high = middle - 1;
//            } else if (f(piles, middle) == h) {
//                high = middle - 1;//为了找最小的那个值
//            }
//        }
//        if (low > max) return -1;
        while (low < high){
            int middle = low + (high-low)/2;
            if(f(piles, middle) > h){
                low = middle+1;
            }else if(f(piles, middle) < h){
                high = middle;
            }else if(f(piles, middle) == h){
                high = middle;
            }
        }
        return low;
    }

    /**
     * @param piles
     * @param x     吃的速度为x
     * @return
     */
    public static long f(int[] piles, long x) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile / x;
            if (pile % x != 0) {
                hours++;
            }
        }
        return hours;
    }

    public static void main(String[] args) {
        int[] piles = {312884470};
        System.out.println(minEatingSpeed(piles, 968709470));
    }
}

