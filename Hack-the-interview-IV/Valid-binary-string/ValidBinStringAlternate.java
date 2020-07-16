// Faster if number of 1s in the string is less
class ValidBinStringAlternate
{
    public static int minimumMoves(String s, int d)
    {
        if(d==0 || d>s.length() || s.indexOf('0')==-1)
            return 0;
        int i1 =-1, i2 =0, np=0, fc=0;
        i2 = s.indexOf('1'); // find 1. 
        while(i2!=-1){
            System.out.println(" i1= "+i1+" i2= "+i2+" fc= "+fc);
            np=i2-i1-d; //000101
            fc+=calculate(np,d);
            i1=i2;
            if(i2>=s.length()-d)
                break;
            i2=s.indexOf('1',i1+1);
            System.out.println("i2 = " +i2);
        }
        if(i2==-1){ //000000
            np=s.length()-i1-d; // 7-2 = 5
            fc+=calculate(np,d);
        }
        return fc;
    }
    static int calculate(int np,int d){
        if(np<=0)
            return 0;
        int fc=0;
        if(np%d==0)
            fc=np/d;
        else
            fc=np/d+1;
        return fc;
    }
    public static void main(String[] args)
    {
        System.out.println("Final value of fc="+minimumMoves("1001000010",2));
    }
}