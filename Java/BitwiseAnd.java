import java.util.*;

public class BitwiseAnd {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            HashSet<Integer> set = new HashSet<>();
            // As 0&1 = 0 we can start from 0
            for(int i=0; i<=n; i++){
                for(int j=i+1; j<=n; j++){
                    int res = i&j;
                    //System.out.println("res= "+res+" i= "+i+" j= "+j);
                    if(res<k){
                        set.add(res);
                    }
                }
            }
            Integer arr[] = new Integer[set.size()];
            arr = set.toArray(arr);
            Arrays.sort(arr);
            System.out.println(/*"max in set= "+*/arr[arr.length-1]);
        }
        //System.out.println("bitwise of 0 and 1: "+(0&1));
        scanner.close();
    }
}
