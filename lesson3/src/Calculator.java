import java.util.*;

/**
 1)
 div - деление,
 sub - вычитание,
 mul - умножение
 define a 5 - определение константы
 push a

 2) ООП

 */

public class Calculator {
    public static void main(String... args) {
        Stack<Double> stack = new Stack<Double>();

        Scanner s = new Scanner(System.in);

        HashMap<String, Cmd> cmds = new HashMap<>();

        cmds.put("PUSH", new Push());
        cmds.put("PRINT", new Print());
        cmds.put("ADD", new Add());

        while (true) {
            String line = s.nextLine();
            // PUSH 1
            String[] parts = line.split(" ");
            String cmdName = parts[0].toUpperCase();

            cmds.get(cmdName).exeс(parts, stack);

        }
    }
}
