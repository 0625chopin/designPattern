package structuralPattrens.proxy.virtual;

public class LoginProxy implements ILogin{
    private String loginUser;
    private ILogin proxy;

    public LoginProxy(String loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public void loginComplete() {
        proxy = new LoginProcess(loginUser);
        proxy.loginComplete();
    }
}
