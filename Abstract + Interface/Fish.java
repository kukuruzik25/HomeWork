public class Fish extends Animal implements Swimmable {
    
    public Fish() {
        super();
    }
    
    public Fish(String name, int age) {
        super(name, age);
    }
    
    @Override
    public void makeSound() {
        System.out.println("...");
    }
    
    @Override
    public void swim() {
        System.out.println("Рыбка плывет");
    }
}