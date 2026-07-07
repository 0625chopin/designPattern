package structuralPattrens.proxy.virtual;

// [프록시 패턴 - Proxy(대리자) 역할]
// Subject(ILogin)를 구현하여 실제 객체(LoginProcess)를 대신하는 대리 객체.
// 생성 시점에는 실제 객체를 만들지 않고 필요한 정보(loginUser)만 들고 있다가,
// loginComplete()가 실제로 호출될 때 비로소 실제 객체를 생성해 위임한다. (지연 초기화)
// 그래서 프록시만 만들고 호출하지 않으면 무거운 실제 객체는 아예 생성되지 않는다.
public class LoginProxy implements ILogin{
    private String loginUser;
    private ILogin proxy;  // 실제 객체(RealSubject) 참조 - 호출 전까지는 null

    public LoginProxy(String loginUser) {
        // 무거운 실제 객체를 여기서 만들지 않고, 필요한 정보만 보관한다
        this.loginUser = loginUser;
    }

    @Override
    public void loginComplete() {
        proxy = new LoginProcess(loginUser);  // 실제 호출 시점에 비로소 생성 (지연 초기화)
        proxy.loginComplete();                // 실제 객체에 위임
    }
}
