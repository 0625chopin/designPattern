package structuralPattrens.decorator;

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
