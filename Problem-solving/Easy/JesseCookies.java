import java.io.*;
import java.util.*;

public class JesseCookies {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        /*
         * Write your code here.
         */
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(A.length);
        for(int i:A){
            pq.add(i);
        }
        while(pq.size()>1 && pq.peek()<k) { // >1 cause you need two cookies to merge them
            pq.add(pq.poll()+(2*pq.poll()));
            count++;
        }
        if(pq.peek()>=k)
            return count;
        else
            return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);
        System.out.println(String.valueOf(result));
    }
}
