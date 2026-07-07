package structuralPattrens.proxy.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [프록시 패턴(보호 프록시) - Client(사용 예)]
// 실제 Employee 객체들을 보호 프록시(ProtectedEmployee)로 감싼 뒤,
// 조회자의 직책을 바꿔가며(사원/과장/상무) 같은 목록을 조회한다.
// 프록시가 권한을 검사하므로 조회자 직책에 따라 열람 가능한 정보가 달라지는 것을 확인할 수 있다.
public class Main {
    public static void main(String[] args) {
        // 직원별 개인 객체 생성
        Employee CTO = new Employee("Dragon Jung", RESPONSIBILITY.DIRECTOR);
        Employee devManager = new Employee("Cats Chang", RESPONSIBILITY.MANAGER);
        Employee financeManager = new Employee("Dell Choi", RESPONSIBILITY.MANAGER);
        Employee devStaff = new Employee("Dark Kim", RESPONSIBILITY.STAFF);
        Employee financeStaff = new Employee("Pal Yoo", RESPONSIBILITY.STAFF);

        // 직원들을 리스트로 가공
        List<Employee> employees = Arrays.asList(CTO, devManager, financeManager, devStaff, financeStaff);

        /*-----------------------------------------------------------------------------------------*/

        // 기존에 등록된 리스트를 수정할 수 없으니, 동적으로 기존의 Employee 객체를 프록시 객체 ProtectedEmployee로 Wrap하는 작업을 실행한다.
        List<IEmployee> protectedEmployees = new ArrayList<>();
        for (Employee e : employees) {
            protectedEmployees.add(new ProtectedEmployee((IEmployee) e));
        }

        /*-----------------------------------------------------------------------------------------*/

        // 나 : 일개 사원 직책
        Employee me = new Employee("inpa", RESPONSIBILITY.STAFF);

        System.out.println("\n================================================================");
        System.out.println("시나리오1. 일개 사원인 내가 회사 인원 인사 정보 조회");
        System.out.println("================================================================");
        PrintEmployeeInfo view = new PrintEmployeeInfo(me);
        view.printAllInfo(protectedEmployees);

        System.out.println("\n================================================================");
        System.out.println("시나리오2. 과장이 회사 인원 인사 정보 조회");
        System.out.println("================================================================");
        PrintEmployeeInfo view2 = new PrintEmployeeInfo(devManager);
        view2.printAllInfo(protectedEmployees);

        System.out.println("\n================================================================");
        System.out.println("시나리오3. 상무가 회사 인원 인사 정보 조회");
        System.out.println("================================================================");
        PrintEmployeeInfo view3 = new PrintEmployeeInfo(CTO);
        view3.printAllInfo(protectedEmployees);
    }
}
