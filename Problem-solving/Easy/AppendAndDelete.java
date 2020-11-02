import java.util.*;
/* If I have to add/delete 1 letter, I can perform 1,3,5.. operations likewise for even
2 add/delete I can perform 2,4,6... operations. So the parity has to be same. eg : IF I have to add
1 letter and I can perform 2 operations. I can add once, but then I'll have to use the second op
using delete and now I need another op to reach my result which we could if we could perform 3 ops*/

/* if parity is same total appends + del <= k else we have to delete the entire string then reconstruct
so size(s) + size(t) <= k */

public class AppendAndDelete {

    // Complete the appendAndDelete function below.
    /*static String appendAndDelete(String s, String t, int k) {
        // we have to check if 2* length - first divergence in the strings is <= k
        // as we have to perform that many deletes and appends
        int pos = 0, total = 0;
        for(int i = 0; i < s.length(); i++) {
            if (i >= t.length()) {
                break;
            }
            if(s.charAt(i) != t.charAt(i)) {
                pos = s.length()-i; // first difference in the two strings, no of deletes to perform
                break;
            }
        }
        if (pos == 0 || t.length() > s.length()) { // i.e. pos = 0 means total = diff in length of strings
            total = 2*pos + Math.abs(s.length() - t.length());
        } else {
            total = 2*pos - Math.abs(s.length() - t.length());
        }
        System.out.println("pos= "+pos+" total= "+total);
        if (total > k)
            return "No";
        else if (total%2 == k%2)
            return "Yes";
        else if (s.length() + t.length() <= k)
            return "Yes";
        else
            return "No";
    }*/

    /*static String appendAndDelete(String s, String t, int k) {
        int deletes = 0, pos = 0, total = 0;
        for(int i = 0; i < s.length(); i++) {
            if (i >= t.length()) {
                break;
            }
            if(s.charAt(i) != t.charAt(i)) {
                deletes = s.length() - i;
                pos = i;
                break;
            }
        }
        if (deletes == 0) // if there's no divergence
            total = Math.abs(s.length() - t.length()); // have to append/delete till reaching t's size
        else
            total = deletes + t.length()-pos; // have to append till reaching t's size
        //System.out.println("del = "+deletes+" total = "+total+" appends = "+(t.length()-pos)+"pos = "+pos);

        if (total > k) // if needed ops exceed provided ops
            return "No";
        else if (total%2 == k%2) // cause you need to be able to delete+append the same times as needed
            return "Yes";
        else if (s.length() + t.length() <= k) // if you can delete the entirety of the string and reconstruct
            return "Yes";
        else
            return "No";
    }*/

    static String appendAndDelete(String s, String t, int k) {
        int i = 0; // commonTill index
        int min;
        int sLen = s.length(), tLen = t.length();
        while (i < Math.min(sLen, tLen)) { // find common index
            if (s.charAt(i) != t.charAt(i))
                break;
            i++;
        }
        if (k % 2 == (sLen + tLen) % 2) // if parity is same (needs to be same as we need to perform exactly k ops)
            min = sLen + tLen - 2 * i; // minimum ops to perform is size of (s + t) - 2 * commonsize
        else
            min = sLen + tLen + 1; // else totally empty the string and then reconstruct
        System.out.println("min= "+min+" i= "+i);
        if (k < min)
            return "No";
        else
            return "Yes";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int k = scanner.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);

        scanner.close();
    }
}
