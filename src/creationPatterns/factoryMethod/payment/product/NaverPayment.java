package creationPatterns.factoryMethod.payment.product;

public class NaverPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Naver 페이 결제");
    }
}
