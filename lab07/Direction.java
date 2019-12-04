
public enum Direction{ 
    LEFT (-1, 0),
    RIGHT (1, 0),
    UP (0, 1),
    DOWN (0, -1);
    
    private int x;
    private int y;

    Direction( int x, int y ){
        this.x = x;
        this.y = y;
    }

    public int get_x()
        { return x; }
    public int get_y()
        { return y; }

    public String toString()
        { return "[" + x + ", " + y + "]"; }


    }

