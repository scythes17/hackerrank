import java.util.*;
import java.util.regex.*;
public class htmltagcontentextractor {
    public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	//Write your code here
            boolean matchFound = false;
            /*
            < = character <
            . = any character, + = 1 or more times, * would be 0 or more times
            (.+) = adds whatever is there into a group () = group starting with index 1
            > = character >
            so <(.+)> = adds whatever is inside <> into group 1 (because first occurrence of +)
            
            ^< = except ^
            so [^<]+ = adds everything between <> and < into group 2

            </\\1> = matches text from group 1
            */

            // this is an improper way to check html tags as it cannot function if there's an <
            // inside the content of the tag
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);
  
            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
		    testCases--;
        }
        in.close();
	}
}