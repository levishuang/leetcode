package round1;

import java.util.*;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/22 21:48
 */

public class Problem763 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        Set<Character> characterSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            characterSet.add(s.charAt(i));
        }
        Iterator<Character> iterator = characterSet.iterator();
        int i = 0;
        int[][] index = new int[characterSet.size()][2];
        while (iterator.hasNext()){
            char temp = iterator.next();
            int first = s.indexOf(temp);
            int last = s.lastIndexOf(temp);
            index[i][0] = first;
            index[i][1] = last;
            i++;

        }
        Arrays.sort(index, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                }else if(o1[0] == o2[0]){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        int left = index[0][0];
        int right = index[0][1];
        for(int j = 1; j < characterSet.size(); j++){
            if(index[j][0] < right){
                right = right > index[j][1]?right:index[j][1];
            }else {
                list.add(right-left+1);
                left = index[j][0];
                right = index[j][1];
            }
        }
        list.add(right-left+1);
        return list;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = new ArrayList<>();
        list = partitionLabels(s);
        for(Integer num : list){
            System.out.println(num);
        }







    }
}
