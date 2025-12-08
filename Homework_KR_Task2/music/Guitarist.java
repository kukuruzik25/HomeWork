public class Guitarist extends Musician {
    
	private String style;
    
    public Guitarist() {
        super("Павл", 12);
        this.style = "hard-rock";
    }
    
    public Guitarist(String name, int experienceYears, String style) {
        super(name, experienceYears);
        setStyle(style);
    }
    
    public void setStyle(String style) {
        if (style == null || style.trim().isEmpty()) {
            System.out.println("Введите стиль игры!");
            return;
        }
        this.style = style;
    }
    
    public String getStyle() {
        return style;
    }
    
    @Override
    public void practice() {
        System.out.println(getName() + " (гитарист) репетирует свою фигню");
        System.out.println("Стиль: " + style);
    }
    
    @Override
    public void broknabednom() {
        System.out.println(getName() + " играет пошел нафик брок на бедном");
    }
    
    public void playSolo() {
        System.out.println(getName() + " играет песню ивана золо");
    }
}