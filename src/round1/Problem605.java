package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/13 20:07
 */

public class Problem605 {
    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        //记录已经种植的花的个数
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                count++;
            }
        }
        //偶数的固定花数量为一半
        if (flowerbed.length % 2 == 0) {
            if (count + n > flowerbed.length / 2) {
                return false;
            }
        } else {
            //第一个不种花,花的数量为len/2,
            if (flowerbed[0] == 0 || flowerbed[flowerbed.length - 1] == 0) {
                if (count + n > flowerbed.length / 2) {
                    return false;
                }
            } else {
                if (count + n > (flowerbed.length + 1) / 2) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            } else {
                int pre = (i == 0 ? 0 : flowerbed[i - 1]);
                int next = (i == len - 1 ? 0 : flowerbed[i + 1]);
                if(pre == 0 && next == 0){
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        return n <= count;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2));

    }
}
