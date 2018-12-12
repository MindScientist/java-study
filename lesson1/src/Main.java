/**
 * @author Alex Zharinov
 */

public class Main {

    public static void main(String args[]) {

        /* Solve biquadratic equation
        a*x^4 + b*x^2 + с = 0
        */

        double[] arrRoots = solveQuadEquation.getRoots(1, -2, 0);

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
            System.out.println("No roots.");

        /* Sort array
        5,2,3,1,4
        */

        int arr[] = new int[20000];
        ArraySort.sort(arr);

        /* Sort array with use of TreeMap */

        int array[] = new int[100];
        ArraySort.sortTreeMap(array);

        /* Search prime numbers */

        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        PrimeNumbers.returnPrimes(nums);

    }

    public static class solveQuadEquation {

        static double[] getRoots(double a, double b, double c) {

            double d = b * b - 4 * c * a;
            double[] res = new double[2];

            if (d > 0) {
                res[0] = (-b + Math.sqrt(d)) / 2 / a;
                res[1] = (-b - Math.sqrt(d)) / 2 / a;
            } else if (d == 0) {
                res[0] = -b / 2 / a;
            }

            return res;
        }

    }
}
