package structuralPattrens.proxy.protection;

import java.util.List;

// [프록시 패턴(보호 프록시) - Client 보조 역할]
// 특정 조회자(viewer) 입장에서 직원 목록의 인사 정보를 출력한다.
// 프록시를 거쳐 정보를 얻으므로, 같은 목록이라도 viewer의 직책에 따라 출력 결과가 달라진다.
public class PrintEmployeeInfo {
    IEmployee viewer;  // 조회하는 주체(직책에 따라 열람 범위가 결정됨)

    public PrintEmployeeInfo(IEmployee viewer) {
        this.viewer = viewer;
    }

    void printAllInfo(List<IEmployee> employees) {
        employees.stream()
                .map(employee -> employee.getInfo(viewer))
                .forEach(System.out::println);
    }
}
