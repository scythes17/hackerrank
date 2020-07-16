import java.io.*;
import java.util.*;

public class magicSquare {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int a[][][] = {{{ 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 }}, 
        {{ 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 }}, 
        {{ 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 }}, 
        {{ 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 }}, 
        {{ 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 }}, 
        {{ 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 }}, 
        {{ 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 }}, 
        {{ 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 }}};
        return findMinimumChanges(a, s);

    }
    static int findMinimumChanges(int a[][][], int m[][]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<8; i++){
            int count = findChanges(a[i], m);
            if(count<min)
                min=count;
        }
        return min;
    }

    static int findChanges(int a[][], int m[][]){
        int count =0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(a[i][j]!=m[i][j])
                    count+=Math.abs(a[i][j]-m[i][j]);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(String.valueOf(result));
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
