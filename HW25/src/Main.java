import java.util.function.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supplier<String> nameFactory = () -> {
            System.out.println("Введите имя человека:");
            return new Scanner (System.in).nextLine();
        };

        Supplier<Integer> ageFactory = () -> {
            System.out.println("Введите возраст:");
            return new Scanner (System.in).nextInt();
        };

        Supplier<Double> weightFactory = () -> {
            System.out.println("Введите вес:");
            return new Scanner (System.in).nextDouble();
        };

        Predicate<Human> isFullAged = (Human human) -> {
            if (human.getAge()>=18)
                System.out.println("Это совершеннолетний человек");
            else
                System.out.println("Это несовершеннолетний человек");
            return human.getAge()>=18;
        };

        Human human1 = new Human(nameFactory.get(), ageFactory.get(), weightFactory.get());
        Human human2 = new Human(nameFactory.get(), ageFactory.get(), weightFactory.get());

        System.out.println(human1);
        System.out.println(isFullAged.test(human1));
        System.out.println(human2);
        System.out.println(isFullAged.test(human2));
    }
}