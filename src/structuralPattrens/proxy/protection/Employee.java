package structuralPattrens.proxy.protection;

// [프록시 패턴(보호 프록시) - RealSubject(실제 객체) 역할]
// 실제 인사 정보를 담고 있는 진짜 대상. getInfo()는 권한 검사 없이 정보를 그대로 반환한다.
// 접근 제어(권한 검사)는 이 객체가 아니라 보호 프록시(ProtectedEmployee)가 담당한다.
public class Employee implements IEmployee {
    private String name;
    private RESPONSIBILITY position;

    public Employee(String name, RESPONSIBILITY position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RESPONSIBILITY getGrade() {
        return position;
    }

    @Override
    public String getInfo(IEmployee viewer) {
        return "Display " + getGrade().name() + " `" + getName() +"`personnel information.";
    }
}
