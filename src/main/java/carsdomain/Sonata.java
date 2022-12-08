package carsdomain;

public class Sonata extends Car {

    @Override

    double getDistancePerLiter() {
        return this.distance;
    }

    @Override
    double getTripDistance() {
        return 0;
    }

    @Override
    String getName() {
        return null;
    }

    @Override
    double getChargeQuantity() {
        return super.getChargeQuantity();
    }
}
