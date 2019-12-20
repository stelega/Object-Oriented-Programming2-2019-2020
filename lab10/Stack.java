import java.lang.Class.*;
import java.lang.reflect.Array;

public class Stack<T>{

    private T[] tab;
    private int size;
    private final int max_size;


    public Stack( int max_s, Class<T[]> cls ){
        max_size = max_s;
        
        tab = cls.cast(Array.newInstance(cls.getComponentType(), max_size));
        size = 0;
    }

    public boolean isEmpty()
        { return size == 0 ? true : false; }


    public boolean isFull()
        { return size == max_size ? true : false; }


    public void push(T x) throws StackOverflowException { 
        if( this.isFull() )
            throw new StackOverflowException("BLAD DANYCH WEJSCIOWYCH! Koniec algorytmu, a stos nie jest pusty:");
        
    
        tab[size++] = x;
    }

    public T pop() throws StackUnderflowException {
        if( this.isEmpty() )
            throw new StackUnderflowException("BLAD DANYCH WEJSCIOWYCH! Na stosie jest za malo elementow, zeby wykonac operacje!");
        tab[size] = null;
        return tab[--size];
    }

    public int getSize()
        { return size; }

    public String toString(){
        String s = new String("");
        for( var i : tab )
            s += "" + i;
        return s;
    }

}
