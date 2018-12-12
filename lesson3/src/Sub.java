
public class Sub implements Cmd {

    @Override
    public void exec(Calculator c) {
        c.stack.push(-(c.stack.pop()) + c.stack.pop());
    }
}
