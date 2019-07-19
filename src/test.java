//24
public class test {
    public static void main(String[] args) {

    }

}
class Singleton{
    private static volatile Singleton singleton;

    public Singleton() {
    }
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}


