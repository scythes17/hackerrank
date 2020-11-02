import java.util.*;
public class FindDigits {
    static int findDigits(int n) 
    {
        int tn=n,c=0,d;
        HashSet<Integer> h=new HashSet<>();
        while(n!=0)
         {
             d=n%10;
             if(h.contains(d))
                c++;
             else 
             {
               if(d!=0 && tn%d==0)
                {
                    c++;
                    h.add(d);
                }
             }
             n/=10;   
         }
        return c; 
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            //int n = scanner.nextInt();
            int n = Integer.MAX_VALUE;
            long startTime = System.nanoTime();
            int result = findDigits(n);
            System.out.println(result);
            long stopTime = System.nanoTime();
            System.out.println(stopTime - startTime);
        }

        scanner.close();
    }
}