
public class Div implements Cmd {
    @Override
    public void exec(Calculator c) {
        c.stack.push(1/c.stack.pop() * c.stack.pop());
    }
}
