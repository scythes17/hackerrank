import java.io.*;
import java.util.*;

public class ArrayManipulation1 {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long ar[] = new long[n+1]; // the first element is 0 and doesn't matter as we have to return max
        ar[0] = Integer.MIN_VALUE;
        for(int i=0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            for(int j=a; j<=b; j++){
                ar[j] = ar[j]+k;
            }
        }
        long max=Integer.MIN_VALUE;
        for(long i:ar){
            if(i>max)
                max=i;
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
