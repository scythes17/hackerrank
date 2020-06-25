import java.util.*;

public class bitSet {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            String s = sc.next();
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            switch(s){
                case "AND":
                    if(i1 == 1 && i2 == 2)
                        b1.and(b2);
                    else if(i1 == 2 && i2 == 1)
                        b2.and(b1);
                    else
                        System.out.println("Invalid set selection"+i1+" "+i2);
                break;
                case "OR":
                    if(i1 == 1 && i2 == 2)
                        b1.or(b2);
                    else if(i1 == 2 && i2 == 1)
                        b2.or(b1);
                    else
                        System.out.println("Invalid set selection"+i1+" "+i2);
                break;
                case "XOR":
                    if(i1 == 1 && i2 == 2)
                        b1.xor(b2);
                    else if(i1 == 2 && i2 == 1)
                        b2.xor(b1);
                    else
                        System.out.println("Invalid set selection"+i1+" "+i2);
                break;
                case "FLIP":
                    if(i1 == 1)
                        b1.flip(i2);
                    else if(i1 == 2)
                        b2.flip(i2);
                    else
                        System.out.println("Invalid set selection"+i1+" "+i2);
                break;
                case "SET":
                    if(i1 == 1)
                        b1.set(i2);
                    else if(i1 == 2)
                        b2.set(i2);
                    else
                        System.out.println("Invalid set selection"+i1+" "+i2);
                break;
                default:
                    System.out.println("Invalid operation selected");
            }
            System.out.println(b1.cardinality()+" "+b2.cardinality());
        }
        sc.close();
    }
}
