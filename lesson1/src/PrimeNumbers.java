import java.util.ArrayList;

public class PrimeNumbers {

    static ArrayList returnPrimes(int[] numbers) {

        final ArrayList<Integer> primeNums = new ArrayList<>();
        primeNums.add(2);

        for (int number : numbers) {
            boolean isPrime = true;
            if (number == 1 || number == 2)
                continue;
            for (int k = 0; k < primeNums.size(); k++) {
                if (number % primeNums.get(k) == 0)
                    isPrime = false;
            }
            if (isPrime)
                primeNums.add(number);
        }
        System.out.println(primeNums);
        return primeNums;
    }

}
