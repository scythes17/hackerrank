import java.util.*;
public class FindDigits1 {
    
    // Complete the findDigits function below.
    static int findDigits(int n) {
        int m = n;
        int count = 0;
        while (m > 0) {
            int d = m % 10;
            m = m / 10;
            if (d == 0)
                continue;
            if (n % d == 0)
                count++;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            //int n = scanner.nextInt();
            int n = Integer.MAX_VALUE;
            long startTime = System.nanoTime();
            int result = findDigits(n);
            System.out.println(result);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        scanner.close();
    }
}