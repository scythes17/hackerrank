import java.util.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.trim();
        int l = s.length();
        int row = 0, col = 0;
        double squareRoot = Math.sqrt(l);
        int ceil = (int) Math.ceil(squareRoot);
        int floor = (int) Math.floor(squareRoot);
        boolean flag = false;
        for (int i = floor; i <= ceil; i++) {
            for (int j = floor; j <= ceil; j++) {
                if (i*j >= l) {
                    row = i;
                    col = j;
                    flag = true;
                    break;
                }
            }
            if(flag)
            break;
        }
        char[][] mat = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i*col + j < l)
                    mat[i][j] = s.charAt(i*col+j);
                else
                    break;
            }
        }
        for (int i =0; i<row; i++) {
            for (int j =0; j<col; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        String str = "";
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (i*col + j < l){
                    str = str + mat[i][j];
                }
            }
            str = str+" ";
        }
        return str;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        String result = encryption(s);
        System.out.println(result);
        scanner.close();
    }
}
