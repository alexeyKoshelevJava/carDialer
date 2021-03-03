import java.util.Date;

public class CounterCar {

    private static CounterCar instance = null;

    protected int num = 0;

    private CounterCar() {
    }


    public void count() {

        System.out.println("[" + "Магазин продал " + (num + 1) + " машину " + "] ");
        num = num + 1;


    }

    public static CounterCar getInstance() {
        if (instance == null) instance = new CounterCar();
        return instance;
    }

    public int getNum() {
        return num;
    }
}

