import carsdomain.Car;
import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private final List<Car> cars;

    private RentCompany(List<Car> cars) {
        this.cars = cars;
    }

    public static RentCompany create() {
        return new RentCompany(new ArrayList<>());
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        cars.forEach(car -> {
            stringBuilder
                    .append(car.toString())
                    .append(System.getProperty("line.separator"));
        });
        return stringBuilder.toString();
    }
}
