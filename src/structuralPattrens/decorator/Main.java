package structuralPattrens.decorator;

// [데코레이터 패턴 - Client(사용 예)]
// 원본 객체(Login)를 데코레이터로 겹겹이 감싸 기능을 동적으로 조합한다.
// 필요한 체크만 골라 원하는 순서로 감쌀 수 있고, 원본/데코레이터 코드는 수정하지 않는다.
public class Main {
    static void main() {
        // ID 체크만 추가
        LoginProcess idCheck = new IdCheck(new Login());
        idCheck.validationCheck_and_login();
        System.out.println();

        // ID 체크 + 비밀번호 체크
        LoginProcess idAndPwdCheck = new IdCheck(new PwdCheck(new Login()));
        idAndPwdCheck.validationCheck_and_login();
        System.out.println();

        // ID 체크 + 비밀번호 체크 + 블랙리스트 체크
        // 바깥쪽부터 실행되어 ID -> 비밀번호 -> 블랙리스트 -> 로그인 순으로 동작
        LoginProcess idAndPwdAndBlackListCheck = new IdCheck(new PwdCheck( new CheckBlackList(new Login())));
        idAndPwdAndBlackListCheck.validationCheck_and_login();
    }
}
