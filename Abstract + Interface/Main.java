public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog("Локи", 3);
        Fish fish = new Fish("Фатима", 1);
        Duck duck = new Duck("Евлампий", 2);
        
        System.out.println("=====ИНФО=====");
        System.out.println(dog.displayInfo());
        System.out.println(fish.displayInfo());
        System.out.println(duck.displayInfo());
        System.out.println();
        
        System.out.println("=====ЗВУКИ=====");
        dog.makeSound();
        fish.makeSound();
        duck.makeSound();
        System.out.println();
        
        System.out.println("=====СОН-ЧАС=====");
        dog.sleep();
        fish.sleep();
        duck.sleep();
        System.out.println();
        
        System.out.println("=====БЕГАЮТ-ПРЫГАЮТ=====");
        System.out.print("Собачка: ");
        dog.run();
        
        System.out.print("Рыбка: ");
        fish.swim();
        
        System.out.print("Уточка1: ");
        duck.run();
        System.out.print("Уточка2: ");
        duck.swim();
        System.out.println();
        
        System.out.println("=====МАКС СКОРОСТЬ=====");
        Runnable dogRunner = dog;
        Runnable duckRunner = duck;
        System.out.println("Собачка: " + dogRunner.getMaxSpeed() + " км/ч");
        System.out.println("Уточка: " + duckRunner.getMaxSpeed() + " км/ч");
    }
}