import java.util.Scanner;
import java.util.Stack;
public class stack {
    public static void main (String[] args) throws java.lang.Exception{
    Scanner sc = new Scanner(System.in);
		
    while (sc.hasNext()) {
        String input=sc.next();
        //Complete the code
        char arr[] = input.toCharArray();
        System.out.println( check(arr)? "true" : "false" );
    }
    
    sc.close();
}

public static boolean check(char[] arr){
    Stack<Character> stack = new Stack<Character>();
    for(int i=0; i<arr.length; i++){

        if( arr[i] == '(' || arr[i] == '{' || arr[i] == '[')
            stack.push(arr[i]);
        else if ( (arr[i] == ')' || arr[i] == '}' || arr[i] == ']') && stack.empty() )
            return false;
        else if( (arr[i] == ')' && stack.peek() == '(') || (arr[i] == '}' && stack.peek() == '{') || (arr[i] == ']' && stack.peek() == '['))
            stack.pop();
        else
            return false;

    }

    if(stack.empty())
        return true;

    return false;

	}
}