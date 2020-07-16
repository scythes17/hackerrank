import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        int count[] = new int[5]; // only 5 types of birds
        int max = 0, maxIndex = -1;
        for(int i:arr)
            count[i-1] = count[i-1]+1; // 1 will be in 0, 2 will be in 1 and so on.
        for(int i=0; i<5; i++){
            if(count[i]>max){
                max = count[i];
                maxIndex = i+1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //int arrCount = sc.nextInt(); // no use but the hackerrank pre-written code has it
        sc.nextLine();

        List<Integer> arr = Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        System.out.println(String.valueOf(result));
        sc.close();
    }
}
