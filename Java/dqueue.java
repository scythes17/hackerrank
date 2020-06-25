import java.util.*;
public class dqueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if(deque.size()==m){
                if(set.size()>max)
                    max=set.size();
                // remove the m-th element making the size m-1
                int removedElement = deque.removeFirst();
                if(!deque.contains(removedElement)){ //if remaining size set doesn't has the element remove it from set
                    set.remove(removedElement);
                }
            }
        }
        in.close();
        System.out.println(max);
    }
}