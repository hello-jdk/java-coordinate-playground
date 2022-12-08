package carsdomain;

public class Avante extends Car{
    public Avante(int distance) {
        super(distance);
    }

    @Override
    double getDistancePerLiter() {
        return 0;
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
