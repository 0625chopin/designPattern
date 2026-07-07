package creationPatterns.factoryMethod.payment.client;

import creationPatterns.factoryMethod.payment.factory.PaymentFactory;
import creationPatterns.factoryMethod.payment.product.Payment;

/**
 * Factory Method 패턴은 객체 생성(Create) 로직을 별도의 Factory 클래스(또는 메서드)로 분리하는 생성(Creational) 디자인 패턴입니다.
 *
 * 핵심 목적은 객체를 생성하는 코드를 사용하는 코드(Client)와 분리하여 새로운 객체 타입이 추가되더라도 기존 코드를 최소한으로 수정
 */
// [팩토리 패턴 - 클라이언트(Client) 역할, 진입점]
// 팩토리에 문자열("CARD"/"NAVER")만 넘겨 Payment 객체를 얻고 pay()를 호출한다.
// new 키워드로 구체 클래스를 직접 생성하지 않으므로 구체 결제 수단에 의존하지 않는다.
public class Main {
    static void main() {
        Payment payment1 = PaymentFactory.create("CARD");
        payment1.pay();

        Payment payment3 = PaymentFactory.create("NAVER");
        payment3.pay();
    }
}
