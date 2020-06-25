import java.util.Scanner;
import java.util.regex.*;

public class patternprog
{
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String pattern = in.nextLine();
            //Write your code
            testCases--;
            try{
                Pattern p = Pattern.compile(pattern);
                System.out.println("Valid: "+p.flags());
            } catch (Exception e){
                System.out.println("Invalid");
            }
        }
        in.close();
	}
}



