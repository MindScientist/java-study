import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DuplicateFileFinder dff = new DuplicateFileFinder();
        dff.setInitDir("c:\\Users\\kpbs\\Studying\\Java\\");
        dff.find();
    }
}
