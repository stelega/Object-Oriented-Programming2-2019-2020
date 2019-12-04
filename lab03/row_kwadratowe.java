
public class row_kwadratowe{

    public Complex[] rozw(double a, double b, double c){
        double delta = b*b - 4*a*c ;
        if( delta < 0){
            Complex c_a = new Complex(2*a);
            Complex c_b = new Complex(-b);
            Complex complex = new Complex();
            Complex x[] = { new Complex( complex.divide(complex.add(c_b, complex.sqrt(delta) ),c_a) ), new Complex( complex.divide(complex.subtract(c_b, complex.sqrt(delta) ),c_a) )};
            return x;
        }
        else{
            Complex x[] = { new Complex( (-b + Math.sqrt(delta) )/(2*a) ), new Complex( (-b - Math.sqrt(delta) )/(2*a) ) };        
            return x;
        }
    };


}
