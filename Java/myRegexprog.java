//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import java.util.Scanner;

class myRegexprog{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
        in.close();
    }
}

//Write your code here

class MyRegex{
    /*
    d{1,2} = either 1 digit or 2 digits
    so d{1,2} = anything between 0-99 and 00-09 (these two are different as preceding 0s also need to be mentioned)
    
    | = OR
    (0|1) = 0 or 1
    d{2} = 2 digits
    so d{1,2}|(0|1)\\d{2} = anything between 000-199

    2 = the digit 2
    (0|1|2|3|4) = either digit 1 or 2 or 3 or 4
    d = one digit
    so 2[0-4]\\d = anything between 200-249

    25 = the digits 2 and 5
    (0|1|2|3|4|5) = either digit 1 or 2 or 3 or 4 or 5
    so 2[0-4]\\d = anything between 250 - 255
    
    [0-5] == (0|1|2|3|4|5)
    */
    //String zero_255 = "(\\d{1,2}|(0|1)\\d{2}|2(0|1|2|3|4)\\d|25(0|1|2|3|4|5))";
    String zero_255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|2[0-4]\\d)";
    String pattern = zero_255+"\\."+zero_255+"\\."+zero_255+"\\."+zero_255;
}