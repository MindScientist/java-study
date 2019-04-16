import java.util.*;
import java.util.stream.Collectors;

public class duplicateFinder {

    public static String makeUUID() {
        String[] symbols = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String out = "";
        for(int i = 0; i < 8; i++) {
            Random rand = new Random();
            int n = rand.nextInt(16);
            out += symbols[n];
        }
        return out;
    }

    public static String[] getCardsList() {
        String[] cards = new String[1000000];
        for (int i = 0; i < 1000000; i++) {
            cards[i] = makeUUID();
        }
        return cards;
    }

    static void findDuplicatesUsingJava8(String[] inputArray) {
        Set<String> uniqueElements = new HashSet<>();

        Set<String> duplicateElements =  Arrays.stream(inputArray)
                .filter(i -> !uniqueElements.add(i))
                .collect(Collectors.toSet());

        System.out.println(duplicateElements);
    }

    static void findDuplicatesUsingHashMap(String[] inputArray) {
        Map<String, Integer> cardUidAndCount = new HashMap<>();
        for (String liCardUid : inputArray) {
            cardUidAndCount.merge(liCardUid, 1, (a, b) -> a + b);
        }

        Set<Map.Entry<String, Integer>> entrySet = cardUidAndCount.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            if(entry.getValue() > 1) {
                System.out.println("Duplicate Element : "+entry.getKey()+" - found "+entry.getValue()+" times.");
            }
        }
    }

}
