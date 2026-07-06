package creationPatterns.abstrackFactory.sample;

import creationPatterns.abstrackFactory.sample.inf.AbstractFacory;
import creationPatterns.abstrackFactory.sample.inf.AbstractProductA;
import creationPatterns.abstrackFactory.sample.inf.AbstractProductB;
import creationPatterns.abstrackFactory.sample.product.ConcreatFactoryA;
import creationPatterns.abstrackFactory.sample.product.ConcreatFactoryB;

public class FactoryMain {
    static void main() {
        AbstractFacory facory = null;
        // A 공장군을 가동 시킨다.
        facory = new ConcreatFactoryA();
        AbstractProductA productA = facory.abstractProductA();
        System.out.println(productA.getClass().getName());

        // B 공장군을 가동 시킨다.
        facory = new ConcreatFactoryB();
        AbstractProductB productB = facory.abstractProductB();
        System.out.println(productB.getClass().getName());
    }
}
