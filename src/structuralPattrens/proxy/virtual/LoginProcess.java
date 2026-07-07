package structuralPattrens.proxy.virtual;

// realSubject
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
