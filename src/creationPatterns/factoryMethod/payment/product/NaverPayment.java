package creationPatterns.factoryMethod.payment.product;

// [팩토리 패턴 - 구체 제품(ConcreteProduct) 역할]
// Payment 인터페이스를 구현한 실제 결제 수단 중 하나로, 네이버페이 결제 동작을 담당한다.
// 팩토리의 "NAVER" 분기에서 생성된다.
public class NaverPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Naver 페이 결제");
    }
}
