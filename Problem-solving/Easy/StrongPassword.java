import java.util.*;
import java.util.regex.*;

public class StrongPassword {

    // Complete the minimumNumber function below.
    /*static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int dFlag=0, loFlag=0, upFlag=0, spFlag=0;
        char[] sChars = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'};
        int change = 0;
        for(int i=0; i<n; i++){
            if(Character.isUpperCase(password.charAt(i)))
                upFlag = 1;
            else if(Character.isLowerCase(password.charAt(i)))
                loFlag = 1;
            else if(Character.isDigit(password.charAt(i)))
                dFlag = 1;
            else{ // check sChars only if it is none of the above types
                if(spFlag==0){ // check only if it the condition is not already satisfied
                    for(char c: sChars){
                        if(c==password.charAt(i))
                            spFlag=1;
                    }
                }
            }
        }
        // increase change by 1
        if(upFlag == 0) // if there are no upperCase characters
            change++;
        if(loFlag == 0) // no lowerCase characters
            change++;
        if(dFlag == 0) // no digits
            change++;
        if(spFlag == 0) // no specialCharacters
            change++;
        
        if((change+n)<6) // if End Length is less than 6 
            return 6-n; // we need to increase to make it at least 6
        
        return change;
    }*/

    static int minimumNumber(int n, String password) {
		int count = 0;
		
		Pattern patternDigit = Pattern.compile("(\\d)");
		Pattern patternUpper = Pattern.compile("([A-Z])");
		Pattern patternLower = Pattern.compile("([a-z])");
		//Pattern patternSpecial = Pattern.compile("([!@#$%^&*()-+])");
        Pattern patternSpecial = Pattern.compile("([!@#$%^&*()+]|-)"); // cause it was taking "-" as "to"

		Matcher matcherDigit = patternDigit.matcher(password);
		Matcher matcherUpper = patternUpper.matcher(password);
		Matcher matcherLower = patternLower.matcher(password);
		Matcher matcherSpecial = patternSpecial.matcher(password);
		
		if (!matcherDigit.find())
			count++;
		if (!matcherUpper.find())
			count++;
		if (!matcherLower.find())
			count++;
		if (!matcherSpecial.find())
            count++;
            
		if ((count+n)<6)
			count = 6-n;
		return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(String.valueOf(answer));


        scanner.close();
    }
}
