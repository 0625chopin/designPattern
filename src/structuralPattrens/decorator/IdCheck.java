package structuralPattrens.decorator;

public class IdCheck extends LoginCheckAbstract {

    public IdCheck(LoginProcess loginProcess) {
        super(loginProcess);
    }

    @Override
    public void validationCheck_and_login() {
        userIdCheck();
        super.validationCheck_and_login();
    }

    private void userIdCheck() {
        System.out.println("사용자 ID 체크 성공");
    }

}
