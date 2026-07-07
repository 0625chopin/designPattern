package structuralPattrens.decorator;

// [데코레이터 패턴 - Decorator(추상 장식자) 역할]
// Component를 구현하면서 동시에 다른 Component를 '감싸는(참조하는)' 추상 클래스.
// 감싼 대상(loginProcess)에게 기본 동작을 위임하고,
// 구체 데코레이터가 그 앞뒤로 부가 기능을 덧붙이게 한다.
// 이 '자기 타입을 필드로 참조'하는 구조가 여러 겹으로 중첩(체인)을 가능하게 한다.
abstract class LoginCheckAbstract implements LoginProcess {

    // 감싸고 있는 다음 대상 (원본 객체이거나 또 다른 데코레이터)
    private final LoginProcess loginProcess;

    public LoginCheckAbstract(LoginProcess loginProcess) {
        this.loginProcess = loginProcess;
    }

    @Override
    public void validationCheck_and_login() {
        loginProcess.validationCheck_and_login();  // 감싼 대상에게 위임
    }
}
