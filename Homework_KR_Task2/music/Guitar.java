public class Guitar extends MusicalInstrument {
	
	private int stringsCount;
    private String type; 
    
    public Guitar() {
        super("Гитара", "Fender", 25000);
        this.stringsCount = 6;
        this.type = "electric";
    }
    
    public Guitar(String name, String brand, double price, int stringsCount, String type) {
        super(name, brand, price);
        setStringsCount(stringsCount);
        setType(type);
    }
    
    public void setStringsCount(int stringsCount) {
        if (stringsCount < 4 || stringsCount > 12) {
            System.out.println("Количество струн должно быть от 4 до 12!");
            return;
        }
        this.stringsCount = stringsCount;
    }
    
    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            System.out.println("Введите тип гитары!");
            return;
        }
        this.type = type;
    }
    
    public int getStringsCount() {
        return stringsCount;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public void play() {
        System.out.println("Играет бр-рынь-трунь");
    }
    
    public void changeStrings() {
        System.out.println("Поменять струны на гитаре...");
    }
    
    public void playChord(String chord) {
        System.out.println("Играть аккорд... " + chord);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество струн: " + stringsCount);
        System.out.println("Тип: " + type);
    }
}