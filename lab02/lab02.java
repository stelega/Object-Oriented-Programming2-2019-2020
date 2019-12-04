import java.util.*;
import java.math.*;


public class lab02 {
    public static void main(String[] args) {
        if( args.length == 0)
            System.out.println("zbyt mało parametrów wywołania programu");
        else{
            int p = 397;
            int q = 103;
            int n = p * q;
            int o = (p-1)*(q-1);
            int e = 3;
            while (euclid(e, o) != 1)
                e++;
            int d = extendedEuclid(e, o);

            String s = new String("");       
            System.out.println("Zakodowana wiadomość: ");     
            for(int i=0; i< args[0].length(); i++){
                BigInteger big_e = new BigInteger(""+e);
                BigInteger big_n = new BigInteger(""+n);
                BigInteger big_d = new BigInteger(""+d);
                BigInteger t = new BigInteger ( "" + (int) args[0].charAt(i) );
            
                BigInteger c = t.modPow( big_e, big_n );
                System.out.println(c.modPow(big_d, big_n));
                s += (char) c.modPow(big_d, big_n).intValue();
            }
            
            System.out.println("\nZdekodowana wiadomość: " + s);
        }
    
    }

    public static int euclid( int a, int b ){
        while( b!=0 ){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    
    public static int extendedEuclid( int a, int b ){
        int x0 = 1;
        int x = 0;
        int b0 = b;
        while( b!=0 ){
            int q = a/b;
            int tmp = x;
            x = x0 - q*x;
            x0 = tmp;
            tmp = a%b;
            a=b;
            b=tmp;
        }
        if(x0<0)
            x0 = x0 + b0;
        return x0;
    }  

}
