package creationPatterns.singleton;

public class SingletonInstance_v2 {

    private static SingletonInstance_v2 singletonInstance;

    private SingletonInstance_v2() {}

    public synchronized static SingletonInstance_v2 getInstance() {
        if(singletonInstance == null) {
            singletonInstance = new SingletonInstance_v2();
        }
        return singletonInstance;
    }
}
