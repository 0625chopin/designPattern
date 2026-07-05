package singleton;

public class SingletonInstance_v1 {

    public static SingletonInstance_v1 singletonInstance;

    private SingletonInstance_v1() {}

    public static SingletonInstance_v1 getInstance() {
        if(singletonInstance == null) {
            singletonInstance = new SingletonInstance_v1();
        }
        return singletonInstance;
    }
}
