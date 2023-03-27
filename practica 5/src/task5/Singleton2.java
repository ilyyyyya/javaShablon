package task5;
//  Synchronized Accessor
public class Singleton2 {
    private static Singleton2 INSTANCE = null;
    private Singleton2() {}

    public static synchronized Singleton2 getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}
