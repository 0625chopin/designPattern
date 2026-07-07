package structuralPattrens.decorator;

// [데코레이터 패턴 - ConcreteDecorator(구체적 장식자) 역할]
// 감싼 대상의 기본 동작 앞에 '비밀번호 체크'라는 부가 기능을 덧붙인다.
public class PwdCheck extends LoginCheckAbstract {

    public PwdCheck(LoginProcess loginProcess) {
        super(loginProcess);
    }

    @Override
    public void validationCheck_and_login() {
        userPwdCheck();
        super.validationCheck_and_login();
    }

    private void userPwdCheck() {
        System.out.println("사용자 비밀번호 체크 성공");
    }

}
