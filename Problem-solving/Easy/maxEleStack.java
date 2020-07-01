import java.util.*;

public class maxEleStack {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> max = new Stack<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int option = sc.nextInt();
            if(option == 1) {
                int x = sc.nextInt();
                stack.push(x);
                if(max.empty() || x>max.peek())
                    max.push(x);
                else 
                    max.push(max.peek());
            } else if(option == 2) {
                stack.pop();
                max.pop();
            } else if(option == 3) {
                System.out.println(max.peek());
            } else {
                System.out.println("Wrong option");
            }
        }
        sc.close();
    }
}