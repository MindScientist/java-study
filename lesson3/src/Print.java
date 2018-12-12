
public class Print implements Cmd {

    @Override
    public void exec(Calculator c) {
        System.out.println(c.stack);
        System.out.println(c.defines);
    }
}
