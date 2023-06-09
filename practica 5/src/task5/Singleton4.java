package task5;

//  On Demand Holder idiom
public class Singleton4 {
    public static class SingletonHolder {
        public static final Singleton4 HOLDER_INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
