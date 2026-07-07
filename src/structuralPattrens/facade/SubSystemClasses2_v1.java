package structuralPattrens.facade;

// [파사드 패턴 - SubSystem(서브시스템) 역할]
// 파사드가 감싸 조율하는 하위 기능 중 하나. 클라이언트가 직접 다루지 않는다.
public class SubSystemClasses2_v1 {
    public boolean SubSystemClasses2(String str) {
        System.out.println("SubSystemClasses2_v1.SubSystemClasses2 : " + str);
        return true;
    }
}
