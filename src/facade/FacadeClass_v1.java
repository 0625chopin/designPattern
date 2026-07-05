package facade;

public class FacadeClass_v1 {

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
