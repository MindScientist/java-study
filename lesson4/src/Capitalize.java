class Capitalize {

    static void capitalize1(String... args) {
        String str = "а и в лЕсУ роДиЛась ёлоЧКА!";
        StringBuilder strOutBuilder = new StringBuilder();
        String[] parts = str.toLowerCase().split(" ");
        for (String word : parts) {
            String newWord = word.substring(0, 1).toUpperCase();
            if (word.length() > 1)
                newWord += word.substring(1);
            strOutBuilder.append(newWord).append(" ");
        }
        //String strOut = strOutBuilder.toString();
        String strOut = strOutBuilder.substring(0, strOutBuilder.length() - 1);
        System.out.println(strOut);
    }

    static void capitalize2(String... args) {
        String str = "а и в лЕсУ роДиЛась ёлоЧКА!".toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String c = str.substring(i, i + 1);
            if (i == 0 || str.charAt(i - 1) == ' ') {
                c = c.toUpperCase();
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}
