package structuralPattrens.proxy.virtual;


// 대상 객체와 프록시 객체를 묶는 인터페이스
interface ILogin {
    void loginComplete(); // 로그인을 완료 알림을 위해 구현체가 구현해야 하는 메소드
}
