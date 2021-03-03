public class Manufacturer {
    private final CarDealer carDealer;
    private static final int sleepTimeForManufacturer = 3000;
    private static final int sleepTimeForConsumer = 1000;
    private static final int limiter = 10;
    CounterCar counterCar = CounterCar.getInstance();

    public Manufacturer(CarDealer carDealer) {
        this.carDealer = carDealer;

    }


    public synchronized void receiveCar() {


        try {
            System.out.print("Пришла новая машина: ");
            Thread.sleep(sleepTimeForManufacturer);
            carDealer.getListCars().add(new Car());
            System.out.println("Машина " +
                    carDealer.getListCars().get(carDealer.getListCars().size() - 1) + " выставлена на продажу");
            notifyAll();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void sellCar() {


        CounterCar counterCar = CounterCar.getInstance();

        try {
            System.out.println("Покупатель приходит в автосалон ");

            while (carDealer.getListCars().size() == 0) {
                System.out.println("Машин нет. Ждите! ");
                wait();
            }
            if (counterCar.getNum() < limiter) {
                Thread.sleep(sleepTimeForConsumer);
                System.out.println(Thread.currentThread().getName() + " Покупаю машину " + carDealer.getListCars().remove(0));
                counterCar.count();


            } else {
                System.out.println(" Продали " + limiter + ". План Выполнен. Больше сегодня не продаем! Приходи Завтра!");


            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}




