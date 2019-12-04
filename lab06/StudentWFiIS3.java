public class StudentWFiIS3 extends Student {
    
    private StudentUSOS stud;


    StudentWFiIS3( String n, String s, int id, int r, String s1, double g1, String s2, double g2, String s3, double g3 ){
        super(n, s, id, g1, g2, g3);
        stud = op(r, s1,s2,s3);
    }

    public double srednia(){ return super.average(); }

    public String toString()
        { return "[" + stud.toString() + "] " + super.toString(); }

    public void listaPrzedmiotow()
        { stud.listaPrzedmiotow(); }

    public StudentUSOS op(int r, String s1, String s2, String s3){
        return new StudentUSOS(){

            String[] przedmioty = new String[]{s1,s2,s3};        

            public String toString()
                { return "" + r; }

            public double srednia()
                { return average(); }

            public void listaPrzedmiotow(){
                for(int i=0; i<przedmioty.length; i++)
                    System.out.println( "\t" + (i+1) + ". " + przedmioty[i] + " " + getGrade(i) );
            }
        };
    }

}
