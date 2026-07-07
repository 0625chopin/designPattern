package structuralPattrens.proxy.virtual;

public class Main {
    static void main() {
        ILogin login1 = new LoginProxy("user1");
        ILogin login2 = new LoginProxy("user2");
        ILogin login3 = new LoginProxy("user3");
        login1.loginComplete();
    }
}
