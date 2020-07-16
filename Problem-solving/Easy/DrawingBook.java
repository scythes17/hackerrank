import java.io.*;
import java.util.*;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        if(p>n/2) // if the page required is more than mid start from end
            return n/2-p/2; //Math.abs(p/2-n/2) as each turn contains 2 pages
        else if(p<=n/2) // else start from beginning
            return p/2; // 2 or 3 will be 1, 1 will be 0, 4 or 5 will be 2...
        else
            return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
