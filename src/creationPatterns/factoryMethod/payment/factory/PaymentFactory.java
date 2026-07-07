package creationPatterns.factoryMethod.payment.factory;

import creationPatterns.factoryMethod.payment.product.CardPayment;
import creationPatterns.factoryMethod.payment.product.NaverPayment;
import creationPatterns.factoryMethod.payment.product.Payment;

// [팩토리 패턴 - 팩토리(Factory) 역할]
// 객체 생성 로직을 한곳에 캡슐화한다. static create(String type)에서 문자열 타입을 switch로 분기해
// 알맞은 구체 제품(Payment)을 생성해 반환하고, 미지원 타입은 예외로 처리한다.
// (엄밀한 GoF 팩토리 메서드가 아니라 문자열 분기 기반의 단순 팩토리(Simple/Static Factory) 형태다.)
public class PaymentFactory {
    public static Payment create(String type) {

        switch (type.toUpperCase()) {

            case "CARD":
                return new CardPayment();

            case "NAVER":
                return new NaverPayment();

            default:
                throw new IllegalArgumentException("지원하지 않는 결제 방식");
        }
    }
}
