package creationPatterns.abstrackFactory.sample.product;

import creationPatterns.abstrackFactory.sample.inf.AbstractFacory;
import creationPatterns.abstrackFactory.sample.inf.AbstractProductA;
import creationPatterns.abstrackFactory.sample.inf.AbstractProductB;

public class ConcreatFactoryB implements AbstractFacory {
    @Override
    public AbstractProductB abstractProductB() {
        return new ConcreatProductB2();
    }

    @Override
    public AbstractProductA abstractProductA() {
        return new ConcreatProductA2();
    }
}
