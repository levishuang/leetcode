package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/22 11:01
 */

public class Problem274 {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int left = 0, right = citations.length-1;
        while(left <= right){
            int middle = left + (right-left)/2;
            if(citations[middle] >= citations.length-middle){
                right = middle-1;
            }else {
                left = middle+1;
            }
        }
        return citations.length-left;

    }

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
}
