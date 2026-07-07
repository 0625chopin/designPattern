package creationPatterns.abstractMethod.character.product.weapon;

// [추상 팩토리 패턴 - 추상 제품 A(AbstractProductA) 역할]
// 무기 제품군의 공통 인터페이스로, 종족에 상관없이 무기를 다루는 규격을 정의한다.
public interface Weapon {
    void equipWepon();
}
