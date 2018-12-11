import java.util.Stack;

public class Print implements Cmd {

    @Override
    public void exeс(String parts[], Stack<Double> stack) {
        System.out.println(stack);
    }
}
