public class StudentWFiIS2 implements StudentUSOS {

    private String[] przedmioty;
    private int rok;
    private Student stud;


    StudentWFiIS2( String n, String s, int id, int r, String s1, double g1, String s2, double g2, String s3, double g3 ){
        stud = new Student(n, s, id, g1, g2, g3);
        rok = r;
        przedmioty = new String[3];
        przedmioty[0] = s1;
        przedmioty[1] = s2;
        przedmioty[2] = s3;
    }

    public String toString() 
        { return "[" + rok + "] " + stud.toString(); }


    public double srednia()
        { return stud.average(); }

    public void listaPrzedmiotow(){
        for(int i=0; i<przedmioty.length; i++)
            System.out.println( "\t" + (i+1) + ". " + przedmioty[i] + " " + stud.getGrade(i));
    }

}
