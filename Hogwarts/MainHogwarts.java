public class MainHogwarts {
	public static void main(String[] args) {

    	Wizard[] hogwarts = new Wizard[6]; 

    	hogwarts[0] = new HogwartsStudent("Гарри Поттер", 80, 15, 20, "Гриффиндор", 30);
        hogwarts[1] = new HogwartsStudent("Гермиона Грейнджер", 95, 16, 35, "Гриффиндор", 5);
        hogwarts[2] = new Professor("Альбус Дамблдор", 100, 150, 50, "Защита от тёмных искусств");
        hogwarts[3] = new Professor("Минерва МакГонагалл", 90, 60, 40, "Трансфигурация");
        hogwarts[4] = new MagicalCreature("Добби", 50, 100, 15, "Домовой эльф");
        hogwarts[5] = new MagicalCreature("Фоукс", 70, 200, 30, "Феникс");      

        System.out.println("=====INFO=====");   
        System.out.println(); 
        for (Wizard wizard : hogwarts) {
            wizard.displayInfo();
        }

        System.out.println("\nВсе кастуют заклинания...");
        for (Wizard wizard : hogwarts) {
            wizard.castSpell();
        }
        
        System.out.println("\nВсе магические существа используют способности...");
        for (Wizard wizard : hogwarts) {
            if (wizard instanceof MagicalCreature) {
                MagicalCreature creature = (MagicalCreature) wizard;
                creature.specialAbility();
            }
        }

        System.out.println("\nВосстановление маны студентов...");
        HogwartsStudent studLowMana = null;
        int lowMana = 1000;
        
        for (Wizard wizard : hogwarts) {
            if (wizard instanceof HogwartsStudent) {
                HogwartsStudent student = (HogwartsStudent) wizard;
                if (student.getMana() < lowMana) {
                    lowMana = student.getMana();
                    studLowMana = student;
                }
            }
        }
        
        if (studLowMana != null) {
            System.out.println("Студент с наименьшей маной: " + studLowMana.getName() + " (мана: " + studLowMana.getMana() + ")");
            studLowMana.rechargeMana(50);
        }
        
        System.out.println("\nСамый шаловливый студент: ");
        HogwartsStudent shalun = null;
        int highMischief = -1;
        
        for (Wizard wizard : hogwarts) {
            if (wizard instanceof HogwartsStudent) {
                HogwartsStudent student = (HogwartsStudent) wizard;
                if (student.getMischiefLevel() > shalun) {
                    highMischief = student.getMischiefLevel();
                    shalun = student;
                }
            }
        }
        
        if (shalun != null) {
            System.out.println("Самый шаловливый: " + shalun.getName() + " (уровень шалостей: " + shalun.getMischiefLevel() + ")");
            shalun.prank();
        }
        
        System.out.println("\nОбщая статистика:");
        Wizard.showAcademyStats();

    }
}