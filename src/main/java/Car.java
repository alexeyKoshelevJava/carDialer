import java.util.Random;

public class Car {
    private CarBrand carBrand;
    private CarColor carColor;

    public Car() {
        int idCarBrand = new Random().nextInt(CarBrand.values().length);
        carBrand = CarBrand.values()[idCarBrand];
        int idCarColor = new Random().nextInt(CarColor.values().length);
        carColor = CarColor.values()[idCarColor];
    }

    @Override
    public String toString() {
        return "Car{" +
                " " + carBrand +
                " " + carColor +
                '}';
    }
}