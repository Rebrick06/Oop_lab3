import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class addRandomCar {
    private static Random rand = new Random();
    private static List<Supplier<Car>> cars = List.of(
            Volvo240::new,
            Saab95::new
    );

    public static Car createRandomCar(){
        return cars.get(rand.nextInt(cars.size())).get();
    }

}