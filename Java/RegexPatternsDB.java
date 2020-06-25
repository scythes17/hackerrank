//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
import java.util.*;
//import java.util.concurrent.*;
import java.util.regex.*;

public class RegexPatternsDB {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ArrayList<String> al = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            if(validate(emailID)){
                al.add(firstName);
            }
        }
        Collections.sort(al);
        for(String s:al){
            System.out.println(s);
        }
        scanner.close();
    }
    static Boolean validate(String emailID){
        Pattern p = Pattern.compile("^.+@gmail.com$"); // . = any character + = 1 or more times
        Matcher m = p.matcher(emailID);
        boolean b = m.matches();
        return b;
    }
}
