
public class OptionNotRecognizedException extends Exception {

    String err;

    OptionNotRecognizedException( String s ){
        err = s;
    }

}