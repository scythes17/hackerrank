import java.io.*;
import java.util.*;

public class ClimbingLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int rank = 0;
        int aliceRanks[] = new int[alice.length];
        for(int score:scores){
            if(!tm.containsKey(score)){
                tm.put(score, ++rank);
            }
        }
        for(int i=0; i<alice.length; i++){
            Map.Entry<Integer, Integer> aliceRank = tm.floorEntry(alice[i]);
            if(aliceRank == null) // if there are no scores less than alice's, alice will be last
                aliceRanks[i] = tm.size()+1;
            else  // rank will be equal to the rank of the greatest score it exceeds or is equal to
                aliceRanks[i] = aliceRank.getValue();
        }
        return aliceRanks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i])+" ");

            /*if (i != result.length - 1) {
                System.out.print("\n");
            }*/
        }
        System.out.println();
        scanner.close();
    }
}
