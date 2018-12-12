import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {

        String s = "Сто лет Ленин грибом летал по домам...".toLowerCase();

        Map<Character, Integer> cnt = new TreeMap<>();

        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!cnt.containsKey(c)) {
                cnt.put(c, 1);
            } else {
                int oldCnt = cnt.get(c);
                cnt.put(c, oldCnt + 1);
            }
        }

        /* Sorting symbols */
        System.out.println(cnt);
        for (Character c : cnt.keySet()) {
            for (int n = 0; n < cnt.get(c); n++) {
                System.out.println(c);
            }
        }

    }


}
