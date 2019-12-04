import java.util.*;

public class lab07 {

    public static void main(String[] args) {
        if(args.length == 3){
            System.out.println("Dostepne opcje:");
            for( var op : Option.values())
                System.out.println(op);

            int NX = Integer.valueOf(args[0]);
            int NY = Integer.valueOf(args[1]);

            int p = (int) (1./Double.valueOf(args[2]) );

            String s = new String("");
            for(int i=0; i< Option.values().length; i++)
                s += Option.values() [i];
            

                char [][] board = new char [NX][NY];
                char [][] board2 = new char [NX][NY];

            java.util.Random r = new java.util.Random();

            for(int i=0; i<NX; i++){
                board[i][0] = 'X';
                board[i][NY-1] = 'X';            
            }
            
            for(int i=1; i<NY-1; i++){
                board[0][i] = 'X';
                board[NX-1][i] = 'X';            
            }

            board[r.nextInt(NX-1)][NX-1] = ' ';
            
            for( int i=1; i<NX-1; i++ ){
                for( int j=1; j<NY-1; j++){
                    if(r.nextInt(p) == 0 )
                        board[i][j] = 'X';
                    else
                        board[i][j] = ' ';
                }
            }
            for(int i=0; i<NX; i++){
                for(int j=0; j<NY; j++)
                    board2[i][j] = board[i][j];
            }
            int i = r.nextInt(NX-2) + 1;
            int j = r.nextInt(NY-2) + 1;
            board[i][j] = 'o';

            System.out.println("");

            for( int k=NY-1; k>=0; k-- ){
                String tmp = new String("");        
                for( int l=0; l<NX; l++){
                    tmp+= "" + board[l][k];
                }
            
                System.out.println(tmp);
            }
            
            Direction dir = Direction.LEFT;

            Scanner sc = new Scanner(System.in); // klasa z pakietu java.util
            while(true){
                System.out.println("Wybierz opcje: ");
                char z = sc.next().charAt(0);
                if( z == Option.EXIT.get_znak())
                    break;
                else if(z == Option.LEFT.get_znak())
                    dir = Direction.LEFT;
                
                else if(z == Option.RIGHT.get_znak())
                    dir = Direction.RIGHT;
                else if(z == Option.UP.get_znak())
                    dir = Direction.UP;
                else if(z == Option.DOWN.get_znak())
                    dir = Direction.DOWN;
                
                else if(z == Option.RESET.get_znak()){
                    for(int l=0; l<NX; l++){
                        for(int k=0; k<NY; k++)
                            board[l][k] = board2[l][k];
                    }
                    i = r.nextInt(NX-2) + 1;
                    j = r.nextInt(NY-2) + 1;
                    board[i][j] = 'o';

                }
                if( board[i+dir.get_x()][j+dir.get_y()] == 'X' )
                    System.out.println("Ruch niedozwolony");
                else{
                    board[i+dir.get_x()][j+dir.get_y()] = 'o';
                    board[i][j] = ' ';
                    i += dir.get_x();
                    j += dir.get_y();
                } 
                    
                for( int k=NY-1; k>=0; k-- ){
                    String tmp = new String("");        
                    for( int l=0; l<NX; l++){
                        tmp+= "" + board[l][k];
                    }
                    System.out.println(tmp);
                }
                if(j==NX-1){
                    System.out.println("Gratulacje, znalazłeś wyjście z labiryntu");
                    break;
                }
            }
            
            
            sc.close();
        }
        else
            System.out.println("Za mało parametrów wywołania.");
    }
}
