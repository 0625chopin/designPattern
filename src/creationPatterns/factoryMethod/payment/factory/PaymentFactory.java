package creationPatterns.factoryMethod.payment.factory;

import creationPatterns.factoryMethod.payment.product.CardPayment;
import creationPatterns.factoryMethod.payment.product.NaverPayment;
import creationPatterns.factoryMethod.payment.product.Payment;

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
