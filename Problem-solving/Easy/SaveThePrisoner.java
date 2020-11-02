import java.util.*;

public class SaveThePrisoner {

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        // move m - 1(as we have to hand a candy to s too) steps from s(indexed to 0 so "s-1")
        // indexing back to 1 so "+1"
        int warn = (m - 1 + s - 1) % n + 1;
        /* could go 
        int warn = (m - 1 + s)%n but then would have to handle warn == 0*/
        return warn;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
