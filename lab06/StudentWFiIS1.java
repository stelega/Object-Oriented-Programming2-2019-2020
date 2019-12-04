public class StudentWFiIS1 extends Student implements StudentUSOS {
    
    private String[] przedmioty;
    private int rok;


    StudentWFiIS1( String n, String s, int id, int r, String s1, double g1, String s2, double g2, String s3, double g3 ){
        super(n, s, id, g1, g2, g3);
        rok = r;
        przedmioty = new String[3];
        przedmioty[0] = s1;
        przedmioty[1] = s2;
        przedmioty[2] = s3;
    }

    public String toString() 
        { return "[" + rok + "] " + super.toString(); }

    public double srednia()
        { return super.average(); }

    public void listaPrzedmiotow(){
        for(int i=0; i<przedmioty.length; i++)
            System.out.println( "\t" + (i+1) + ". " + przedmioty[i] + " " + super.getGrade(i) );
    }

}
