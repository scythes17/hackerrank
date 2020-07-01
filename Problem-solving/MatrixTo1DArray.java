import java.util.Scanner;
public class MatrixTo1DArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ar[][] = new int[m][n];
        int arr[] = new int[m*n];
        int c = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ar[i][j] = sc.nextInt();
                arr[c++] = ar[i][j];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int pos = (i*m)+j;
                System.out.println("pos= "+pos);
                System.out.println(ar[i][j]+" = "+arr[pos]);
            }
        }
        
        /* An m*n matrix ar can be converted to an array arr of size m*n where
         index pos of arr = i*m(row-size)+j where i and j are row and column indices of ar */

        /* Similarly, if pos is given it can be converted to i and j using 
         i = pos/m (returns divisor which is row(multiple of m)) 
         and j = pos%m (returns remainder which is column) */
        sc.close();
    }
}