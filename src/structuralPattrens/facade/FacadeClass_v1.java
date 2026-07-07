package structuralPattrens.facade;

// [파사드 패턴 - Facade(통합 창구) 역할]
// 여러 서브시스템(c1, c2, c3)을 감추고 facadeMethod() 하나로 묶어 제공한다.
// 클라이언트는 서브시스템의 존재나 호출 순서를 몰라도 되고, 파사드가 조율을 대신한다.
public class FacadeClass_v1 {

    // 파사드가 조율하는 서브시스템들
    private SubSystemClasses1_v1 c1 = new SubSystemClasses1_v1();
    private SubSystemClasses2_v1 c2 = new SubSystemClasses2_v1();
    private SubSystemClasses3_v1 c3 = new SubSystemClasses3_v1();

    public void facadeMethod(String str1, String str2, String str3) {
        if(c1.SubSystemClasses1(str1) && c2.SubSystemClasses2(str3)) {
            c3.SubSystemClasses3(str2);
            System.out.println(str1 + str2 + str3);
        } else {
            System.out.println("fail");
        }
    }
}
