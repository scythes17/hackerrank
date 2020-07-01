import java.util.*;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        if(h1.length<1 || h2.length<1 || h3.length<1)
        return 0;
        int i=h1.length-1, j=h2.length-1, k=h3.length-1;
        int s1=0, s2=0, s3=0;
        int max2=0, max=0, flag=1;
        while(flag == 1){
            if(s1==s2 && s2==s3){
                max = s1;
                if(i>=0 && j>=0 && k>=0) {
                    s1= s1+h1[i--];
                    s2= s2+h2[j--];
                    s3= s3+h3[k--];
                } else {
                    flag = 0;
                    break;
                }
            }
            else{
                max2 = Math.max(s1, Math.max(s2,s3));
                if(s1<max2){
                    if(i>=0){
                        s1 = s1+h1[i--];
                    } else {
                        flag = 0;
                        break;
                    }
                }
                if(s2<max2){
                    if(j>=0){
                        s2 = s2+h2[j--];
                    } else {
                        flag = 0;
                        break;
                    }
                }
                if(s3<max2){
                    if(k>=0){
                        s3 = s3+h3[k--];
                    } else {
                        flag = 0; 
                        break;
                    }
                }
            }
        }
    return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(String.valueOf(result));
    }
}
