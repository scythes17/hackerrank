import java.util.ArrayList;
import java.util.Scanner;
public class dupliwordswithoutregex{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String tokens[] = s.split(" ");
        String res="";
        ArrayList<String> a = new ArrayList<String>();
        for(String token:tokens){
            int flag=0;
            for(String key:a){
                if(key.equalsIgnoreCase(token))   flag=1;
            }
            if(flag!=1)
                a.add(token);
        }
        for(String word:a){
            res=res+" "+word;
        }
        res = res.trim();
        System.out.println(res);
        sc.close();
    }
}