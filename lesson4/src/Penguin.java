
public class Penguin extends Bird {

    @Override
    public void fly() {
        throw new RuntimeException("Не могу летать!");
    }
}
