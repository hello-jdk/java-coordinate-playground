package carsdomain;

public abstract class Car implements Vehicle{
    protected int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    /**
     * 리터당 이동 거리. 즉, 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 여행하려는 거리
     */
    abstract double getTripDistance();

    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    @Override
    public String toString() {
        return makeReport();
    }

    private String makeReport() {
        String carName = this.getName();
        String chargeQuantity = String.format("%.0f", this.getChargeQuantity());
        return carName + " : " + chargeQuantity+"리터";
    }
}
