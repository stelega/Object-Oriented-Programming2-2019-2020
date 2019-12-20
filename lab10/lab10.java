

public class lab10 {

    public static void main(String[] args) {

        if(args.length == 1){
            String arr[] = args[0].split("");
            Stack<String> stos = new Stack<>(arr.length, String[].class);

            try{
                for( int i=0; i<arr.length; i++ ){
                    if( arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/") ){
                        String tmp = arr[i] + stos.pop() + ")";
                        String tmp2 = "(" + stos.pop() + tmp;
                        stos.push(tmp2);
                    }
                    else
                        stos.push(arr[i]);
                }
           
            
            
            if(stos.getSize() == 1 )
                System.out.println("Wynik: " + stos.pop());
            
            else{
                String tmp = "BLAD DANYCH WEJSCIOWYCH! Koniec algorytmu, a stos nie jest pusty: ";
                for( int i=0; i<stos.getSize(); i++ ){
                    tmp += stos.pop() + " ";
                }
                System.out.println(tmp);
            }
            } 
            catch(StackOverflowException e){
                System.out.println(e.err);
            }
            catch(StackUnderflowException e){
                System.out.println(e.err);
            }
        }
        else
            System.out.println("Zbyt malo parametrow wywolania programu!");

    }
}
