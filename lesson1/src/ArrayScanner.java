import java.util.ArrayList;
import java.util.Scanner;

/**
* Scan keyboard input and put values into ArrayList
*/

public class ArrayScanner {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int q = scanner.nextInt();
            arr.add(q);
            System.out.println(arr);
        }
    }
}

