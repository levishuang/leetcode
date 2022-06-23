package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/21 10:36
 */

public class Problem275 {
    public static int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right){
            int middle = left + (right-left)/2;
            //f计算出有多少篇文章
            if(citations[middle] >= f(citations, citations[middle])){
                right = middle;
            }else if(citations[middle] < f(citations, citations[middle])){
                left = middle+1;
            }
        }
        return citations.length - left;
    }
    //判断x篇论文至少被引用x次
    //x表示citations中的引用次数
    public static int f(int[] citations, int x){
        int index = -1;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] == x){
                index = i;
            }
        }
        //计算出多少篇论文大于引用次数x
        return citations.length-index;


    }

    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};
        System.out.println(hIndex(citations));
    }
}
