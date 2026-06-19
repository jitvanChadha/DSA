import java.util.Random;

public class FermatTestDemo {

    // 1. Modular Exponentiation: Computes (base^exp) % mod without overflowing
    // It uses the property: (A * B) % M = ((A % M) * (B % M)) % M
    static long power(long base, long exp, long mod) {
        long res = 1;
        base = base % mod;

        while (exp > 0) {
            // If exp is odd, multiply base with result
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            // exp must be even now
            exp = exp >> 1; // exp = exp / 2
            base = (base * base) % mod;
        }
        return res;
    }

    // 2. Fermat's Primality Test
    // k is the number of times we test with a random base 'a'
    static boolean isPrimeFermat(int n, int k) {
        // Base cases
        if (n <= 1 || n == 4) return false;
        if (n <= 3) return true;

        Random rand = new Random();

        // Try k times
        for (int i = 0; i < k; i++) {
            // Pick a random base 'a' in the range [2, n-2]
            int a = 2 + rand.nextInt(n - 3);

            // Fermat's Little Theorem check: a^(n-1) % n must equal 1
            if (power(a, n - 1, n) != 1) {
                return false; // 100% Guaranteed composite
            }
        }

        return true; // Probably prime (Fermat witness says so)
    }

    // 3. Our original, foolproof 100% accurate method
    static boolean isPrimeDeterministic(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int primeNum = 101;
        int carmichaelNum = 561; // Composite (3 * 11 * 17) but fools Fermat!

        System.out.println("--- TEST 1: The Prime Number (" + primeNum + ") ---");
        System.out.println("Deterministic says Prime? " + isPrimeDeterministic(primeNum));
        System.out.println("Fermat Test says Prime?      " + isPrimeFermat(primeNum, 10));

        System.out.println("\n--- TEST 2: The Carmichael Number (" + carmichaelNum + ") ---");
        System.out.println("Deterministic says Prime? " + isPrimeDeterministic(carmichaelNum));
        System.out.println("Fermat Test says Prime?      " + isPrimeFermat(carmichaelNum, 10));
    }
}