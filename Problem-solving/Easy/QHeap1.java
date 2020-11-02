import java.util.*;

//Essentially Min Heap
public class QHeap1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Heap heap = new Heap(); // default heap index 0 = null
        for(int i=0; i<q; i++) {
            System.out.println("Heap right now is: ");
            heap.display();
            int option = sc.nextInt();
            if(option == 1){
                int ele = sc.nextInt();
                heap.insert(ele);
            } else if(option == 2) {
                int ele = sc.nextInt();
                heap.delete(ele);
            } else if(option == 3) {
                System.out.println(heap.min());
            } else {
                System.out.println("Wrong choice");
            }
        }
        sc.close();
    }

}
// Item to be deleted is guaranteed to be in the heap in the question
class Heap{
    private ArrayList<Integer> heap;
    private int n;

    Heap(){
        this.n = 0;
        heap = new ArrayList<>(1);
        heap.add(0, Integer.MIN_VALUE);
        //heap.set
    }

    public int min() {
        return heap.get(1);
    }
    
    public void display() {
        for(Integer i: heap){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public void insert(int value){
        heap.add(++n, value);
        swim(n); // value might be smaller than it's parents so sink
    }

    private boolean less(int i, int j){
        return heap.get(i)<heap.get(j);
    }

    private void swim(int k){
        while(k>1 && less(k, k/2)){ //while child is smaller than parent
            exch(k, k/2);
            k = k/2;
        }
    }

    private void exch(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int search(int value) {
        for(int i=1; i<=n; i++){
            if(heap.get(i)==value)
                return i;
        }
        return -1;
    }

    public void delete(int value){
        int index = search(value); // heap starts at 1, length of heap is n+1
        exch(index, n); // exchange value at index with last value
        heap.set(n--, Integer.MIN_VALUE); // delete the exchanged value, avoid loitering.
        sink(index); // value at index is bigger now so sink it
    }

    private void sink(int k){
        while(2*k<=n){
            int j = 2*k;
            if(j<n && less(j+1, j)) j++; //which child is smaller
            if(!less(j, k)) break;
            exch(j,k);
            k=j;
        }
    }
}