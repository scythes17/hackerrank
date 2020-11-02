import java.util.*;

public class CutTheSticks {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        int removed = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        while (true) {
            //System.out.println(arr.length - removed);
            al.add(arr.length - removed);
            int min = arr[removed];
            for (int i = removed; i < arr.length; i++) {
                arr[i] = arr[i] - min;
                if (arr[i] == 0)
                    removed++; // number of sticks removed
            }
            if (removed == arr.length)
                break;
        }
        int[] result = new int[al.size()];
        int c = 0;
        for (int i: al) {
            result[c++] = i;
        }
        return result;
    }

    /*static void cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        System.out.println(arr.length); // print the entire array first
        for (int i = 1; i < arr.length; i++) { // everytime we remove the sticks with the min length
            if (arr[i] != arr[i-1]) // so whenever they are not equal, we're not removing anymore of them
                System.out.println(arr.length - i); // and thus get the remaining number of sticks
        }
    }*/

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.nextLine();

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }
        scanner.close();
    }
}
