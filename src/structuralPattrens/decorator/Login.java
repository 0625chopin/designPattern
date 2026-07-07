package structuralPattrens.decorator;

// [데코레이터 패턴 - ConcreteComponent(원본 객체) 역할]
// 장식의 대상이 되는 핵심 객체. 데코레이터로 감싸기 전의 기본 기능(로그인)만 담당한다.
// 항상 장식의 가장 안쪽(체인의 끝)에 위치한다.
public class Login implements LoginProcess {
    @Override
    public void validationCheck_and_login() {
        System.out.println("로그인이 완료 되었습니다.");
    }
}
