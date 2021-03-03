public class Main {
    public static void main(String[] args) throws InterruptedException {
        CarDealer carDealer = new CarDealer();


        new Thread(carDealer::sellCar, "  Я покупатель 1").start();


        new Thread(carDealer::sellCar, "  Я покупатель 2").start();


        new Thread(carDealer::sellCar, "  Я покупатель 3").start();

        new Thread(carDealer::acceptCar, "Я поставщик").start();


    }

}
