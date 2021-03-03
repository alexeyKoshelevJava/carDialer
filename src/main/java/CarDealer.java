import java.util.ArrayList;
import java.util.List;

public class CarDealer {
    private static final int limiterCarForShop = 5;
    private static final int limiterCarForSell = 10;
    Manufacturer manufacturer = new Manufacturer(this);
    List<Car> listCars = new ArrayList<>();


    public void sellCar() {
        while (CounterCar.getInstance().getNum() < limiterCarForSell) {


            manufacturer.sellCar();
        }

    }


    public void acceptCar() {
        while (listCars.size() <= limiterCarForShop) {


            manufacturer.receiveCar();
        }
    }

    public List<Car> getListCars() {
        return listCars;
    }
}
