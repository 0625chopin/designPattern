package structuralPattrens.decorator;

public class Login implements LoginProcess {
    @Override
    public void validationCheck_and_login() {
        System.out.println("로그인이 완료 되었습니다.");
    }
}
