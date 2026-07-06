package structuralPattrens.facade;

/**
 * 파사드 패턴
 */
public class FacadeMain_v1 {
    static void main() {
        FacadeClass_v1 v1 = new FacadeClass_v1();
        v1.facadeMethod("hello", "facade", "world");
    }
}
