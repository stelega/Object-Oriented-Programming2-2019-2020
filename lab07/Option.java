
public enum Option{ 
    RESET('0', "Reset planszy"),
    LEFT ('l', "Przesun w lewo, wektor przesuniecia: " + Direction.LEFT),
    RIGHT ('r', "Przesun w prawo, wektor przesuniecia: " + Direction.RIGHT),
    UP ('u', "Przesun w gore, wektor przesuniecia: " + Direction.UP),
    DOWN ('d', "Przesun w dol, wektor przesuniecia: " + Direction.DOWN),
    EXIT('q', "Zakonczenie gry");

    private char q;
    private String opis;
    
    Option( char q, String opis ){
        this.q = q;
        this.opis = new String(opis);
    }

    Option( char q, String opis, Direction direction ){
        this.q = q;
        this.opis = new String(opis);
        this.opis += "" + direction;
    }

    public char get_znak()
        { return q; }
    public String get_opis()
        { return opis; }
    // public Direction get_direction()
    //     { return direction; }

    public String toString()
        { return "'" + q + "' ==> opcja " + name() + " opis: " + opis ; }


    }

