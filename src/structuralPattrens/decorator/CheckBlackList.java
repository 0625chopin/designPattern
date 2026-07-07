package structuralPattrens.decorator;

public class CheckBlackList extends LoginCheckAbstract {

    public CheckBlackList(LoginProcess loginProcess) {
        super(loginProcess);
    }

    @Override
    public void validationCheck_and_login() {
        userBlackListCheck();
        super.validationCheck_and_login();
    }

    private void userBlackListCheck() {
        System.out.println("사용자 블랙리스트 체크 성공");
    }

}
