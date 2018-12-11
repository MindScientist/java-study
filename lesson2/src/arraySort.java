import java.util.Arrays;
import java.util.TreeMap;

public class arraySort {

    /* Array sort */

    static int[] initArray(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            arr[k] = (int) (Math.random() * 100);
        }
        return arr;
    }

    public static void sort(int[] arr) {

        arr = initArray(arr);

        int numOfGoodComparisons = 0;
        int j = 0;

        long t0 = System.currentTimeMillis();
        while (true) {
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j] - arr[j + 1];
                arr[j + 1] = arr[j + 1] + arr[j];
                arr[j] = arr[j + 1] - arr[j];
            } else {
                numOfGoodComparisons++;
            }
            if (numOfGoodComparisons == arr.length - 1)
                break;
            j++;
            if (j == arr.length - 1) {
                j = 0;
                numOfGoodComparisons = 0;
            }
        }
        long t1 = System.currentTimeMillis();

        System.out.println((t1 - t0) + " ms");

        arr = initArray(arr);

        t0 = System.currentTimeMillis();
        Arrays.sort(arr);
        t1 = System.currentTimeMillis();

        System.out.println((t1 - t0) + " ms");
    }

    public static void sortTreeMap(int[] arr) {
        arr = initArray(arr);
        TreeMap<Integer, Integer> arrTree = new TreeMap<>();

        for (int elem : arr) {
            if (arrTree.keySet().contains(elem)) {
                arrTree.put(elem, arrTree.get(elem) + 1);
            } else {
                arrTree.put(elem, 1);
            }
        }

        for (int elem : arrTree.keySet()) {
            for (int k = 0; k < arrTree.get(elem); k++) {
                System.out.println(elem);
            }
        }
    }

}
