import java.util.*;

public class Add implements Cmd {
    @Override
    public void exeс(String[] parts, Stack<Double> stack) {
        stack.push(stack.pop() + stack.pop());
    }
}
