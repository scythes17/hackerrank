import java.util.*;

public class Prime {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            System.out.println(isPrime(n)?"Prime":"Not prime");
        }
        sc.close();
    }
    static Boolean isPrime(int n){
        if(n==2)
            return true;
        if(n==1 || n%2==0)
            return false;
        for(int i=3; i<=Math.sqrt(n); i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}