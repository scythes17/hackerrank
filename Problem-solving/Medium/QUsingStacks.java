import java.util.*;

public class QUsingStacks {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i=0; i<q; i++){
            int type = sc.nextInt();
            switch(type){
                case 1:
                    int ele = sc.nextInt();
                    enqueue(ele);
                break;
                case 2:
                    dequeue();
                break;
                case 3:
                    System.out.println(printQueue());
                break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }

    static void enqueue(int n){
        stack1.push(n);
    }

    static int dequeue(){
        if(!stack2.empty())
            return stack2.pop();
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        /*System.out.println("Stack2 elements: ");
        for(int i:stack2)
            System.out.print(i+" ");
        System.out.println();*/
        return stack2.pop();
    }

    static int printQueue(){
        if(!stack2.empty())
            return stack2.peek();
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        /*System.out.println("Stack2 elements: ");
        for(int i:stack2)
            System.out.print(i+" ");
        System.out.println();*/
        return stack2.peek();
    }
}