package structuralPattrens.proxy.protection;

// [프록시 패턴(보호 프록시) - Subject(공통 인터페이스) 역할]
// 실제 객체(Employee)와 보호 프록시(ProtectedEmployee)가 공통으로 구현하는 타입.
// 클라이언트는 이 타입만 보고 사용하므로, 실제 객체를 쓰는지 프록시를 쓰는지 구분하지 못한다.
public interface IEmployee {
    String getName();
    RESPONSIBILITY getGrade();
    String getInfo(IEmployee viewer);
}
