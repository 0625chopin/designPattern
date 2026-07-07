package structuralPattrens.decorator;

public class Main {
    static void main() {
        LoginProcess idCheck = new IdCheck(new Login());
        idCheck.validationCheck_and_login();
        System.out.println();

        LoginProcess idAndPwdCheck = new IdCheck(new PwdCheck(new Login()));
        idAndPwdCheck.validationCheck_and_login();
        System.out.println();

        LoginProcess idAndPwdAndBlackListCheck = new IdCheck(new PwdCheck( new CheckBlackList(new Login())));
        idAndPwdAndBlackListCheck.validationCheck_and_login();
    }
}
