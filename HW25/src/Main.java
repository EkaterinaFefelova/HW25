import java.util.function.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supplier<Human> humanFactory = () -> {
            System.out.println("Введите имя человека:");
            String name = new Scanner (System.in).nextLine();
            System.out.println("Введите возраст:");
            int age = new Scanner (System.in).nextInt();
            System.out.println("Введите рост в см:");
            double height = new Scanner (System.in).nextDouble();
            return new Human(name, age, height);
        };

        Predicate<Human> isFullAged = (Human human) -> {
            System.out.println("Это " + (human.getAge()>=18 ? "совершеннолетний": "несовершеннолетний") + " человек");
            return human.getAge()>=18;
        };

        Human human1 = humanFactory.get();
        Human human2 = humanFactory.get();


        System.out.println(human1);
        isFullAged.test(human1);
        System.out.println(human2);
        isFullAged.test(human2);
    }
}