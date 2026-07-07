package structuralPattrens.facade;

// [파사드 패턴 - SubSystem(서브시스템) 역할]
// 파사드가 감싸 조율하는 하위 기능 중 하나. 클라이언트가 직접 다루지 않는다.
public class SubSystemClasses1_v1 {
    public boolean SubSystemClasses1(String str) {
        System.out.println("SubSystemClasses1_v1.SubSystemClasses1 : " + str);
        return true;
    }
}
