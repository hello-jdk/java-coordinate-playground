package carsdomain;

public class Sonata extends Car {
    private final double distancePerLiter =10L;

    public Sonata(int distance) {
        super(distance);
    }

    @Override
    double getDistancePerLiter() {
        return distancePerLiter;
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
