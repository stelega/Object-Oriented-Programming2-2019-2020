import java.util.*;
import java.lang.*;
import java.lang.reflect.*;

public class lab09 {
    public static void main(String[] args) {
        try{
            String[] s = splitArgs(args[0]);
            Class<?> c1 = java.lang.Math.class;
            try{
                if(s.length == 2){
                    Object obj = null;
                    Method mn = c1.getMethod(s[0], double.class);
                    System.out.println( args[0] + " = " + mn.invoke(obj, Double.parseDouble(s[1])) );
                }
                else if (s.length == 3){
                    Object obj = null;
                    Method mn = c1.getMethod(s[0], double.class, double.class);
                    System.out.println( args[0] + " = " + mn.invoke(obj, Double.parseDouble(s[1]), Double.parseDouble(s[2]) ) );
                }
                else
                    throw new Exception();
            }
            catch( NoSuchMethodException e )
                { System.err.println( "Nie ma takiej metody!" ); }
            catch( NumberFormatException e )
                { System.err.println( "Argumenty funkcji musza byc liczbami!" ); }
            catch( Exception e )
                { System.err.println( "Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby." ); }
                
        }
        catch(Exception e)
            { System.err.println( "Nie podano nic do obliczenia." ); }
    }

    public static String[] splitArgs(String arg)
        { return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new); }

}
