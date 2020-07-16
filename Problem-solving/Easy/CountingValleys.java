import java.io.*;
import java.util.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int count = 0;
        int pos = 0; // seaLevel is 0
        int flag = 0; // will be 1 if he is in valley, resets to 0 as he reaches sealevel
        for(int i=0; i<n; i++) {
            if(s.charAt(i)=='D')
                pos--;
            if(s.charAt(i)=='U')
                pos++;
            if(pos<0 && flag==0) {
                count++;
                flag=1; // is in a valley
            }
            if(pos>=0 && flag==1) {
                flag = 0; // reached seaLevel
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
