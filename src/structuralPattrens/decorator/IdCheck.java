package structuralPattrens.decorator;

// [데코레이터 패턴 - ConcreteDecorator(구체적 장식자) 역할]
// 감싼 대상의 기본 동작 앞에 'ID 체크'라는 부가 기능을 덧붙인다.
// (userIdCheck() 실행 후 super를 통해 감싼 대상의 동작을 이어서 수행)
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
