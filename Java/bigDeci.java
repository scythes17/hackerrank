import java.math.BigDecimal;
import java.util.*;
class bigDeci{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();
  
        //Write your code here

        // To override a method without creating an alternate class
        Arrays.sort(s,0,n,Collections.reverseOrder(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                BigDecimal bd1 = new BigDecimal(a);
                BigDecimal bd2 = new BigDecimal(b);
                return bd1.compareTo(bd2);
            }
        }));
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}