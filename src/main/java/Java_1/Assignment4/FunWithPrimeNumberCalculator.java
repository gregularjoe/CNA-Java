package Java_1.Assignment4;
import java.util.*;

public class FunWithPrimeNumberCalculator {
    public static void main(String[] args) {

        PrimeNumberCalculator primeNumberCalculator = new PrimeNumberCalculator();

        Scanner scanner = new Scanner(System.in);

        int userChoice = 10;
        while(true){
            System.out.println("\nEnter 1 to to see the primes up to a given number.\n" +
                    "Enter 2 to get the primes in between two numbers.\n" +
                    "Enter 3 to get the prime factors for a given number.\n" +
                    "Enter 4 to get the prime factors for ever number up to a given number. \n" +
                    "Enter 0 to exit.");
            userChoice = scanner.nextInt();
            if(userChoice == 1){
                System.out.println("\n-----------------------------------------------------------------------------------------");
                System.out.print("\nGive me a number and I'll tell you the prime numbers up to and including that number:\n");
                int userNumber = scanner.nextInt();
                System.out.printf("Here are the primes up to and including %d: \n", userNumber);

                for (int i = 0; i <= userNumber ; i++) {
                    if (primeNumberCalculator.isPrime(i)) {
                        System.out.printf("%d ", i);
                    }
                }
            }
            if(userChoice == 2){
                System.out.println("\n-----------------------------------------------------------------------------------------");
                System.out.println("\nGive me two numbers and I will tell you the primes in between the two numbers.");
                System.out.println("First number: ");
                int rangeNumber1 = scanner.nextInt();
                System.out.println("Second number: ");
                int rangeNumber2 = scanner.nextInt();

                for (int i = rangeNumber1; i <= rangeNumber2 ; i++) {
                    if (primeNumberCalculator.isPrime(i)) {
                        System.out.printf("%d ",i);
                    }
                }
            }
            if(userChoice == 3){
                System.out.println("\n-----------------------------------------------------------------------------------------");
                System.out.println("Give me a number and I'll tell you its prime factors:");
                int factorizationUserNumber = scanner.nextInt();
                if (factorizationUserNumber ==1){
                    System.out.println("The number 1 is called a unit. It has no prime factors and is neither prime nor composite.");
                }
                if(factorizationUserNumber > 1){
                    System.out.printf("The prime factors for %d are...\n",factorizationUserNumber);
                    primeNumberCalculator.getUniquePrimeFactorization(factorizationUserNumber);
                    System.out.println("\n-----------------------------------------------------------------------------------------");
                }
            }
            if(userChoice == 4){
                System.out.println("Finally, give me a number and I will tell you all the prime factors up to that number. ");
                int factorizationUpTp = scanner.nextInt();
                System.out.println("|User Number: 1 ,The number 1 is called a unit. It has no prime factors and is neither prime nor composite.  ");

                for (int i = 2; i <= factorizationUpTp ; i++) {

                    System.out.printf("|User Number: %d  |Prime Factors: ",i);
                    primeNumberCalculator.getUniquePrimeFactorization(i);
                    System.out.print("\n");
                }
                System.out.println("\n-----------------------------------------------------------------------------------------");
            }
            if(userChoice == 0){
                System.out.println("Thanks for participating in this experiment...");
                break;

            }

        }
    }

}