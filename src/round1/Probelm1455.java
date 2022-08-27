package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/8/21 18:12
 */

public class Probelm1455 {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        int res = -1;
        String[] strings = sentence.split(" ");
        int count = 0;
        for (String string : strings) {
            count++;
            if(string.startsWith(searchWord)){
                res = count;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String sentence = "i love eating burger";
        String search = "aburg";
        System.out.println(isPrefixOfWord(sentence, search));
    }
}
