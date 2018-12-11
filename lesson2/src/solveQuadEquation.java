public class solveQuadEquation {

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
