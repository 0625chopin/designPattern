package structuralPattrens.proxy.virtual;

// [프록시 패턴 - RealSubject(실제 객체) 역할]
// 프록시가 대신 감싸는 진짜 대상. 생성 비용이 큰(로그인 확인에 시간이 걸리는) 무거운 객체다.
// 가상 프록시(Virtual Proxy)는 이 무거운 객체의 생성을 실제로 필요한 순간까지 미룬다.
public class LoginProcess implements ILogin{
    String loginUser;

    public LoginProcess(String user) {
        loginChek(user);
    }

    private void loginChek(String user)  {
        try {
            System.out.println("로그인 회원 확인중.");
            Thread.sleep(1000);
            this.loginUser = user;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("로그인 성공");
    }

    @Override
    public void loginComplete() {
        System.out.println("로그인이 완료 되었습니다.");
    }
}
