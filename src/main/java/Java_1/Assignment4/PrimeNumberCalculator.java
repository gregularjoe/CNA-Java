package Java_1.Assignment4;


public class PrimeNumberCalculator {

    public boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i < number; i++) {
            int remainder = number % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }

    public void getUniquePrimeFactorization(int number) {

        while (number % 2 == 0) {
            System.out.print(2 + " ");
            number = number / 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                System.out.print(i + " ");
                number = number / i;
            }
        }
        if (number > 2) {
            System.out.print(number + " ");
        }
    }
}