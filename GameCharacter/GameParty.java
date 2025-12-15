public class GameParty extends GameCharacter { 

	private String partyName;
    private GameCharacter[] partyMembers = new GameCharacter[10];

    public static int countPartyMembers = 0;
    public static final int MAX_PARTY_SIZE = 10;

    public GameParty(String partyName){
        this.partyName = partyName;
    }

    public static void main(String[] args) {
        GameParty party = new GameParty("топчики");
        Archer robin = new Archer("Робингут", 25, 100, 100, false, 150, 50, "Стрелы");
        Warrior king = new Warrior("Король",25, 500, 100, true, 50, 120, "Меч");
        Mage dambldor = new Mage("Дамблдор", 25, 100, 1000, true, 100, 120, "Котел волшебный");

        party.addCharacter(DrowRanger);
        party.addCharacter(WraithKing);
        party.addCharacter(Invoker);

        party.calculatePartyPower();
        party.useAllSpecialAbilities();

    }

    public void addCharacter(GameCharacter character){
        partyMembers[countPartyMembers] = character;
        countPartyMembers++;
        System.out.println("Добавлен новый персонаж: "  + character.name);
    }


    public void removeCharacter(String name){
        for (int i = 0; i < countPartyMembers; i++) {
            if (partyMembers[i].name.equals(name)){
                System.out.println("Персонаж удален: " + partyMembers[i].name);
                for (int j = i; j < countPartyMembers ; j++) {
                    partyMembers[j] = partyMembers[j+1];
                }
                countPartyMembers--;
                return;
            }
        }
        System.out.println("Персонажа с именем: "+ name + " не найден!");
    }

    public void useAllSpecialAbilities(){
        for (int i = 0; i < countPartyMembers ; i++) {
            partyMembers[i].useSpecialAbility();
        }
    }

    public void findCharactersByClass(String className){
        for (int i = 0; i < countPartyMembers ; i++) {
            if (partyMembers[i].getClass().equals(className)){
                System.out.println(partyMembers[i].name);
            }
        }
    }

    public void calculatePartyPower(){
        double partyPower = 0;
        for (int i = 0; i <countPartyMembers ; i++) {
            if (partyMembers[i] instanceof Warrior){
                partyPower =+ ((Warrior) partyMembers[i]).strenght;
            }else if (partyMembers[i] instanceof Mage){
                partyPower =+ ((Mage) partyMembers[i]).intelligence;
            }else if (partyMembers[i] instanceof Archer){
                partyPower =+ ((Archer) partyMembers[i]).agility;
            }
        }

        System.out.println("Текущая \"Сила\" (сумма: Силы, Интеллекта и Ловкости) = " + partyPower);
    }
}
