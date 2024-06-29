import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    private Random random = new Random();

    public void addToy(String name, double weight) {
        Toy toy = new Toy(name, weight);
        toys.add(toy);
    }

    public Toy drawToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomValue = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0.0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomValue <= cumulativeWeight) {
                return toy;
            }
        }
        return null; // Никогда не должно достигать этого значения, если totalWeight > 0
    }

    public static void main(String[] args) {
        ToyStore store = new ToyStore();
        store.addToy("Teddy Bear", 1.0);
        store.addToy("Lego Set", 2.0);
        store.addToy("Toy Car", 1.5);
        
        System.out.println("Drawn toy: " + store.drawToy());
    }
}