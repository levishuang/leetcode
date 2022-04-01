package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/27 22:01
 */

public class Problem605_2 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            int pre = (i == 0?0:flowerbed[i-1]);
            int suf = (i == flowerbed.length-1 ? 0 : flowerbed[i+1]);
            if(flowerbed[i] == 1){
                continue;
            }else {
                if(pre == 0 && suf == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return n <= count;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0,0,1,0,0};
        System.out.println(canPlaceFlowers(flowerbed,1));
    }
}
