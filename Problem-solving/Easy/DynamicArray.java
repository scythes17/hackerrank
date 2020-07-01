import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
        ArrayList<ArrayList<Integer>> seq = new ArrayList<>(n);
        ArrayList<Integer> lastAnswers = new ArrayList<>();
        for(int i=0; i<n; i++){
            seq.add(new ArrayList<>());
        }
        int lastAnswer = 0;
        for(List<Integer> q: queries){
            int c = q.get(0);
            int x = q.get(1);
            int y = q.get(2);
            int index = (x^lastAnswer)%n;
            System.out.println("choice= "+c+" x= "+x+" y= "+y);
            if(c==1){
                seq.get(index).add(y);
            } else {
                int size = seq.get(index).size();
                int index2 = y%size;
                lastAnswer = seq.get(index).get(index2);
                lastAnswers.add(lastAnswer);
                System.out.println(lastAnswer);
            }
        }
        return lastAnswers;
    }

}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //Scanner sc = new Scanner(System.in);
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        //String[] firstMultipleInput = sc.nextLine().replaceAll("\\s+$", " ").split(" "); // Removes all extra spaces and splits using " "
        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);
        System.out.println(result);
        /*bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
