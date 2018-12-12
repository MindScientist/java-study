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
    Stack<Double> stack = new Stack<>();
    private Map<String, Cmd> cmds = new HashMap<>();
    Map<String, Double> defines = new HashMap<>();
    String[] parts;

    private Calculator() {
        this.cmds.put("PUSH", new Push());
        this.cmds.put("PRINT", new Print());
        this.cmds.put("ADD", new Add());
        this.cmds.put("SUB", new Sub());
        this.cmds.put("MUL", new Mul());
        this.cmds.put("DIV", new Div());
        this.cmds.put("DEFINE", new Define());
    }

    public static void main(String... args) {

        Calculator calc = new Calculator();

        Scanner s = new Scanner(System.in);

        while (true) {
            String line = s.nextLine();
            // PUSH 1
            String[] parts = line.split(" ");
            String cmdName = parts[0].toUpperCase();
            calc.parts = parts;

            calc.cmds.get(cmdName).exec(calc);
        }
    }
}
