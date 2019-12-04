import java.util.*;

public class lab08 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // klasa z pakietu java.util
        int nx = 1;

        while(true){
            System.out.println("Podaj liczbe calkowita wieksza od 1:");
            try{
                nx = sc.nextInt();
            }
            catch( Exception e){
                System.err.println( "BLAD: Podaj liczbe calkowita!");
                sc.nextLine();
            }
            if(nx <= 1){
                try{
                    throw new Exception();
                }
                catch (Exception e){
                    System.err.println( "Zbyt mala wartosc nx: " + nx + "!");
                }
            }
            else break;
        }

        char [][] board = new char [nx][nx];
        java.util.Random r = new java.util.Random();
        
        for(int i=0; i<nx; i++){
            for(int j=0; j<nx; j++){
                int k = r.nextInt(9);
                if( k<=2 )
                    board[i][j] = 'X';
                else
                    board[i][j] = ' ';
            }
        }
        board[nx/2][nx/2] = 'o';

        for( int j=nx-1; j>=0; j-- ){
            String tmp = new String("");        
            for( int i=0; i<nx; i++)
                tmp+= "" + board[i][j];
            System.out.println(tmp);
        }

        int i = nx/2;
        int j = nx/2;
        char c = 'a';

        while(true){
            System.out.println("wprowadz znak: ");
            c = sc.next().charAt(0);
            System.out.println(c);
            if(c == 'q')
                break;
            int changer[] = fun(c, i, j, board, nx );
            try{
                if(i+changer[0] < 0 || i+changer[0] >= nx || j+changer[1] < 0 || j+changer[1] >= nx  )
                    throw new WallException("Out of bounds!");
                else{
                    try{
                        if( board[ i+changer[0] ][ j+changer[1] ] == 'X' )
                            throw new WallException("You can't go through walls!");
                        else{
                            board[i][j] = ' ';
                            i+=changer[0];
                            j+=changer[1];
                            board[i][j] = 'o';
                        }
                    }
                    catch(WallException e){
                        System.err.println(e.err);
                    }
                }
            }
            catch(WallException e){
                System.err.println(e.err);
            }
            for( int k=nx-1; k>=0; k-- ){
                String tmp = new String("");        
                for( int l=0; l<nx; l++){
                    tmp+= "" + board[l][k];
                }
                System.out.println(tmp);
            }
        }
        sc.close();
    }


    public static int[] fun( char c, int i, int j, char board[][], int nx ){
        int[] changer = {0, 0}; 
        if(c == 'l')
            changer[0] = -1;
        else if(c == 'r')
            changer[0] = 1;
        else if(c == 'd')
            changer[1] = -1;
        else if(c == 'u')
            changer[1] = 1;
        else{
            try{
                throw new OptionNotRecognizedException("Not Recognized");
            }
            catch(OptionNotRecognizedException e){
                System.out.println(e.err);
            }
        }
        return changer;
    }
}
