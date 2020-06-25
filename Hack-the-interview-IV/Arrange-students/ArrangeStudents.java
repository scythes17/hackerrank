import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'arrangeStudents' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
    // Write your code here
        Collections.sort(a);
        Collections.sort(b);
        int flag = 0;
        if(a.get(0) < b.get(0)) {
            flag = (can(a,b)?1:0);
        } else if(a.get(0) > b.get(0)) {
            flag = (can(b,a)?1:0);
        } else { //if starting elements are equal
            if(can(a,b))
                flag = 1;
            else 
                flag = (can(b,a)?1:0);
        }
        if(flag == 1)
            return "YES";
        return "NO";
    }

    public static Boolean can(List<Integer> a, List<Integer> b){
        int l = -1;
        for(int i=0; i<a.size(); i++){
            if(a.get(i)>=l && a.get(i)<=b.get(i))
                l=b.get(i);
            else
                return false;
        }
        return true;
    }

}

public class ArrangeStudents {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.arrangeStudents(a, b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();*/
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<>(n);
            List<Integer> b = new ArrayList<>(n);
            for(int j=0; j<n; j++){
                int ele = sc.nextInt();
                a.add(ele);
            }
            for(int j=0; j<n; j++){
                int ele = sc.nextInt();
                b.add(ele);
            }
            String result = Result.arrangeStudents(a, b);
            System.out.println(result);
        }
        sc.close();
    }
}
