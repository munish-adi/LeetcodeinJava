import java.util.*;

public class L1189MaximumNumberOfBalloons {
    public static int maxNumberOfBalloons1(String text) {
//        String[] splittext = text.split("[cdefghijkmpqrstuvwxyz]");
//        String strs = String.join("", splittext);
//        System.out.println(Arrays.toString(strs.toCharArray()));
        Map<String, Integer> map = new HashMap<>();
        for(char letter : text.toCharArray()){
            map.merge(letter + "", 1, Integer::sum);
        }
        System.out.println(map);

//        int noofb = map.getOrDefault("b", 0);
//        int noofa = map.getOrDefault("a", 0);
//        int noofl = map.getOrDefault("l", 0);
//        int noofo = map.getOrDefault("o", 0);
//        int noofn = map.getOrDefault("n", 0);
        int minabn = Math.min(map.getOrDefault("n", 0),(Math.min(map.getOrDefault("a", 0), map.getOrDefault("b", 0))));
        int minlo = Math.min(map.getOrDefault("o", 0), map.getOrDefault("l", 0));
        int count = 0;
//        int minlo = Math.min(noofl, noofo);
//        int minabn = Math.min(noofn, Math.min(noofb, noofa));
//        boolean flag1 = minlo >= minabn*2;
//        boolean flag2 = minabn*2 >= minlo;
        if(minabn*2 >= minlo){
            count = minlo/2;
        }
        else if(minlo >= minabn*2){
            count = minabn;
        }


        return count;
    }

    //the above is one way to do this which is frequency counting of each letter of balloon

    public static void main(String[] args) {
        String strs = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println(maxNumberOfBalloons1(strs));
    }
}
