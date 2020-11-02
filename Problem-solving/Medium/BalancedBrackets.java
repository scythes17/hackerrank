import java.util.*;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if (!stack.empty()) {
                if (s.charAt(i) == '}' && stack.pop() == '{')
                    continue;
                else if (s.charAt(i) == ')' && stack.pop() == '(')
                    continue;
                else if (s.charAt(i) == ']' && stack.pop() == '[')
                    continue;
                else
                    return "NO";
            } else
                return "NO";
        }
        if(stack.empty())
            return "YES";
        else
            return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
