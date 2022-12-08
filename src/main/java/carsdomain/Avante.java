package carsdomain;

public class Avante extends Car{
    public Avante(int distance) {
        super(distance);
    }

    @Override
    double getDistancePerLiter() {
        return 15L;
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return "Avante";
    }

    @Override
    double getChargeQuantity() {
        return super.getChargeQuantity();
    }
}
