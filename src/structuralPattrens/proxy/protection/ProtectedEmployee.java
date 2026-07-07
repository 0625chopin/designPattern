package structuralPattrens.proxy.protection;

// [프록시 패턴(보호 프록시) - Proxy(대리자) 역할]
// Subject(IEmployee)를 구현해 실제 객체(Employee)를 대신하며, 접근 권한을 검사한다.
// getInfo() 호출 시 조회자(viewer)의 직책과 대상의 직책을 비교해,
// 권한이 있으면 실제 객체에 위임하고 없으면 조회를 거부한다. (접근 제어가 핵심)
// 보호 프록시 : 인사정보가 보호된 구성원 (인사 정보 열람 권한 없으면 조회 거부)
class ProtectedEmployee implements IEmployee {
    private IEmployee employee;  // 보호하는 실제 대상(RealSubject)

    public ProtectedEmployee(IEmployee employee) {
        this.employee = employee;
    }

    @Override
    public String getInfo(IEmployee viewer) {

        RESPONSIBILITY position = this.employee.getGrade(); // 조회 당하는 자의 직책을 얻기

        // 매개변수로 받은 조회자의 직책에 따라 출력을 제어
        switch (viewer.getGrade()) {
            case DIRECTOR:
                // 부사장은 과장, 사원들을 볼 수 있다.
                return this.employee.getInfo(viewer);
            case MANAGER:
                // 과장은 같은 직무와 그 아래 사원들을 볼 수 있다. 사장 정보는 볼 수 없다.
                if (position != RESPONSIBILITY.DIRECTOR) {
                    return this.employee.getInfo(viewer);
                }
            case STAFF:
                // 사원은 같은 직무인 사람들만 볼 수 있다. 과장, 사장 정보는 볼 수 없다.
                if (position != RESPONSIBILITY.DIRECTOR && position != RESPONSIBILITY.MANAGER) {
                    return this.employee.getInfo(viewer);
                }
            default: return "다른 사람의 인사정보를 조회 할수 없습니다";
        }
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public RESPONSIBILITY getGrade() {
        return employee.getGrade();
    }
}
