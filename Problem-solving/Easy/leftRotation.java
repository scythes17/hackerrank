import java.util.*;

public class leftRotation {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            if(i-d>=0)
                a[i-d]=aItem;
            else{
                int j = n+(i-d);
                a[j]=aItem;
            }

        }
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
        scanner.close();
    }
}