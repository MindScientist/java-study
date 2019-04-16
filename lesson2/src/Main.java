/**
 * @author Alex Zharinov
 */

public class Main {

    public static void main(String args[]) {

        /* Solve biquadratic equation
        a*x^4 + b*x^2 + с = 0
        */

        /*double[] arrRoots = solveQuadEquation.getRoots(1, -2, 0);

        boolean isRoots = false;

        for (double arrRoot : arrRoots) {
            if (arrRoot < 0) {
                continue;
            } else if (arrRoot == 0) {
                isRoots = true;
                System.out.println("x = 0");
                continue;
            }

            System.out.println("x = " + Math.sqrt(arrRoot));
            System.out.println("x = " + (-Math.sqrt(arrRoot)));
            isRoots = true;
        }

        if (!isRoots)
            System.out.println("No roots.");*/

        /* Sort array
        5,2,3,1,4
        */

        /*int arr[] = new int[20000];
        arraySort.sort(arr);*/

        String[] initArray = duplicateFinder.getCardsList();
        long t0 = System.currentTimeMillis();
        duplicateFinder.findDuplicatesUsingJava8(initArray);
        System.out.println(System.currentTimeMillis() - t0);
        System.out.println("------------------------");

        long t1 = System.currentTimeMillis();
        duplicateFinder.findDuplicatesUsingHashMap(initArray);
        System.out.println(System.currentTimeMillis() - t1);

        /* Sort array with use of TreeMap */

        /*int arr[] = new int[100];
        arraySort.sortTreeMap(arr);*/

        /* Search prime numbers */

        /*int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        primeNumbers.returnPrimes(nums);*/



    }
}
