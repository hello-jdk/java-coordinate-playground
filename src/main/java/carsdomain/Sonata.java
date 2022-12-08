package carsdomain;

public class Sonata extends Car {

    public Sonata(int distance) {
        super(distance);
    }

    @Override
    double getDistancePerLiter() {
        return 10L;
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return "Sonata";
    }

    @Override
    double getChargeQuantity() {
        return super.getChargeQuantity();
    }
}
