// Will give TLE because it's checking all substrings
class Result1
{
    public static int minimumMoves(String s, int d)
    {
        if(d==0)
            return 0;
        int i,f,c=0,fc=0; String t="";
        for(i=0;i<=s.length()-d;i++)
        {
            t=s.substring(i,i+d);
            f=check(t); // check if substring has '1'
            if(f==0){ // if it doesn't 
                c++; // increase count of consecutive substrings of length d having no '1'
            }

            if((f!=0 || (i==(s.length()-d)))){ // if there's a '1' or string is ending
                if(c!=0){ // if substring(s) don't have 1
                    if(c%d==0) // if c is divisible by d add c/d
                        fc+=c/d;
                    /* eg: 00000, d = 2 forms c=4 (4 consecutive substrings having only '0's)
                        this can be changed to 01010 that is 2 '1's
                        if c is divisible by length of substring, we only need to add c/d
                    */
                    else
                        fc+=c/d+1; // c/d returns floored value(int division) so we add another 1 if c is not directly divisible by d
                }
                c=0;
            }
        }
        return fc;
    }

    public static int check(String t){
        int f=0;
        for(int j=0;j<t.length();j++){
            if(t.charAt(j)=='1'){
                f=1;
                break;
            }
        }
        if(f==1)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimumMoves("101",2));
    }
}