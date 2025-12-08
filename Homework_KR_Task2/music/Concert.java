public class Concert {

    private String name;
    private int capacity;
    
    public ConcertHall() {
        this("Большой зал", 1000);
    }
    
    public ConcertHall(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
    }
    
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Введите название зала!");
            return;
        }
        this.name = name;
    }
    
    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Вместимость должна быть больше 0!");
            return;
        }
        this.capacity = capacity;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void open() {
        System.out.println("Концертный зал '" + name + "' открыт");
        System.out.println("Вместимость: " + capacity + " человек");
    }
    
    public void hostConcert(Musician musician) {
        System.out.println("=====Концерт=====");
        System.out.println("В зале: " + name);
        musician.perform();
        System.out.println();
    }
}