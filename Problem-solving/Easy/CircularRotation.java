import java.util.*;

public class CircularRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        int[] arr = new int[n];
        int rotations = k%n;
        for (int i = 0; i < n; i++) {
            if (i+rotations >= n)
                arr[i+rotations-n] = a[i];
            else
                arr[i+rotations] = a[i];
        }
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            results[i] = arr[queries[i]];
        }
        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));
        }
        scanner.close();
    }
}
