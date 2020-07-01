public class BinarySearch {
    static int heap[]={1,2,3,4,5,6,7,8,9,10};
    public static void main(String args[]){
        System.out.println(search(1, 0, heap.length-1));
    }

    private static int search(int value, int lo, int hi) {
        //int lo = 0;
        //int hi = heap.length-1;
        int mid = (lo+hi)/2;
        if(value == heap[mid])
            return mid;
        else if(value < heap[mid])
            return search(value, lo, mid-1);
        else if(value > heap[mid])
            return search(value, mid+1, hi);
        else 
            return -1;
    }
}