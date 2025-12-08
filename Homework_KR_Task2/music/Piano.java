public class Piano extends MusicalInstrument {

    private int keysCount;
    private boolean bigPiano;
    
    public Piano() {
        super("пианино", "ямальское", 150000);
        this.keysCount = 88;
        this.isGrand = false;
    }
    
    public Piano(String name, String brand, double price, int keysCount, boolean isGrand) {
        super(name, brand, price);
        setKeysCount(keysCount);
        this.isGrand = isGrand;
    }
    
    public void setKeysCount(int keysCount) {
        if (keysCount != 61 && keysCount != 76 && keysCount != 88) {
            System.out.println("Количество клавиш должно быть 61, 76 или 88!");
            return;
        }
        this.keysCount = keysCount;
    }
    
    public int getKeysCount() {
        return keysCount;
    }
    
    public boolean isGrand() {
        return isGrand;
    }
    
    @Override
    public void play() {
        System.out.println("Ляляляляяяя");
    }
    
    public void openLid() {
        System.out.println("Происходит открытие...");
    }
    
    public void playScale() {
        System.out.println("Игра до-ре-ми-фа-соль-ля-си-до");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество клавиш: " + keysCount);
        System.out.println("Мегапианино: " + (isGrand ? "да" : "нет"));
    }
}