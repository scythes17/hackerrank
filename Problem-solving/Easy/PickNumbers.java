import java.util.*;

class Result1 {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    /*public static int pickingNumbers(List<Integer> a) {
    // Write your code here
        int max = 0, i=0;
        Collections.sort(a);
        while(i<a.size()){
            int pos =0, count=1; // 1 for taking into consideration ith element
            for(int j=i+1;j<a.size(); j++){
                if(Math.abs(a.get(i)-a.get(j))<=1){
                    count++;
                    if(a.get(i)!=a.get(j) && pos==0) // first position of the changed element if diff is less than 2
                        pos=j;
                    if(a.get(i)==a.get(j)) // if there's no change, we go to the last element
                        pos=j;
                }
                if(count>=max)
                    max=count;
            }
            if(count > 1){
                i = pos;
            }
            else{
                i = i+1;
            }
        }
        return max;
    }*/
    public static int pickingNumbers(List<Integer> a) {
        int[] freq = new int[100]; // 1 -> 99 0 < a[i] < 100
        int max = 0;
        for (int i = 0; i < a.size(); i++) {
            freq[a.get(i)]++;
        }
        for (int i = 1; i < 99; i++) { // covers till i=98 and i+1 = 99
            int count = freq[i] + freq[i+1]; // check the max freq for two consecutive numbers
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

}

public class PickNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> a = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int aItem = sc.nextInt();
            a.add(aItem);
        }
        int result = Result1.pickingNumbers(a);
        System.out.println(String.valueOf(result));
        sc.close();
    }
}
