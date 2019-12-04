import java.util.*;
import java.math.*;

public class Complex{

    private double m_re = 0.;
    private double m_im = 0.;
    
    static final Complex I = new Complex(0, 1);
    static final Complex ZERO = new Complex(0, 0);
    static final Complex ONE = new Complex(1, 0);

    Complex(){}

    Complex(double re)
        { m_re = re; }
    
    Complex(double re, double im){
        m_re = re;
        m_im = im;
    }

    Complex( Complex c1){
        m_re = c1.m_re;
        m_im = c1.m_im;
    }

    double getRe()
        { return m_re; }

    double getIm()
        { return m_im; }
    
    public static Complex add( Complex c1, Complex c2 )
        { return new Complex( c1.getRe() + c2.getRe(), c1.getIm() + c2.getIm() ); }

    public static Complex subtract( Complex c1, Complex c2 )
        { return new Complex( c1.getRe() - c2.getRe(), c1.getIm() - c2.getIm() ); }
    
    public static Complex multiply( Complex c1, Complex c2 )
        { return new Complex( c1.getRe() * c2.getRe() - c1.getIm() * c2.getIm(), c1.getIm() * c2.getRe() + c1.getRe() * c2.getIm() ); }

    public static Complex multiply( Complex c1, double x)
        { return new Complex( c1.getRe() * x, c1.getIm() * x ); }

    public static Complex divide( Complex c1, Complex c2 )
        { return new Complex( ( c1.getRe() * c2.getRe() + c1.getIm() * c2.getIm() ) / ( c2.getRe()*c2.getRe() + c2.getIm()*c2.getIm() ), (c1.getIm() * c2.getRe() - c1.getRe() * c2.getIm())/(c2.getRe()*c2.getRe() + c2.getIm()*c2.getIm()) ); }
  
    double mod()
        { return Math.sqrt( m_re * m_re + m_im * m_im ); }

    public static Complex sqrt( double x )
        { return (x < 0.) ? new Complex( 0., Math.sqrt(x * (-1.)) ) : new Complex( Math.sqrt(x) ); }

    boolean equals( Complex c1 )
        { return (m_re == c1.m_re && m_im == c1.m_im ) ? true : false; }

    void conjugate()
        { m_im = m_im * (-1); }

    void opposite(){
        m_re = m_re * (-1);
        m_im = m_im * (-1);
    }

    public String toString(){
        if(m_re != 0){
            if( m_im < 0 )
                return m_re + " - " + m_im*(-1) + "i";
            else if( m_im == 0)
                return m_re + "";
            else return m_re + " + " + m_im + "i";
        }
        else{
            if( m_im == 0 )
                return m_re + "";
            else
                return m_im + "i";
        }
    }

}
