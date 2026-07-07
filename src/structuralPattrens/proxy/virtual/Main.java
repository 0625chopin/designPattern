package structuralPattrens.proxy.virtual;

// [프록시 패턴 - Client(사용 예)]
// 프록시를 실제 객체처럼 다룬다(둘 다 ILogin 타입).
// login1~3 프록시를 만들어도 무거운 LoginProcess는 생성되지 않고,
// 실제로 loginComplete()를 호출한 login1에서만 실제 객체가 생성된다.
// (login2, login3는 호출하지 않았으므로 실제 객체 생성 비용이 발생하지 않는다.)
public class Main {
    static void main() {
        ILogin login1 = new LoginProxy("user1");
        ILogin login2 = new LoginProxy("user2");
        ILogin login3 = new LoginProxy("user3");
        login1.loginComplete();  // 이 시점에만 실제 LoginProcess 생성
    }
}
