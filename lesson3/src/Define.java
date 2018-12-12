
public class Define implements Cmd {
    @Override
    public void exec(Calculator c) {
        c.defines.put(c.parts[1], Double.valueOf(c.parts[2]));
    }
}
