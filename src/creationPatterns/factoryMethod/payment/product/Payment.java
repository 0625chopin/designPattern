package creationPatterns.factoryMethod.payment.product;

// [팩토리 패턴 - 제품(Product) 역할]
// 팩토리가 생성해 반환하는 객체들의 공통 타입(추상)이다.
// 클라이언트는 이 인터페이스에만 의존하므로 구체 결제 수단(CardPayment, NaverPayment)을 몰라도 된다.
public interface Payment {
    void pay();
}
