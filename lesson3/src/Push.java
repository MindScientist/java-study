import java.util.*;

public class Push implements Cmd {
    @Override
    public void exeс(String parts[], Stack<Double> stack) {
        stack.push(Double.valueOf(parts[1]));
    }
}
