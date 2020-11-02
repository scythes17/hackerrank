import java.io.*;
import java.util.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    // Check hackerrank editorial for better understanding
    static long arrayManipulation(int n, int[][] queries) {
        // the entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
        long arr[] = new long[n];
        int a; // lower
        int b; // upper
        long k; // addition element
        for(int i=0; i<queries.length; i++){
            a = queries[i][0];
            b = queries[i][1];
            k = queries[i][2];
            arr[a-1]=arr[a-1]+k; // add to the first element of the range
            if(b<n)
                arr[b]=arr[b]-k; // decrease value of the end+1 element of the range
                // the entry arr[end+1] will be less than arr[end] by k units
        }
        long max=Integer.MIN_VALUE;
        long sum=0;

        for(int i=0;i<n;i++){
            sum = sum+arr[i];
            if(sum> max)
                max=sum;
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}