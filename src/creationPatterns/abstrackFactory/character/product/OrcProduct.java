package creationPatterns.abstrackFactory.character.product;

import creationPatterns.abstrackFactory.character.model.Status;

public class OrcProduct implements StatProduct{


    Status status = null;

    public OrcProduct(Status status) {
        this.status = status;
    }


    @Override
    public String armor() {
        return status.getArmor();
    }

    @Override
    public String skill() {
        return status.getSkill();
    }
}
