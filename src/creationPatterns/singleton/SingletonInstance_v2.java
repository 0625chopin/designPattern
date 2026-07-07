package creationPatterns.singleton;

// [싱글턴 패턴 - Singleton(단일 인스턴스) 역할 / synchronized 동기화형]
// getInstance() 메서드 전체에 synchronized 를 걸어 중복 생성을 막은 형태.
// v1의 thread-safety 문제는 해결되지만, 이미 인스턴스가 만들어진 뒤에도
// 매 호출마다 락(lock)을 획득/해제하므로 불필요한 동기화 비용이 발생한다는 단점이 있다.
public class SingletonInstance_v2 {

    // 유일 인스턴스를 담는 정적 필드
    private static SingletonInstance_v2 singletonInstance;

    // 외부 new 를 막기 위한 private 생성자
    private SingletonInstance_v2() {}

    // synchronized 로 한 번에 한 스레드만 진입 → 중복 생성 방지(단, 호출마다 락 비용 발생)
    public synchronized static SingletonInstance_v2 getInstance() {
        if(singletonInstance == null) {
            singletonInstance = new SingletonInstance_v2();
        }
        return singletonInstance;
    }
}
