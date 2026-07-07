package structuralPattrens.decorator;

public class LoginBuilder {
    private LoginProcess loginProcess;

    public LoginBuilder() {
        this.loginProcess = new Login();
    }

    public static LoginBuilder start() {
        return new LoginBuilder();
    }

    public LoginBuilder checkId() {
        this.loginProcess = new IdCheck(loginProcess);
        return this;
    }

    public LoginBuilder checkPwd() {
        this.loginProcess = new PwdCheck(loginProcess);
        return this;
    }

    public LoginBuilder checkBlackList() {
        this.loginProcess = new CheckBlackList(loginProcess);
        return this;
    }

    public LoginProcess build() {
        return loginProcess;
    }
}
