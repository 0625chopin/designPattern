package structuralPattrens.decorator;

abstract class LoginCheckAbstract implements LoginProcess {

    private final LoginProcess loginProcess;

    public LoginCheckAbstract(LoginProcess loginProcess) {
        this.loginProcess = loginProcess;
    }

    @Override
    public void validationCheck_and_login() {
        loginProcess.validationCheck_and_login();  // 위임
    }
}
