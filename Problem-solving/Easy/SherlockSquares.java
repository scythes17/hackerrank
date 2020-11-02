import java.util.*;

public class SherlockSquares {

    // Complete the squares function below.
    static int squares(int a, int b) {
        // Last square will be floor of sqrt(b), first square will be ceil of sqrt(a)
        // eg: 1 to 9
        // (3 - 1) = 2 + 1 = 3 which is 1, 4, 9.
        return (int)(Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a))) + 1;
    }

    static void printSquares(int a, int b) {
        int i = (int)Math.ceil(Math.sqrt(a));
        while (i*i <= b) {
            System.out.print(i*i+" ");
            i++;
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
        int q = scanner.nextInt();
        scanner.nextLine();

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);
            printSquares(a, b);

            System.out.println(String.valueOf(result));
        }
        scanner.close();
    }
}
