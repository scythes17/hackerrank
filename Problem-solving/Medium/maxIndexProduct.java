import java.io.*;
import java.util.*;

public class maxIndexProduct {
    // Complete the solve function below.
    static long solve(int[] arr) {
        long max =0;
        for(int i=0; i<arr.length; i++){
            long leftIndex=0,rightIndex=0;
            long prod=0;
            for(int j=i-1; j>=0; j--){
                if(arr[j]>arr[i]){
                    leftIndex = j+1; // cause index is starting from 1 in calculations
                    break;
                }
            }
            if(leftIndex==0) // product will be 0
                continue;
            for(int k=i+1; k<arr.length; k++){
                if(arr[k]>arr[i]){
                    rightIndex = k+1; // cause index is starting from 1
                    break;
                }
            }
            if(rightIndex==0) // product will be 0
                continue;
            prod = (long)leftIndex*rightIndex;
            if(prod>max){
                max = prod;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[arrCount];
        String[] arrItems = scanner.nextLine().split(" ");
        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
