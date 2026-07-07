package structuralPattrens.proxy.virtual;


// [프록시 패턴 - Subject(공통 인터페이스) 역할]
// 실제 객체(RealSubject)와 프록시(Proxy)가 공통으로 구현하는 타입.
// 클라이언트는 이 타입만 보고 사용하므로, 상대가 실제 객체인지 프록시인지 구분하지 못한다.
// (이 덕분에 프록시를 실제 객체처럼 끼워 넣어도 클라이언트 코드는 바뀌지 않는다.)
interface ILogin {
    void loginComplete(); // 로그인을 완료 알림을 위해 구현체가 구현해야 하는 메소드
}
