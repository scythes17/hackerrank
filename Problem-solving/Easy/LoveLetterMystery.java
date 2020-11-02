import java.util.*;

public class LoveLetterMystery {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int l = s.length();
        int count = 0;
        for(int i = 0; i < l/2; i++) {
            int ascii1 = (int) s.charAt(i);
            int ascii2 = (int) s.charAt(l-1-i);
            if(ascii1 != ascii2) {
                count = count + Math.abs(ascii1 - ascii2);
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.nextLine();

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
