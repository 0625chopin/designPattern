package creationPatterns.factoryMethod.payment.product;

public class CardPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("카드 결제");
    }
}
