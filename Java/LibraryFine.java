import java.util.*;
class Date implements Comparable<Date>{
    // no constraints needed as question guarantees that the dates will be valid
    int date, month, year;
    Date(int d, int m, int y){
        date = d;
        month = m;
        year = y;
    }

    public int compareTo(Date that){
        if(this.year>that.year)
            return -3;
        if(this.year<that.year)
            return 0;
        if(this.month>that.month)
            return -2;
        if(this.month<that.month)
            return 0;
        if(this.date>that.date)
            return -1;
        /*if(this.date<that.date)
            return 0;*/ // reduntant cause on or before is treated the same
        return 0;
    }
}


public class LibraryFine {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int fine;
        int ar[] = new int[6];
        for(int i=0; i<6; i++){
            ar[i]= sc.nextInt(); //a[0] = date1, a[1] = month1, a[2] = year1...,a[5] = year2
        }
        Date d1 = new Date(ar[0], ar[1], ar[2]); // actual return date
        Date d2 = new Date(ar[3], ar[4], ar[5]); // expected return date
        if(d1.compareTo(d2)==0){
            fine = 0;
        } else if(d1.compareTo(d2)==-1){
            fine = 15*(d1.date-d2.date);
        } else if(d1.compareTo(d2)==-2){
            fine = 500*(d1.month-d2.month);
        } else {
            fine = 10000;
        }
        System.out.println(fine);
        sc.close();
    }
}