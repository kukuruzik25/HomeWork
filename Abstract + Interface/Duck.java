public class Duck extends Animal implements Runnable, Swimmable {
    
    public Duck() {
        super();
    }
    
    public Duck(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println("Кря!");
    }
    
    @Override
    public void run() {
        System.out.println("Уточка бежит");
    }
    
    @Override
    public void swim() {
        System.out.println("Уточка плывет");
    }
}