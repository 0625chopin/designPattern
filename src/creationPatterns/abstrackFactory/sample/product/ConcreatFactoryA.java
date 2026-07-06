package creationPatterns.abstrackFactory.sample.product;


import creationPatterns.abstrackFactory.sample.inf.AbstractFacory;
import creationPatterns.abstrackFactory.sample.inf.AbstractProductA;
import creationPatterns.abstrackFactory.sample.inf.AbstractProductB;

public class ConcreatFactoryA implements AbstractFacory {

    @Override
    public AbstractProductA abstractProductA() {
        return new ConcreatProductA1();
    }

    @Override
    public AbstractProductB abstractProductB() {
        return new ConcreatProductB1();
    }
}
