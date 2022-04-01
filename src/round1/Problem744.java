package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/28 10:31
 */

public class Problem744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        if(target == 'z') return letters[0];
        int target2Num = char2num(target);
        int[] letters2Nums = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            letters2Nums[i] = char2num(letters[i]);
        }
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
//            if(letters2Nums[middle] == target2Num){
//                return letters[middle];
//            }else
            if (letters2Nums[middle] > target2Num) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return low >= letters.length? ' ':letters[low];
    }

    public static int char2num(char c) {
        return c - 'a';
    }

    public static char num2Char(int n) {
        return (char) (n + 'a');
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'j';
        System.out.println(nextGreatestLetter(letters, target));
    }
}
