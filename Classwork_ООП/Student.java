public class Student {

	private String firstName;
	private String lastName;
	private int age;
	private String group;
	private double avarageGrade;
	private boolean isActive;

	public Student() {
		this("Пробный", "Про", 18, "11-504", 100.0, true);
//			this.firstName = "Пробный";
//			this.lastName = "Про";
//			this.age = 18;
//			this.group = "11-504";
//			this.avarageGrade = 100.0;
//			this.isActive = true;
	}

	public Student(String firstName, String lastName, String group) {
		this(firstName, lastName, 18, group, 0.0, false);
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.age = 18;
//		this.group = group;
//		this.avarageGrade = 100.0;
//		this.isActive = true;
	}

	public Student(String firstName, String lastName, int age, String group, double avarageGrade, boolean isActive) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.group = group;
		this.avarageGrade = avarageGrade;
		this.isActive = isActive;
	}

	public String displayInfo() {
		String result = "Name: " + firstName + "\n" + "Surname: " + lastName + "\n" + "Group: " + group + "\n" + "Avarage Grade: " + avarageGrade + "\n" + "Active: " + isActive;
		return result;
	//	return result = firstName + "\n" + lastName + "\n" + group; - ошибка 
	}

	public String updateGrade(double newGrade) {
		double oldGrade = avarageGrade;
		avarageGrade = newGrade;
		return "Средний балл обновлен: " + oldGrade + " --> " + avarageGrade;
	}

	public String activateStudent() {
		this.isActive = true;
		return "Студент активирован. Присвойте номер группы";
	}

	public String deactivateStudent() {
		this.isActive = false;
		return "Студент ащислен..." + transferToNewGroup("-- - ---");
	}


	public String transferToNewGroup(String newGroup) {
		String oldGroup = group;
		this.group = newGroup;
		return "Группа изменена: " + oldGroup + " --> " + group;
	}
}