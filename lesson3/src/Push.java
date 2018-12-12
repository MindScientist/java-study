
public class Push implements Cmd {
    @Override
    public void exec(Calculator c) {
        c.stack.push(Double.valueOf(c.parts[1]));
    }
}
