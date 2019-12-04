abstract class Man {
    private final String name;
    private final String surname;

    // DOPISAC: Konstruktor

    Man( String n, String surn ){
        name = new String(n);
        surname = new String(surn);
    }

    // DOPISAC: Metody typu get
    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }
    // DOPISAC: toString zwracajacy lancuch z imieniem i nazwiskiem

    public String toString(){
        return name + " " + surname;
    }

    abstract public Man compare(Man ob);

    public double average() {
        return 0.0;
    }
}


class Student extends Man{

    private int album_nr;
    private double [] grades = new double[3];
    
    
    Student( String n, String surn, int nr, double grade_0, double grade_1, double grade_2 ){
        super(n, surn);
        album_nr = nr;
        grades[0] = grade_0;
        grades[1] = grade_1;
        grades[2] = grade_2;
    }

    public double average() {
        double sum = 0.;
        for( int i=0; i<grades.length; i++)
            sum += grades[i];
        return sum/grades.length;
    }

    public Man compare(Man ob){
        
        if(ob instanceof Student){
            Student obj = (Student)ob;
            if( average() > obj.average() )
                return this;
            else 
                return obj;
        }
        else
            return null;    
    }


    public String toString(){
        return super.toString() + ", id number: " + album_nr + ", grades: [" + grades[0] + ", " + grades[1] + ", " + grades[2] + "]"; 
    }

}


class Graduate extends Student{
   
    private int graduate_year;
    private String title;


    Graduate( String tit, String n, String surn, int nr, int gr_year, double grade_0, double grade_1, double grade_2){
        super(n, surn, nr, grade_0, grade_1, grade_2 );
        graduate_year = gr_year;
        title = tit;
    }

    public String toString(){
        return title + " " + super.toString() + ", year of graduation: " + graduate_year;
    }
    

}


class Dean extends Man{

    private int start_year;
    private int end_year;
    private String title;

    Dean( String tit, String n, String surn, int start, int end){
        super(n, surn);
        title = tit;
        start_year = start;
        end_year = end;
    }

    public double average() {
        System.out.println("[Average not applicable]");
        return super.average();
    }

    public Man compare(Man ob){
        if(ob instanceof Dean){
            Dean obj = (Dean)ob;
            if( end_year > obj.end_year )
                return this;
            else
                return obj;
        }
        else
            return null;    
    }
    public String toString(){
        return title + " " + super.toString() + ", Dean of the Faculty from " + start_year + " to " + end_year + ".";
    }
}







