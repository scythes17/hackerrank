import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
class Result {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER d
     */

    public static int minimumMoves(String s, int d) {
    // Write your code here
        //Naive approach to check the resultant string
        /*int count = 0;
        for(int i=0; i<=s.length()-d; i++){
            int c =0;
            for(int j=i; j<i+d; j++){
                if(s.charAt(j)=='1'){
                    c=1;
                    break;
                }
            }
            if(c==0){
                s = s.substring(0, i+d-1)+"1"+s.substring(i+d, s.length());
                count++;
                System.out.println(s);
            }
        }
        return count;*/
        ArrayList<Integer> a = new ArrayList<>(); // to store indices of '1's
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1')
                a.add(i);
        }
        int f = d-1; // first index before or on which there should be a '1'
        int i=0, count=0;
        while(f<s.length()){
            if(i<a.size() && a.get(i)<=f){ // if there's a '1 present before f
                f=a.get(i)+d; // switch f to that index
                i++; // go to the next '1'
            } else {
                f=f+d; // else increase f(as you changed f-th 0 to '1' virtually) to second expected index having '1' before or on it
                count++; // increase count cause you changed f-th index '0' to '1'
            }
        }
        return count;
    }

}

public class binaryString {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Scanner sc = new Scanner(System.in);
        //String s = bufferedReader.readLine();
        String s = sc.nextLine();
        //int d = Integer.parseInt(bufferedReader.readLine().trim());
        int d = Integer.parseInt(sc.nextLine().trim());
        int result = Result.minimumMoves(s, d);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        System.out.println(String.valueOf(result));
        sc.close();
        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
