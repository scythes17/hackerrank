import java.io.*;
import java.util.*;

public class SparseArray {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        /*int arr[] = new int[queries.length];
        int i = 0;
        for(String q: queries){
            int count = 0;
            for(String s: strings){
                if(q.equalsIgnoreCase(s)){
                    count++;
                }
            }
            arr[i++] = count;
        }
        return arr;*/
        
        int arr[] = new int[queries.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: strings) {
            if(map.containsKey(s)) {
                int count = map.get(s);
                map.replace(s, ++count);
            } else {
                map.put(s, 1);
            }
        }
        int i = 0;
        for(String q: queries) {
            if(map.containsKey(q))
                arr[i++] = map.get(q);
            else
                arr[i++] = 0;
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.nextLine();
        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.print(String.valueOf(res[i]));

            if (i != res.length - 1) {
                System.out.println();
            }
        }
        scanner.close();
    }
}
