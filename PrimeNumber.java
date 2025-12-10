public class PrimeNumber {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Found a divisor, not prime
            } 
        }
        return true; // No divisors found, it is prime
    }

    public static void main(String[] args) {
        int num = 12; // Example number to check
        boolean result = isPrime(num);

        if (result) {
            System.out.println(num + " is a Prime Number");
        } else {
            System.out.println(num + " is Not a Prime Number");
        }
    }
    
}
